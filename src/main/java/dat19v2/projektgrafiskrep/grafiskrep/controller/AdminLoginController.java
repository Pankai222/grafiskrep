package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
    @RequestMapping("/admin_login")
    public String adminlogin(){
        return "admin_login";
    }
}
