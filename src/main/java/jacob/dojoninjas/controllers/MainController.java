package jacob.dojoninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jacob.dojoninjas.models.Dojo;
import jacob.dojoninjas.models.Ninja;
import jacob.dojoninjas.services.DojoService;
import jacob.dojoninjas.services.NinjaService;

@Controller
public class MainController {
    
    @Autowired DojoService dojoService;
    @Autowired NinjaService ninjaService;
    //!Creating a Dojo
    @RequestMapping(value=("/dojos/new"))
    public String newDojo(@ModelAttribute("dojo")Dojo dojo){
        return "dojos/new.jsp";
    }
    //!Dojo handler 
    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("dojo")Dojo dojo){
        dojoService.createDojo(dojo);
        return "redirect:/";
    }

    //!CREATING A NINJA
    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja")Ninja ninja,Model model){
        List<Dojo>dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        return "ninjas/new.jsp";
    }

    //! New ninja handler
    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja")Ninja ninja){
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }

    //! SHOW DOJO AND ITS NINJAS
    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id")Long id, Model model){
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo", dojo);
        return "dojos/show.jsp";
    }



}
