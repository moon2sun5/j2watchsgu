package com.sgu.j2watch.controllers;

import java.util.*;
import java.util.stream.Collectors;

import com.sgu.j2watch.DTOs.CartProductDTO;
import com.sgu.j2watch.entities.*;
import com.sgu.j2watch.repositories.ProductDetailRepository;
import com.sgu.j2watch.repositories.ProductRepositoryJPA;
import com.sgu.j2watch.serviceImpl.ProductFSServiceImpl;
import com.sgu.j2watch.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sgu.j2watch.repositories.BrandRepository;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.repositories.UserRepository;

// Cach 1 - dung @Controller
@Controller
@RequestMapping(path = "home")
public class HomePageController {
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private ProductFSService productFSService;
    @Autowired
    private ProductService productService;
    @Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;
	

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String HomePage(Model model) {
    	List<Product> list = this.productService.productBestSeller();
    	System.out.println(list);
    	model.addAttribute("proBest", list);
        return "Home/MainPage/HomePage";
    }

    @GetMapping("/lienhe")
    public String contact() {
        return "Home/MainPage/Contact";
    }

    private int size = 6; 	// Số sản phẩm trong 1 trang
    @GetMapping("/donghonam/page={page}")
    public String malewatch2(@PathVariable(value = "page", required = false) int page, Model model){

        List<ProductFS> result = productFSService.findProductsAndBrandsWithCategoryAndPages(4, (page-1)*size, size);

        int totalPages = (int) Math.ceil(( double) productFSService.findTotalProducts(4)/size);

        if(page <= 0){
            page = 1;
        }
        if(page > totalPages){
            page = totalPages;
        }

        model.addAttribute("products", result);
        model.addAttribute("totalProducts", productFSService.findTotalProducts(4));
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("listCategory", categoryRepository.findAll());
		model.addAttribute("listBrand", brandRepository.findAll());

        return "Home/MainPage/MaleWatch";
    }

    @GetMapping("/donghonu/page={page}")
    public String femalewatch(@PathVariable(value = "page", required = false) int page,Model model) {

        List<ProductFS> result = productFSService.findProductsAndBrandsWithCategoryAndPages(5, (page-1)*size, size);

        int totalPages = (int) Math.ceil(( double) productFSService.findTotalProducts(5)/size);

        if(page <= 0){
            page = 1;
        }
        if(page > totalPages){
            page = totalPages;
        }

        model.addAttribute("products", result);
        model.addAttribute("totalProducts", productFSService.findTotalProducts(5));
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("listCategory", categoryRepository.findAll());
		model.addAttribute("listBrand", brandRepository.findAll());
        return "Home/MainPage/FemaleWatch";

    }


    @Autowired
    private ProductDetailRepository productDetailRepository;

    @GetMapping("/chitietsanpham/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        ProductDetail result = productDetailRepository.findProductDetailByID(id);
        model.addAttribute("productDetail", result);
        if(result.getProductQuantity() <= 0){
            model.addAttribute("OOS", true);
        }
        else{
            model.addAttribute("OOS",false);
        }
//		System.out.println(result.toString());
        return "Home/MainPage/DetailProduct";
    }

    private Map<Integer, Cart> getOrCreateCart(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    private ProductFSServiceImpl productFSServiceImpl;
    @PostMapping("/chitietsanpham/add-to-cart")
    public String add_to_cart(
            @RequestParam("id") int productID,
            @RequestParam("quantity") int quantity,
            HttpServletRequest request,
            HttpSession session
    ){
        boolean login = true;
        if(login == true) {
            List<ProductFS> allProductFS = productFSService.findProductsAndBrands();
            Map<Integer, Cart> cart = getOrCreateCart(session);
            Cart cartItem = cart.getOrDefault(productID, new Cart());
            Optional<ProductFS> productOptional = allProductFS.stream()
                    .filter(product -> product.getProductID() == productID)
                    .findFirst();
            productOptional.ifPresent(product -> {
                cartItem.setProductID(productID);
                if (cartItem.getQuantity() + quantity >= product.getProductQuantity()) {
                    cartItem.setQuantity(product.getProductQuantity());
                } else {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                }
                cart.put(productID, cartItem);
            });
            System.out.println("Printing the cart map:");
            for (Map.Entry<Integer, Cart> entry : cart.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            return "redirect:/home/giohang";
        }
        else{
            return "redirect:/home/giohang";
        }
        //return "redirect:" + request.getHeader("Referer");
    }

    private List<CartProductDTO> transferMapCart(List<Cart> cartItems){
        List<ProductFS> allProductFS = productFSService.findProductsAndBrands();
        List<CartProductDTO> cartProductList = new ArrayList<>();
        for (Cart cartItem : cartItems){
            Optional<ProductFS> productOptional = allProductFS.stream()
                    .filter(product -> product.getProductID() == cartItem.getProductID())
                    .findFirst();
            productOptional.ifPresent(product -> {
                CartProductDTO cartProductDTO = new CartProductDTO();
                cartProductDTO.setId(product.getProductID());
                cartProductDTO.setName(product.getProductName());
                cartProductDTO.setImg(product.getProductImg());
                cartProductDTO.setPrice(product.getProductPrice());
                cartProductDTO.setQuantity(cartItem.getQuantity());
                cartProductDTO.setQuantityRemain(product.getProductQuantity());
                cartProductList.add(cartProductDTO);
            });
        }
        return cartProductList;
    }

    private float totalPrice(List<CartProductDTO> cartItems){
        float total = 0;
        for( CartProductDTO item: cartItems){
            total += ((float)item.getQuantity()*item.getPrice());
        }
        return total;
    }

    private float totalBill(List<CartProductDTO> cartItems){
        float total = 0;
        for( CartProductDTO item: cartItems){
            total += ((float)item.getQuantity()*item.getPrice());
        }
        total+=30000;
        return total;
    }
    @GetMapping("/giohang")
    public String card(
            HttpSession session,
            Model model) {

        Map<Integer, Cart> cart = getOrCreateCart(session);
        List<Cart> cartItems = cart.values().stream().collect(Collectors.toList());
        List<CartProductDTO> cartProductList = transferMapCart(cartItems);

        model.addAttribute("totalPrice", totalPrice(cartProductList));
        model.addAttribute("cartProductList", cartProductList);
        return "Home/MainPage/Card";
    }

    @PostMapping("/giohang/updateQuantity")
    @ResponseBody
    public ResponseEntity<Float> updateQuantity(
            @RequestParam Integer id,
            @RequestParam Integer quantity,
            HttpSession session,
            Model model) {
        List<ProductFS> allProductFS = productFSService.findProductsAndBrands();
        Map<Integer, Cart> cart = getOrCreateCart(session);
        Float price;
        if(cart.containsKey(id)){
            Optional<ProductFS> productOptional = allProductFS.stream()
                    .filter(product -> product.getProductID() == cart.get(id).getProductID())
                    .findFirst();
            productOptional.ifPresent(product -> {
                if( quantity >= product.getProductQuantity()) {
                    cart.get(id).setQuantity(product.getProductQuantity());
                }
                else{
                    cart.get(id).setQuantity(quantity);
                }
                System.out.println("Quantity of Cart with id " + id + " updated to: " + quantity);
            });
        } else {
            System.out.println("Cart with id " + id + " not found");
        }

        System.out.println("Map after update: " + cart);
        List<Cart> cartItems = cart.values().stream().collect(Collectors.toList());
        List<CartProductDTO> cartProductList = transferMapCart(cartItems);
        model.addAttribute("totalPrice", totalPrice(cartProductList));
        model.addAttribute("cartProductList", cartProductList);
        return ResponseEntity.ok(totalPrice(cartProductList));
    }

    @PostMapping("/giohang/deleteItem")
    @ResponseBody
    public ResponseEntity<?> deleteItem(
            @RequestParam Integer id,
            HttpSession session,
            Model model
    ) {
        Map<Integer, Cart> cart = getOrCreateCart(session);
        if(cart.containsKey(id)){
            cart.remove(id);
            System.out.println("Item in Cart with id " + id + " deleted");
        } else {
            System.out.println("Item in Cart with id " + id + " not found");
        }
        System.out.println("Map after delete: " + cart);
        List<Cart> cartItems = cart.values().stream().collect(Collectors.toList());
        List<CartProductDTO> cartProductList = transferMapCart(cartItems);
        model.addAttribute("totalPrice", totalPrice(cartProductList));
        model.addAttribute("cartProductList", cartProductList);
        return ResponseEntity.ok(cartProductList);
    }

    @GetMapping("/giohang/thanhtoan")
    public String payment(HttpSession session,
                          Model model) {
        Map<Integer, Cart> cart = getOrCreateCart(session);
        List<Cart> cartItems = cart.values().stream().collect(Collectors.toList());
        List<CartProductDTO> cartProductList = transferMapCart(cartItems);
        model.addAttribute("totalPrice", totalPrice(cartProductList));
        model.addAttribute("cartProductList", cartProductList);
        return "Home/MainPage/Payment";
    }


    @PostMapping("/giohang/thanhtoan/ondoing")
    public String paymentProcess(HttpSession session,
                                 Model model,
                                 @RequestParam("fullname") String fullname,
                                 @RequestParam("deliver_address") String deliver_address,
                                 @RequestParam("dienthoai") String dienthoai,
                                 @RequestParam("email") String email,
                                 @RequestParam("description_bill") String description_bill,
                                 @RequestParam(name="voucher", required = false) Integer voucher) {
        Map<Integer, Cart> cart = getOrCreateCart(session);
        List<Cart> cartItems = cart.values().stream().collect(Collectors.toList());
        List<CartProductDTO> cartProductList = transferMapCart(cartItems);

        for (CartProductDTO cartItem: cartProductList){
            Product product = productService.findById(cartItem.getId());
            product.setQuantity(product.getQuantity()-cartItem.getQuantity());
            productService.save(product);
        }

        Bill saveBill;
        if(voucher!=null) {
            Voucher voucherObject = voucherService.getVoucherById(voucher);
            saveBill = billService.saveData(deliver_address, totalBill(cartProductList)*(100-voucherObject.getValue())/100, 1, voucher, 1, dienthoai, fullname, email, description_bill);
        }
        else{
            saveBill = billService.saveData(deliver_address, totalBill(cartProductList), 1, voucher, 1, dienthoai, fullname, email, description_bill);
        }
        billDetailService.saveData(saveBill,cartProductList);
        cart.clear();
        return "redirect:/home/giohang/thanhtoan/camon";
    }

    @PostMapping("/giohang/thanhtoan/checkVoucher")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkVoucher(
            @RequestParam String voucher,
            HttpSession session,
            Model model
    ) {
        Map<String, Object> response = new HashMap<>();
        if(!voucher.isEmpty() || !voucher.isBlank()) {
            Voucher voucherObject = voucherService.findByCode(voucher);
            if (voucherObject != null) {
                Date currentDate = new Date();
                int result1 = currentDate.compareTo(voucherObject.getStart_Date());
                int result2 = currentDate.compareTo(voucherObject.getEnd_Date());

                if (result1 < 0) {
                    response.put("message", "Chưa tới ngày áp dụng voucher");
                } else if (result2 > 0) {
                    response.put("message", "Voucher đã hết hạn sử dụng");
                } else {
                    response.put("message", "Đã áp dụng voucher - Giảm " + voucherObject.getValue() + "%");
                    response.put("discount", voucherObject);
                }
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Không tìm thấy voucher");
            }
        }
        else{
            response.put("message",null);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/giohang/thanhtoan/camon")
    public String thankyou() {
        return "Home/MainPage/Thankyou";
    }

}