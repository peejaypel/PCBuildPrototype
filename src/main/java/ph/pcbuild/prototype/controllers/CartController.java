package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.pcbuild.prototype.*;

@Controller
@RequestMapping("cart")
@SessionAttributes("user")
public class CartController {
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
        return "cart";
    }

    @PostMapping
    String removeToCart(@ModelAttribute User user,@RequestParam Integer itemId, @RequestParam String userAction, RedirectAttributes redirectAttrs) {
        ComputerComponent component = computerComponentRepo.findBy(itemId).get();

        switch (userAction) {
            case "cancel":
                user.removeFromCart(component);
                break;
        }

        redirectAttrs.addFlashAttribute("removeToCartSuccessMessage", "Successfully removed component " + component.getItemId() + " from user's " + user.getUserId() + "'s cart");
        return "redirect:home";
    }

    @ExceptionHandler(CartException.class)
    String handleException(RedirectAttributes redirectAttrs, CartException e) {
        redirectAttrs.addFlashAttribute("addToCartException", e.getMessage());
        return "redirect:cart";
    }
}
