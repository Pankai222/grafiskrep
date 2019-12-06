package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
        @RequestMapping("/admin_page")
        public String adminpage(){
            return "admin_page";
        }
}
