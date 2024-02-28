package complexCalculator5;

import java.util.Scanner;

public class ViewCalculator {   

    LoggingService loggingSv = new LoggingService();

    OperationFactory operationFactory = new ConcreteOperationFactory();

    ComplexOperation addOperation = operationFactory.createAddOperation();
    ComplexOperation subtractOperation = operationFactory.createSubtractOperation();
    ComplexOperation multiplyOperation = operationFactory.createMultiplyOperation();
    ComplexOperation divideOperation = operationFactory.createDivideOperation();

   
    public void run() {
        while (true) {
            int real1 = promptInt("Введите действительное число: ");
            int imaginary1 = promptInt("Введите мнимое число: ");
           
            while (true) {
                String cmd = prompt("Введите команду ( *, /, +, - ) : ");
                if (cmd.equals("*")) {
                    viewCalc(real1, imaginary1, multiplyOperation );                    
                    break;
                }
                if (cmd.equals("/")) {
                    viewCalc(real1, imaginary1, divideOperation );                   
                    break;
                }
                if (cmd.equals("+")) {
                    viewCalc(real1, imaginary1, addOperation );                    
                    break;
                }
                if (cmd.equals("-")) {
                    viewCalc(real1, imaginary1, subtractOperation );                    
                    break;
                } else {
                    loggingSv.logError("Выбрана не верная команда попробуйте еще раз!");
                }               
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

    private void viewCalc(int real1, int imaginary1, ComplexOperation operation){
        int real2 = promptInt("Введите действительное 2-е число: ");
        int imaginary2 = promptInt("Введите мнимое 2-е число: ");
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);
       
        Calculator subtractCalculator = new Calculator(operation);
        logViewOperation(num1, num2, operation);      
        ComplexNumber result = subtractCalculator.calculate(num1, num2);
        loggingSv.logInfo("Результат вычиcления: " + result);
    } 

    private void logViewOperation(ComplexNumber a, ComplexNumber b, ComplexOperation operation){
        if(operation.equals(addOperation)){
            loggingSv.logInfo("Выполнено сложение: " + a + " и " + b); 
        }
        else if(operation.equals(subtractOperation)){
            loggingSv.logInfo("Выполнено вычитание: " + a + " и " + b); 
        }
        else if(operation.equals(multiplyOperation)){
            loggingSv.logInfo("Выполнено умножение: " + a + " и " + b); 
        }
        else if(operation.equals(divideOperation)){
            loggingSv.logInfo("Выполнено деление: " + a + " и " + b); 
        }

    }
}
