package com.sgu.j2watch.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sgu.j2watch.DTOs.ProDetailDTO;
import com.sgu.j2watch.DTOs.ProductDTO;
import com.sgu.j2watch.entities.Newproduct;
import com.sgu.j2watch.entities.ProDetail;
import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.ProDetailRepository;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.services.BrandService;
import com.sgu.j2watch.services.CategoryService;
import com.sgu.j2watch.services.MaterialGlassService;
import com.sgu.j2watch.services.MaterialWireService;
import com.sgu.j2watch.services.PinService;
import com.sgu.j2watch.services.ProDetailSrevice;
import com.sgu.j2watch.services.ProductDetailService;
import com.sgu.j2watch.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/admin")
@Validated
public class ProductController {
	private final ProductRepository productRepository;
    private final ProDetailRepository prodetailRepository;
    private final ProDetailSrevice prodetailService;
    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final MaterialGlassService materialGlassService;
    private final MaterialWireService materialWireService;
    private final PinService pinService;
    private ProDetail prodetailDTO;
	private Product productDTO;

    @Autowired
    public ProductController(
    		ProDetailSrevice prodetailService,
            ProDetailRepository prodetailRepository,
            ProductRepository productRepository,
            ProductService productService,
            BrandService brandService,
            CategoryService categoryService,
            MaterialGlassService materialGlassService,
            MaterialWireService materialWireService,
            PinService pinService
    ) {
    	this.productRepository = productRepository;
    	this.prodetailService = prodetailService;
        this.prodetailRepository = prodetailRepository;
        this.productService = productService;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.materialGlassService = materialGlassService;
        this.materialWireService = materialWireService;
        this.pinService = pinService;
    }

    @GetMapping("/qlsanpham")
    public String qlsanpham(Model model) {
        model.addAttribute("listProduct", productService.getAllProducts());
        model.addAttribute("listProdetail", prodetailRepository.findAll());
        model.addAttribute("listBrand", brandService.getAllBrands());
        model.addAttribute("listCategory", categoryService.getAllCategories());
        model.addAttribute("listMaterialGlass", materialGlassService.getAllMaterialGlasses());
        model.addAttribute("listMaterialWire", materialWireService.getAllMaterialWires());
        model.addAttribute("listPin", pinService.getAllPins());
        return "Admin/FormManager/M_Sanpham";
    }

    @GetMapping("/qlsanpham/addsanpham")
    public String addsanpham(Model model, HttpServletRequest request) {
        ProductDTO productDTO = new ProductDTO();
        
//        ProDetailDTO prodetailDTO = new ProDetailDTO();
        Newproduct newproduct = new Newproduct();
        model.addAttribute("prodetailDTO", prodetailDTO);
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("listBrand", brandService.getAllBrands());
        model.addAttribute("listCategory", categoryService.getAllCategories());
        model.addAttribute("listMaterialGlass", materialGlassService.getAllMaterialGlasses());
        model.addAttribute("listMaterialWire", materialWireService.getAllMaterialWires());
        model.addAttribute("listPin", pinService.getAllPins());
        newproduct.setProduct(new Product());
        newproduct.setProdetail(new ProDetail());
//        model.addAttribute("product",productDTO);
        ProDetail prodetail = new ProDetail();
        return "Admin/FormAdd/A_Sanpham";
    }

    @PostMapping("/qlsanpham/addsanpham")
    public String saveSanpham(Model model, @ModelAttribute("productDTO") ProductDTO dto, ProDetail prodetail, HttpServletRequest request) {
        Product product;
//        ProDetail prodetail = new ProDetail();
        
        boolean isNew = dto.getidProduct() == null; // Check if it's a new product

        // If updating an existing product, retrieve it from the database
        if (!isNew) {
            Optional<Product> optionalProduct = productService.getProductById(dto.getidProduct());
            if (optionalProduct.isPresent()) {
                product = optionalProduct.get();
            } else {
                // Handle the case where the ID is not null, but the product does not exist
                return "redirect:/admin/error";
            }
        } else {
            // If creating a new product, instantiate a new Product object
            product = new Product();
//            prodetail = new ProDetail();
        }
        System.out.println(product.getIdProduct());
        
        // Map dto to product entity
        // Assuming that the dto method names match the entity property names
        // Replace with actual property names and mapping logic
        product.setName(dto.getName());
//        product.setDescription(dto.getDescription());
        product.setPrice(0f);
        product.setQuantity(0);
        // ... map other properties as needed ...

        // Check if the image file is not null and not empty
        if (dto.getImg() != null && !dto.getImg().isEmpty()) {
            try {
                // Define the path where the image will be saved
                String uploadDir = "G:\\LUU C\\Documents\\GitHub\\j2watchsgu\\src\\main\\resources\\static\\img";
                Path uploadPath = Paths.get(uploadDir);

                // Create directories if they do not exist
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Save the image file
                String fileName = dto.getImg().getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(dto.getImg().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Set the image name to the product
                product.setImg(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the image upload error
                return "redirect:/admin/uploadError";
            }
        }
//        product.setColor(dto.getColor());
        product.setCategory(dto.getCategory());
        product.setBrand(dto.getBrand());
        product.setPin(dto.getPin());
        product.setMaterialWire(dto.getMaterialWire());
        product.setMaterialGlassId(dto.getMaterialGlassId());
        // Save the product to the database
        productService.saveProduct(product);
        prodetail.setId_product(product.getIdProduct());
        prodetail.setDescription(request.getParameter("description"));
        prodetail.setColor(request.getParameter("color"));
        prodetail.setCode("DONGHOABC");
        prodetail.setShape(request.getParameter("shape"));
        prodetail.setSize(request.getParameter("size"));
        prodetail.setWater_resistance(request.getParameter("water_resistance"));
        prodetail.setGender("Chung");
        prodetail.setOrigin(request.getParameter("origin"));
        prodetailRepository.save(prodetail);
        // Redirect appropriately after saving the product
        return "redirect:/admin/qlsanpham";
    }

    @GetMapping("/qlsanpham/delete/{id}")
    public String deleteSanpham(@PathVariable("id") Integer id) {
        if (id != null) {
        	prodetailRepository.deleteById(id);
            productService.deleteProduct(id);
            return "redirect:/admin/qlsanpham";
        } else {
            // Xử lý trường hợp ID là null
            return "redirect:/admin/qlsanpham";
        }
    }

    @GetMapping("/qlsanpham/edit/{id}")
    public String editSanpham(@PathVariable("id") Integer id, Model model,ProDetail prodetail) {
        Optional<Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            model.addAttribute("productDTO", product);
            model.addAttribute("product", product);
            model.addAttribute("listBrand", brandService.getAllBrands());
            model.addAttribute("listCategory", categoryService.getAllCategories());
            model.addAttribute("listMaterialGlass", materialGlassService.getAllMaterialGlasses());
            model.addAttribute("listMaterialWire", materialWireService.getAllMaterialWires());
            model.addAttribute("listPin", pinService.getAllPins());
            
            return "Admin/FormEdit/E_Sanpham";
        } else {
            return "redirect:/admin/qlsanpham";
        }
    }

    @PostMapping("/qlsanpham/update/{id}")
    public String updateSanpham(@PathVariable("id") Integer id, @ModelAttribute("productDTO") ProductDTO dto, @ModelAttribute("prodetail") ProDetail prodetail, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            // Thêm thuộc tính và quay lại form nếu có lỗi
            // Thêm các thuộc tính cần thiết cho form
            return "Admin/FormEdit/E_Sanpham";
        }

        // Lấy thông tin Product và ProDetail hiện có
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (!optionalProduct.isPresent()) {
            // Xử lý trường hợp không tồn tại sản phẩm
            return "redirect:/admin/error";
        }

        // Bắt đầu quá trình cập nhật
        Product product = optionalProduct.get();
        ProDetail prodetail1 = new ProDetail();

        // Ánh xạ ProductDTO sang entity Product
        product.setName(productDTO.getName());
        // ... ánh xạ các thuộc tính khác của product ...

        // Ánh xạ ProDetailDTO sang entity ProDetail
        prodetail1.setDescription(prodetailDTO.getDescription());
        prodetail1.setColor(prodetailDTO.getColor());
        // ... ánh xạ các thuộc tính khác của prodetail ...

        // Lưu ProDetail
        prodetailService.saveProdetail(prodetail1);

//        // Kết hợp ProDetail với Product
//        product.setProdetail(dto.getProDetail);

        // Lưu Product
        productService.saveProduct(product);

        return "redirect:/admin/qlsanpham";
    }

    // ... các phương thức khác ...

    // Có thể bạn cần các phương thức tiện ích để chuyển đổi từ entity sang DTO
}

