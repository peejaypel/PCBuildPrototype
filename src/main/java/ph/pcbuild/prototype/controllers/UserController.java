package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.pcbuild.prototype.*;

@Controller
@RequestMapping("home")
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
        model.addAttribute("user", user);
        var cart = user.getCart();
        model.addAttribute("cart", cart);
        var shop = computerComponentRepo.findAll();
        model.addAttribute("shop", shop);
        return "items";
    }

    @PostMapping
    String addToCart(@RequestParam ComputerComponent component, @RequestParam User user, RedirectAttributes redirectAttrs) {
        user.addToCart(component);
        redirectAttrs.addFlashAttribute("addToCartSuccessMessage", "Successfully added component " + component.getItemId() + " to user " + user.getUserId() + "'s cart");
        return "redirect:home";
    }

    @ExceptionHandler(AddToCartException.class)
    String handleException(RedirectAttributes redirectAttrs, AddToCartException e) {
        redirectAttrs.addFlashAttribute("enlistmentExceptionMessage", e.getMessage());
        return "redirect:home";
    }
}
