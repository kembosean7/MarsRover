# Instruction Handler

This program processes a list of movement and turn instructions, updating the position of an object accordingly. It supports two types of instructions:

1. **Move**: Move the object forward or backward by a specified distance.
2. **Turn**: Turn the object clockwise or counterclockwise by a specified angle.

The program reads the instructions from a file (`instructions.txt`), executes them, and prints the current position and orientation after each instruction.

---

## Features

- **Move Command**:
    - Moves the object forward or backward in the direction it is facing.
    - Syntax: `move <distance> <forward|backward>`

- **Turn Command**:
    - Turns the object clockwise or counterclockwise by a specified number of degrees.
    - Syntax: `turn <angle> <clockwise|counterclockwise>`

- **Position and Orientation Output**:
    - After each instruction, the current position (x, y) and the facing orientation (in degrees) are printed.

---

## Prerequisites

To run this program, you'll need:

- Java 8 or higher
- A text editor or IDE for editing Java files (e.g., IntelliJ IDEA, Eclipse)
- A terminal or command line interface

---

## Installation

1. Clone or download this repository to your local machine.
2. Ensure you have Java 8 or higher installed. You can check this by running `java -version` in your terminal.
3. Create a file called `instructions.txt` in the project directory with the movement and turn instructions. Example instructions might look like:

    ```
    move 10 forward
    turn 90 clockwise
    move 5 forward
    turn 45 counterclockwise
    move 7 backward
    ```

---

## Running the Program

1. Open your terminal or command line interface.
2. Navigate to the directory where your `Main.java` file is located.
3. Compile and run the program using the following commands:

    ```bash
    javac Main.java
    java Main
    ```

4. The program will read the instructions from `instructions.txt`, process them, and print the object's position and orientation after each command.

---

## Example Output

Given the following example instructions:

