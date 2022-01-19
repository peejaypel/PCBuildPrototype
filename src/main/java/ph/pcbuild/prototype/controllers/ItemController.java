package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.pcbuild.prototype.ComputerComponent;
import ph.pcbuild.prototype.ComputerComponentRepository;
import ph.pcbuild.prototype.User;

@Controller
@RequestMapping("item")
@SessionAttributes("user")
public class ItemController {
    private ComputerComponentRepository computerComponentRepo = new ComputerComponentRepository();

    @ModelAttribute("component")
    ComputerComponent component(@RequestParam Integer id) {
        if (id == null) {
            id = 1; // default user
        }
        return computerComponentRepo.findBy(id);
    }

    @GetMapping
    String loadPage(Model model, Integer id) {
        ComputerComponent component = id == null ? (ComputerComponent) model.getAttribute("component") : computerComponentRepo.findBy(id);

        model.addAttribute("componentName", component.getComponent());
        model.addAttribute("componentBrand", component.getBrand());
        model.addAttribute("componentPrice", component.getPrice());
        model.addAttribute("componentModel", component.getModel());
        model.addAttribute("componentShop", component.getShop());
        model.addAttribute("componentQuantity", component.getQuantity());
        return "item";
    }

    @PostMapping
    String viewItem(@ModelAttribute User user, @RequestParam ComputerComponent component) {

        return "redirect:item";
    }

}
