
import java.util.Scanner;

public class Assign1PartB_Driver {

    private static Stack<Integer> buffer = new LinkedStack<>();
    private static int currentResult;
    private static Stack<Integer> undostack = new LinkedStack<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Simple Calculator: type z to undo, y to redo, q to quit");
        System.out.println("Enter the first number:");
        String inputs = kb.next();
        if (inputs.equalsIgnoreCase("q")) {
            System.out.println("Final result: " + currentResult);
            System.out.println("Good bye!");
            return;
        } else {
            try {
                currentResult = Integer.parseInt(inputs);
                buffer.push(currentResult);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input! Please enter a valid integer.");
            }
        }
        
        
        while (true) {
            System.out.println("Enter the next operation on " + currentResult + ":");
            String input = kb.next();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Final result: " + currentResult);
                System.out.println("Good bye!");
                break;
            }
            performOperation(input);
        }
        kb.close();
    }

    private static void performOperation(String input) {
        if (input.length() == 1) {
            char command = input.charAt(0);
            if (command == 'z') {
                undo();
            } else if (command == 'y') {
                redo();
            } else {
                System.out.println("Invalid command. Please enter a valid operation or 'q' to quit.");
            }
        } else {
            char operator = input.charAt(0);
            int operand = Integer.parseInt(input.substring(1));

            switch (operator) {
                case '+':
                    currentResult += operand;
                    buffer.push(currentResult);
                    break;
                case '-':
                    currentResult -= operand;
                    buffer.push(currentResult);
                    break;
                case '*':
                    currentResult *= operand;
                    buffer.push(currentResult);
                    break;
                case '/':
                    if (operand == 0) {
                        System.out.println("Cannot divide by zero!");
                    } else {
                        currentResult /= operand;
                        buffer.push(currentResult);
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please enter a valid operation.");
                    break;
            }
        }

        System.out.println("= " + currentResult);
    }

    private static void undo() {
        if (!buffer.isEmpty()) {
            int e = buffer.pop();
            undostack.push(e);
            currentResult = buffer.top();
            System.out.println("UNDO: " + currentResult);
        } else {
            System.out.println("Undo not possible. Buffer is empty.");
        }
    }

    private static void redo() {
        if (!buffer.isEmpty()) {
            try {
                int prev = undostack.pop();
                buffer.push(prev);
                if (!undostack.isEmpty())
                    System.out.println("REDO: " + buffer.top());
                currentResult = buffer.top();
            } catch (Exception e) {
                System.out.println("Nothing to redo");
            }
        }
    }
}
