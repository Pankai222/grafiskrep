package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for the admin login page.
//This functionality is not yet implemented
@Controller
public class AdminLoginController {
//    returns the admin_login file, when /admin_login is requested
    @RequestMapping("/admin_login")
    public String adminlogin(){
        return "admin_login";
    }
}
