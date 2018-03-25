package cdektestproject.web;

import cdektestproject.model.Entity;
import cdektestproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/list")
public class JspController {

    @Autowired
    private Service service;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("entity", new Entity());
        return "form";
    }

    @PostMapping("/add")
    public String save(HttpServletRequest request) throws UnsupportedEncodingException {
        Entity entity = new Entity();
        entity.setName(request.getParameter("name"));
        service.create(entity);
        return "redirect:/list";
    }

    @PostMapping("/filter")
    public String filter(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        model.addAttribute("entitys", service.getFiltered(name));
        return "list";
    }
}
