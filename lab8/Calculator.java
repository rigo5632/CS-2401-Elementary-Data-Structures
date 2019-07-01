/* Lab 8 Stacks:
  By: Rigoberto Quiroz
  Files also created: GenericStack and Stack
  This file will ask the user for a user input and will add the values provided
  along with the operations the users inputs. At the end we will print the final
  product for the user. If information is a incomeplete functions then we will
  let the user know.
*/



// imports tools to read files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calculator{
  public static void main(String[] args)throws FileNotFoundException{
    // Asks user to input file name
    Scanner scnr = new Scanner(System.in);
    System.out.println("Please enter a valid filename. EX: input.txt");
    String userFile = scnr.nextLine();
    File file = new File(userFile);
    //Sends file name to readFile() method
    readFile(file);
  }
  /* Reads the file and puts the information in a stack, once done it will add
  each value with its corresponding operations.(PostFix). Also checks if equation
  is not correct.
  */
  public static void readFile(File file)throws FileNotFoundException{
    // creates stack
    Stack myStack = new Stack();
    int counter = 1;
    try{
    Scanner scnr = new Scanner(file);
    // Reads file and puts it into stack format
    while(scnr.hasNextLine()){
      String line = scnr.nextLine();
      String[] splitter = line.split(" ");
      // checks if equation is correct.
      if(splitter.length % 2 == 0){
        System.out.print("(Incomplete Function) ");
      }
      for(int i = 0; i < splitter.length; i++){
        // checks eachb operation and adjust stack to give correct output.
        switch (splitter[i]) {
          //adds
          case "+":
            int sum = myStack.popStack().operands + myStack.popStack().operands;
            // adds to new value to stack.(Works the exactly the same for other operations.(Cases))
            myStack.pushStack(sum);
            break;
            //subtracts
          case "-":
            int topValue = myStack.popStack().operands;
            int secondValue = myStack.popStack().operands;
            int subtraction = secondValue - topValue;
            myStack.pushStack(subtraction);
            break;
            //multiply
          case "*":
            int multiplication = myStack.popStack().operands * myStack.popStack().operands;
            myStack.pushStack(multiplication);
            break;
            // divides
          case "/":
            topValue = myStack.popStack().operands;
            secondValue = myStack.popStack().operands;
            int Divison = secondValue / topValue;
            break;
            default :
            // adds to stack if we dont see operation
            myStack.pushStack(Integer.parseInt(splitter[i]));
        }
      }
      // Prints info
      System.out.println("Value at line" + counter + ": " + myStack.peek().operands);
      counter++;
    }
    // exceptions if we didnt find file and wrong file input
  }catch(FileNotFoundException FNFE){
    System.out.println("File was not found!");
    System.exit(0);
  }
  catch(NumberFormatException NFE){
    System.out.println("Make sure your file only has operands and operations!");
    System.exit(0);
  }
  }
}
