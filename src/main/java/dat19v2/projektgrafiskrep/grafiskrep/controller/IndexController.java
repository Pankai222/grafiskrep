package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for the index page
@Controller
public class IndexController {
//    returns the index page when /index is requested
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
