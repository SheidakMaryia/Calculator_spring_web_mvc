package by.tms.controller;

import by.tms.dto.UserAllFieldsDTO;
import by.tms.dto.UserLoginPasswordDTO;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.utils.ConsoleManager;
import by.tms.utils.ConversionOfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    //Injection component of controller
    @Autowired//если не указать то spring не увидит
    private UserService userService;

    @GetMapping("/reg")
    public String reg(@ModelAttribute("newUser")UserAllFieldsDTO userDTO){
        return "reg";
    }

    //аннотацией @Valid показываем что будем этого юзера валидировать
    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("newUser") UserAllFieldsDTO userDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "reg";
        }else {
            userService.save(ConversionOfDTO.getUserWithAllField(userDTO));
            return "redirect:/";
        }
    }


    @GetMapping("/auth")
    public String auth(@ModelAttribute("existingUser")UserLoginPasswordDTO userLoginPasswordDTO){
        return "auth";
    }

    @PostMapping("/auth")
    public String auth(@Valid @ModelAttribute("existingUser") UserLoginPasswordDTO userLoginPasswordDTO, BindingResult bindingResult, Model model, HttpSession httpSession){
        if (bindingResult.hasErrors()) {
            return "auth";
        }else {
            String login = ConversionOfDTO.getUserWithLoginPassword(userLoginPasswordDTO).getLogin();
            String password = ConversionOfDTO.getUserWithLoginPassword(userLoginPasswordDTO).getPassword();

            Optional<User> byLogin = userService.findByLogin(login);
            if (byLogin.isPresent() && byLogin.get().getPassword().equals(password)){
                httpSession.setAttribute("user", byLogin.get());
                return "redirect:/";
            } else {
                model.addAttribute("message", ConsoleManager.AUTH_FAIL);
                return "auth";
            }
        }
    }







    //без валидации

//    @GetMapping("/reg")
//    public String reg(Model model){
//        model.addAttribute("newUser", new User());
//        return "reg";
//    }
    
//    @GetMapping("/reg") //localhost:8080/user/reg GET
//    public String reg(){
//        return "reg";
//    }
//
//    @PostMapping("/reg")
//    public String reg(User user, Model model){
//        if (userService.save(user)){
//            model.addAttribute("messageReg", "Registration passed successfully");
//        }else{
//            model.addAttribute("messageReg", "This user already exist");
//        }
//        return "redirect:/";//идет в HomeController
//    }


//    @GetMapping("/auth")
//    public String auth(){
//        return "auth";
//    }
//
//    @PostMapping("/auth")
//    public String auth(User user, Model model, HttpSession httpSession){
//        Optional<User> byLogin = userService.findByLogin(user.getLogin());
//        if (byLogin.isPresent()){
//            User userByLogin = byLogin.get();
//            if (userByLogin.getPassword().equals(user.getPassword())){
//                httpSession.setAttribute("user", userByLogin);
//                return "calc";
//            } else {
//                model.addAttribute("message", "Wrong password!");
//            }
//        } else {
//            model.addAttribute("message", "User not found!");
//        }
//        return "auth";
//    }

    @GetMapping("/logOut")
    public String logOut(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

}
