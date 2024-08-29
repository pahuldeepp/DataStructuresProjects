// Pahuldeep Singh
// Student ID: 3153555

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PartA_Driver class demonstrates the usage of LinkedBinaryTree to create and interact with a binary tree.
 * It also performs arithmetic operations on a binary arithmetic expression tree.
 */
@SuppressWarnings("unused")
public class PartA_Driver {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // Create a new binary tree
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Construct the binary tree with questions and answers
        Position<String> Q1 = tree.addRoot("Do you want to exercise? [yes/no]");
        Position<String> Q2 = tree.addLeft(Q1, "Are you in the mood for cardio? [yes/no]");
        Position<String> Q3 = tree.addRight(Q1, "Do you prefer strength training?[yes/no]");
        Position<String> Q4 = tree.addLeft(Q2, "Do you want to go for a run?[yes/no]");
        Position<String> Q5 = tree.addRight(Q2, "Do you prefer cycling? [yes/no]");
        Position<String> Q6 = tree.addRight(Q3, "Are you interested in using weights?[yes/no]");

        // Add nodes to the tree
        tree.addLeft(Q4, "Let's go for a run!");
        tree.addRight(Q4, "Let's do another form of cardio!");
        tree.addLeft(Q5, "Let's go cycling!");
        tree.addRight(Q5, "Let's do another form of cardio!");
        tree.addLeft(Q6, "Let's do strength training with weights!");
        tree.addRight(Q6, "Let's do strength training without weights!");

        System.out.println("Tree");
        System.out.println("-----");
        System.out.println(tree.preorder());

        // Begin interaction with the tree
        System.out.println("Tree Interaction");
        System.out.println("-----");

        Position<String> walk = tree.root();
        System.out.println(walk.getElement());

        // Interactive loop to traverse the tree based on user input
        do {
            String input = kb.next();

            if (input.equalsIgnoreCase("no")) {
                Position<String> next = tree.right(walk);

                if (next != null) {
                    System.out.println(next.getElement());
                    walk = next;
                } else {
                    System.out.println("No more nodes to the right.");
                    break;
                }
            } else if (input.equalsIgnoreCase("yes")) {
                Position<String> next = tree.left(walk);

                if (next != null) {
                    System.out.println(next.getElement());
                    walk = next;
                } else {
                    System.out.println("No more nodes to the left.");
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        } while (walk != null && !tree.isExternal(walk));

        // Construct a binary arithmetic expression tree
        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<>();
        Position<String> cursor2 = tree2.addRoot("X");
        tree2.addRight(cursor2, "10");
        cursor2 = tree2.addLeft(cursor2, "+");
        Position<String> cursor3 = cursor2;
        cursor3 = tree2.addRight(cursor3, "X");
        tree2.addLeft(cursor3, "9");
        cursor3 = tree2.addRight(cursor3, "-");
        Position<String> cursor4 = tree2.addLeft(cursor3, "X");
        tree2.addLeft(cursor4, "3");
        tree2.addRight(cursor4, "6");
        cursor3 = tree2.addRight(cursor3, "+");
        tree2.addLeft(cursor3, "7");
        tree2.addRight(cursor3, "2");
        cursor2 = tree2.addLeft(cursor2, "+");
        Position<String> sub = cursor2;
        sub = tree2.addLeft(sub, "-");
        tree2.addLeft(sub, "5");
        tree2.addRight(sub, "2");
        cursor2 = tree2.addRight(cursor2, "X");
        tree2.addLeft(cursor2, "4");
        cursor2 = tree2.addRight(cursor2, "-");
        tree2.addLeft(cursor2, "8");
        cursor2 = tree2.addRight(cursor2, "+");
        tree2.addLeft(cursor2, "3");
        tree2.addRight(cursor2, "1");

        System.out.println("Arithmetic tree \n---------------");
        System.out.println("Indorder :" + tree2.inorder()); // Print the inorder traversal of tree2
        System.out.println("Postorder :" + tree2.postorder());

        LinkedStack<String> buffer = new LinkedStack<>();
        String[] operand = { "*", "x", "+", "-" };
        boolean found = false;
        int calc = 0; // Initialize calc
        int foundoperand = 0; // Initialize foundoperand
        List<Position<String>> mylist = (List<Position<String>>) tree2.postorder();

        // Perform arithmetic calculations on the expression tree
        for (int i = 0; i < mylist.size(); i++) {
            found = false; // Reset found for each iteration
            for (int j = 0; j < operand.length; j++) {
                if (mylist.get(i).getElement().equalsIgnoreCase(operand[j])) {
                    found = true;
                    foundoperand = j;
                    break; // Once operand found, no need to continue checking
                }
            }

            if (!found) {
                buffer.push(mylist.get(i).getElement());
            } else {
                switch (operand[foundoperand]) {
                    case "+":
                        calc = Integer.parseInt(buffer.pop()) + Integer.parseInt(buffer.pop());
                        break;
                    case "-":
                        int operand2Sub = Integer.parseInt(buffer.pop());
                        int operand1Sub = Integer.parseInt(buffer.pop());
                        calc = operand1Sub - operand2Sub;
                        break;
                    case "*":
                    case "x": // Added "x" as an alternative for multiplication
                        calc = Integer.parseInt(buffer.pop()) * Integer.parseInt(buffer.pop());
                        break;
                }

                buffer.push(String.valueOf(calc));
            }
        }
        System.out.println("Tree Value :" + calc);
    }
}
