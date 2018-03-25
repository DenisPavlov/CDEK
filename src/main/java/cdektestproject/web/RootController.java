package cdektestproject.web;

import cdektestproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/list")
    public String meals(Model model) {
        model.addAttribute("entitys", service.getAll());
        return "list";
    }
}
