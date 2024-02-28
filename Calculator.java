package complexCalculator5;

public class Calculator {
    private ComplexOperation operation;

    public Calculator(ComplexOperation operation) {
        this.operation = operation;
    }

    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return operation.operate(a, b);
    }
}
