package by.tms.controller;

import by.tms.dto.OperationDTO;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import by.tms.utils.ConversionOfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String calc(Model model){
        model.addAttribute("mathOperation", new OperationDTO());
        return "calc"; //возвращаю calc.jsp
    }

    @PostMapping
    public String calc(@Valid @ModelAttribute("mathOperation")OperationDTO operationDTO, BindingResult bindingResult, Model model, HttpSession httpSession){
        if (bindingResult.hasErrors()){
            return "calc";
        }else {
            User user = (User)httpSession.getAttribute("user");

            Operation mathOperation = ConversionOfDTO.getMathOperation(operationDTO);

            Operation calculation = operationService.getResult(mathOperation.getNum1(), mathOperation.getNum2(), mathOperation.getTypeOfOperation(), user);

            model.addAttribute("result", calculation.getResult()); //то, что хотим отобразить на view
        }
        return "calc";
    }









    //without validation

//    @GetMapping
//    public String calc(){ //localhost:8080/calc GET
//        return "calc"; //возвращаю calc.jsp
//    }
//
//    @PostMapping
//    public String calc(Operation operation,Model model, HttpSession httpSession){
//        User user = (User)httpSession.getAttribute("user");
//
//        Operation calculation = operationService.getResult(operation.getNum1(), operation.getNum2(), operation.getTypeOfOperation(), user);
//
//        operationService.saveMathOperation(calculation);
//
//        model.addAttribute("result", calculation.getResult()); //то, что хотим отобразить на view
//        return "calc";
//    }
}
