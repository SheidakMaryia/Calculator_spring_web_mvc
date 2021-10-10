package by.tms.dto;

import by.tms.utils.ErrorsMessageManager;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginPasswordDTO {

    @NotBlank(message = ErrorsMessageManager.NOT_BLANK_ERROR)
    @Size(min = 3, max = 16, message = ErrorsMessageManager.LOGIN_OF_USER_ERROR)
    //@Pattern(regexp = "[\n]")//регулярные выражения
    private String login;


    @NotBlank(message = ErrorsMessageManager.NOT_BLANK_ERROR)
    @Size(min = 3, max = 16, message = ErrorsMessageManager.PASSWORD_OF_USER_ERROR)
    private String password;
}
