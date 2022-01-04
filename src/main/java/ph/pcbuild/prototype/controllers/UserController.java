package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ph.pcbuild.prototype.User;
import ph.pcbuild.prototype.UserRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

import ph.pcbuild.prototype.*;

@Controller
@RequestMapping("addToCart")
@SessionAttributes("user")
public class UserController {
    private UserRepository userRepo = new UserRepository();
    private ComputerComponentRepository computerComponentRepo = new ComputerComponentRepository();

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
        model.addAttribute("student", user);
        var cart = user.getCart();
        model.addAttribute("cart", cart);

        model.addAttribute("shop", computerComponentRepo.findAll().stream()
                .filter(sec -> !enlistedSections.contains(sec)).collect(Collectors.toList()));
        return "items";
    }

    @PostMapping
    String addToCart(@RequestParam ComputerComponent component, @RequestParam User user, RedirectAttributes redirectAttrs) {
        user.addToCart(component);
        redirectAttrs.addFlashAttribute("addToCartSuccessMessage", "Successfully added component " + component.getItemId() + " to user " + user.getUserId() + "");
        return "redirect:sections";
    }
}
