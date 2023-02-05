package world.rfch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(){
        return "index.html";
    }
    @GetMapping("/support")
    public String supportPage(){
        return "support.html";
    }
}
