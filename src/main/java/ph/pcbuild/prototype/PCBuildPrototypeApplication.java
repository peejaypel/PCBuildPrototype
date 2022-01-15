package ph.pcbuild.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

@SpringBootApplication
public class PCBuildPrototypeApplication {

    @RequestMapping("/")
    String showItem(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
//    @ResponseBody
//    String home() {
//        return "redirect:login";
//    }

    public static void main(String[] args) {
        SpringApplication.run(PCBuildPrototypeApplication.class, args);
    }
}
