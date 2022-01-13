package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.pcbuild.prototype.*;

import java.util.HashSet;

@Controller
@RequestMapping("home")
@SessionAttributes("user")
public class UserController {
    private UserRepository userRepo = new UserRepository();
    private ComputerComponentRepository computerComponentRepo = new ComputerComponentRepository();

    //is similar/equivalent to get mapping user repo find by user ID
    @ModelAttribute("user")
    User user(@RequestParam Integer userId) {
        if (userId == null) {
            userId = 1; // default user
        }
        return userRepo.findBy(userId);
    }

    @GetMapping
    String showItem(Model model, Integer userId) {
        User user = userId == null ? (User) model.getAttribute("user")
                : userRepo.findBy(userId);
        model.addAttribute("user", user);
        var cart = user.getCart();
        model.addAttribute("cart", cart);
        var shop = computerComponentRepo.findAll();
        model.addAttribute("shop", shop);

        HashSet<String> categories = new HashSet<String>();
        for (ComputerComponent component :shop) {
            if (!categories.contains(component.getComponent())) categories.add(component.getComponent());
        }
        model.addAttribute("categories", categories);

        return "home";
    }

    @ExceptionHandler(CartException.class)
    String handleException(RedirectAttributes redirectAttrs, CartException e) {
        redirectAttrs.addFlashAttribute("enlistmentExceptionMessage", e.getMessage());
        return "redirect:home";
    }
}
