package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
