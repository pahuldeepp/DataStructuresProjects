### Simple Calculator Using Stack - README

This simple calculator is implemented using a stack data structure to evaluate arithmetic expressions. The calculator supports basic operations such as addition, subtraction, multiplication, and division. By utilizing the stack's Last-In-First-Out (LIFO) property, the calculator efficiently processes expressions in postfix (Reverse Polish) notation, ensuring accurate and fast computation.

#### Features:
- **Supports basic arithmetic operations**: addition (+), subtraction (-), multiplication (*), and division (/).
- **Handles integer and floating-point numbers**.
- **Utilizes stack data structure** for managing operands and operators, ensuring correct order of operations.

#### How It Works:
1. The user inputs a mathematical expression in postfix notation.
2. Each operand is pushed onto the stack.
3. When an operator is encountered, the required number of operands are popped from the stack, the operation is performed, and the result is pushed back onto the stack.
4. The final result is the remaining item on the stack after the entire expression is processed.

---

### Course Waitlist Using Double Circular Linked List - README

This project implements a course waitlist management system using a double circular linked list. The waitlist is designed to handle student enrollments in a course where the number of available seats is limited. The double circular linked list allows efficient insertion, deletion, and traversal of the list, ensuring that students are properly managed on the waitlist.

#### Features:
- **Double Circular Linked List**: Enables bidirectional traversal and circular linkage, making it easy to manage and rotate through the waitlist.
- **Efficient Operations**: Add, remove, and view students on the waitlist with minimal time complexity.
- **Auto-rotation**: If a seat becomes available, the system automatically updates the waitlist and notifies the next eligible student.

#### How It Works:
1. Students are added to the waitlist when the course reaches its maximum capacity.
2. The linked list structure ensures that each student is linked to the next and previous students, forming a circular chain.
3. When a seat becomes available, the list is traversed to remove the next student in line, and the waitlist is updated accordingly.
4. The circular nature of the list ensures that the process can continuously cycle through the students if needed.

These projects showcase the practical use of data structures in solving real-world problems, highlighting the versatility and efficiency of stacks and linked lists in different contexts.
