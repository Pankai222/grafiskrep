package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogueController {

    @RequestMapping("/catalogue")
    public String catalogue(){
        return "catalogue";
    }
}
