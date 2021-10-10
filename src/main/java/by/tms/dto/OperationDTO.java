package by.tms.dto;

import by.tms.entity.User;
import by.tms.utils.ErrorsMessageManager;

import javax.validation.constraints.NotNull;


public class OperationDTO {

    @NotNull(message = ErrorsMessageManager.NUMBER_ERROR)
    private double num1;

    @NotNull(message = ErrorsMessageManager.NUMBER_ERROR)
    private double num2;

    private String typeOfOperation;
    private double result;
    private User user;
}
