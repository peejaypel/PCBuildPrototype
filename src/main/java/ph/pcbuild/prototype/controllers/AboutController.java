package ph.pcbuild.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.pcbuild.prototype.*;

@Controller
@RequestMapping("about")
@SessionAttributes("user")
public class AboutController {
    private UserRepository userRepo = new UserRepository();

    @ModelAttribute("user")
    User user(@RequestParam Integer userId) {
        if (userId == null) {
            userId = 1; // default user
        }
        return userRepo.findBy(userId);
    }

    @GetMapping
    String showItem(Model model, Integer userId) {

        return "about";
    }

}
