package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for the about page.
@Controller
public class AboutController {
    //    returns the about file, when /about is requested
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
