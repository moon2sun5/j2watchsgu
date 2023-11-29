package com.sgu.j2watch.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.services.BrandService;
import com.sgu.j2watch.services.CategoryService;
import com.sgu.j2watch.services.MaterialGlassService;
import com.sgu.j2watch.services.MaterialWireService;
import com.sgu.j2watch.services.PinService;


@Controller
@RequestMapping(path = "/admin")
@Validated
public class ProductController {

    private final ProductRepository productRepository;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final MaterialGlassService materialGlassService;
    private final MaterialWireService materialWireService;
    private final PinService pinService;

    @Autowired
    public ProductController(
        ProductRepository productRepository,
        BrandService brandService,
        CategoryService categoryService,
        MaterialGlassService materialGlassService,
        MaterialWireService materialWireService,
        PinService pinService
    ) {
        this.productRepository = productRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.materialGlassService = materialGlassService;
        this.materialWireService = materialWireService;
        this.pinService = pinService;
    }

    @GetMapping("/qlsanpham")
    public String qlsanpham(Model model) {
        model.addAttribute("listProduct", productRepository.findAll());
        return "Admin/FormManager/M_Sanpham";
    }

    @GetMapping("/qlsanpham/addsanpham")
    public String addsanpham(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listBrand", brandService.getAllBrands());
        model.addAttribute("listCategory", categoryService.getAllCategories());
        model.addAttribute("listMaterialGlass", materialGlassService.getAllMaterialGlasses());
        model.addAttribute("listMaterialWire", materialWireService.getAllMaterialWires());
        model.addAttribute("listPin", pinService.getAllPins());
        return "Admin/FormAdd/A_Sanpham";
    }
    public String saveFile(MultipartFile file) throws IOException {
        // Thư mục lưu trữ - thay đổi đường dẫn theo cấu hình của bạn
        String uploadDir = "j2watchsgu\\bin\\src\\main\\resources\\static\\img";
        
        // Tạo tên file duy nhất để tránh ghi đè
        String originalFilename = file.getOriginalFilename();
        String filename = System.currentTimeMillis() + "_" + originalFilename;
        
        // Lưu trữ file
        Path copyLocation = Paths.get(uploadDir + File.separator + filename);
        Files.copy(file.getInputStream(), copyLocation);
        
        return filename; // Trả về tên file để lưu trong cơ sở dữ liệu
    }
    @PostMapping("/qlsanpham/addsanpham")
    public String saveSanpham(@RequestParam("img") MultipartFile imgFile, @ModelAttribute Product product) {
        if (!imgFile.isEmpty()) {
            try {
                // Lưu file và lấy tên file
                String filename = saveFile(imgFile);
                // Cập nhật đường dẫn file vào sản phẩm
                product.setImg(filename); // Đảm bảo rằng bạn lưu đường dẫn tương đối hoặc tuyệt đối phù hợp

                // Lưu thông tin sản phẩm vào cơ sở dữ liệu
                productRepository.save(product);

                return "redirect:/admin/qlsanpham";
            } catch (IOException e) {
                // Xử lý lỗi ở đây, ví dụ: log lỗi hoặc thiết lập một thông báo lỗi trong model
                e.printStackTrace();
            }
        }

        // Nếu không có file hoặc có lỗi, bạn có thể xử lý tại đây và quay lại trang tương ứng
        return "redirect:/admin/qlsanpham/addsanpham";
    }

	@GetMapping("/qlsanpham/delete/{id}")
    public String deleteSanpham(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
        return "redirect:/admin/qlsanpham";
    }

    @GetMapping("/qlsanpham/edit/{id}")
    public String editSanpham(@PathVariable("id") Integer id, Model model) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("listBrand", brandService.getAllBrands());
            model.addAttribute("listCategory", categoryService.getAllCategories());
            model.addAttribute("listMaterialGlass", materialGlassService.getAllMaterialGlasses());
            model.addAttribute("listMaterialWire", materialWireService.getAllMaterialWires());
            model.addAttribute("listPin", pinService.getAllPins());
            return "Admin/FormManager/M_Sanpham";
        } else {
            return "redirect:/admin/qlsanpham";
        }
    }

    @PostMapping("/qlsanpham/update/{id}")
    public String updateSanpham(@PathVariable("id") Integer id, Product product) {
        productRepository.save(product);
        return "redirect:/admin/qlsanpham";
    }
}