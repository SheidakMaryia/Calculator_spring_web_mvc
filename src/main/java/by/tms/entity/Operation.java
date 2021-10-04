package by.tms.entity;

import by.tms.utils.ErrorsMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    private double num1;
    private double num2;
    private String typeOfOperation;
    private double result;
    private User user;

    public Operation(double num1, double num2, String typeOfOperation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.result = result;
    }

    public Operation(double num1, double num2, String typeOfOperation) {
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", typeOfOperation='" + typeOfOperation + '\'' +
                ", result=" + result +
                ", user=" + user +
                '}';
    }
}
