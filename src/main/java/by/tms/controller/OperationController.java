package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String history(Model model, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");
        List<Operation> history = operationService.showHistoryByLogin(user.getLogin());
        model.addAttribute("history", history);
        return "history";
    }

}
