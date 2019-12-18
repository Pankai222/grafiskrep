package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for the admin page page.
//This functionality is not yet implemented
@Controller
public class AdminPageController {
//    returns the html file when /admin_page is requested.
        @RequestMapping("/admin_page")
        public String adminpage(){
            return "admin_page";
        }
}
