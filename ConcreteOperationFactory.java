package complexCalculator5;
public class ConcreteOperationFactory implements OperationFactory {
    @Override
    public ComplexOperation createAddOperation() {
        return new AddOperation();
    }

    @Override
    public ComplexOperation createSubtractOperation() {
        return new SubtractOperation();
    }

    @Override
    public ComplexOperation createMultiplyOperation() {
        return new MultiplyOperation();
    }

    @Override
    public ComplexOperation createDivideOperation() {
        return new DivideOperation();
    }
}
