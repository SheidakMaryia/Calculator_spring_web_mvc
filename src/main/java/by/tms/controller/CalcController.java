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

@Controller
@RequestMapping("/calc")
public class CalcController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String calc(){ //localhost:8080/calc GET
        return "calc"; //возвращаю calc.jsp
    }

    @PostMapping
    public String calc(Operation operation, Model model, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");

        Operation calculation = operationService.getResult(operation.getNum1(), operation.getNum2(), operation.getTypeOfOperation(), user);

        operationService.saveMathOperation(calculation);

        model.addAttribute("result", calculation.getResult()); //то, что хотим отобразить на view
        return "calc";
    }
}
