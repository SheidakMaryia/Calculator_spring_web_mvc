package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    //Injection component of controller
    @Autowired//если не указать то что будет?
    private UserService userService;

    @GetMapping("/reg") //localhost:8080/user/reg GET
    public String reg(){
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(User user, Model model){
        if (userService.save(user)){
            model.addAttribute("messageReg", "Registration passed successfully");
        }else{
            model.addAttribute("messageReg", "This user already exist");
        }
        return "redirect:/";//идет в HomeController
    }



    @GetMapping("/auth")
    public String auth(){
        return "auth";
    }

    @PostMapping("/auth")
    public String auth(User user, Model model, HttpSession httpSession){
        Optional<User> byLogin = userService.findByLogin(user.getLogin());
        if (byLogin.isPresent()){
            User userByLogin = byLogin.get();
            if (userByLogin.getPassword().equals(user.getPassword())){
                httpSession.setAttribute("user", userByLogin);
                return "calc";
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found!");
        }
        return "auth";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

}
