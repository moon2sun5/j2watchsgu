package com.sgu.j2watch.configs;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Xử lý lỗi ở đây
        return "error"; // Trả về trang lỗi tương ứng
    }
}