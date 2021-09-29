package by.tms.service.operations;

public class Addition implements MathOperation{
    @Override
    public double getCalc(double num1, double num2) {
        return num1 + num2;
    }
}
