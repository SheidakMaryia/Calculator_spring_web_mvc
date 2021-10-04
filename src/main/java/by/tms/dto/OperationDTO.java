package by.tms.dto;

import by.tms.entity.User;
import by.tms.utils.ErrorsMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OperationDTO {

    @NotNull(message = ErrorsMessageManager.NUMBER_ERROR)
    private double num1;

    @NotNull(message = ErrorsMessageManager.NUMBER_ERROR)
    private double num2;

    private String typeOfOperation;
    private double result;
    private User user;
}
