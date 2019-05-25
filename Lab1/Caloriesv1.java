/* This program will take a .txt file and extract the information that is written
*  in it. After that the values will be stored into different arrays "breakfast
*  lunch, and dinner", as well has separarting it by the days of the week. After
*  that we will calculate how much calories the person eats each day.
*/
// Import scanner object to read the file
import java.util.Scanner;
// Import file object
import java.io.File;
// import exceptions in the case user does not input file.
// IOexception deals with input and output issues user might face.
import java.io.FileNotFoundException;


public class Caloriesv1{
  public static void main(String[] args) throws FileNotFoundException{
    // The program will first check if the file was submitted correctly.
    boolean a = fileValidation();
    if(a == false){
      System.out.println("Invalid user input.");
      System.out.println("Please enter your calories consumed for the week.");
      System.exit(0);
    }
    boolean b = correctDimensions();
    if(b == false){
      System.out.print("The dimensions of your file are incorrect." + '\n' + "Please fix your file.");
      System.exit(0);
    }
    System.out.println("This works!");

    //while(scnr.hasNextLine()){
      //System.out.println("You are here");
      //String line = scnr.nextLine();
      //System.out.println(line);
    //}
  }
  /*****************************************************************************
  * This method will not bring anything but will return a boolean value. This
  * method will check if the file was written in the right format that is 7 rows
  * and 3 columns.
  *****************************************************************************/

    public static boolean correctDimensions() throws FileNotFoundException, NumberFormatException{
      File file = new File("input.txt");
      Scanner scnr = new Scanner(file);
      int column = 0;
      int totalAmount = 0;
      boolean godKey = true;

      try{
      // While .txt has information, we will:
      while(scnr.hasNextLine()){
        // Question why do i have to store the value of return something in order for the loop to stop working.
        //System.out.println("blah blah blah");
        // Store lines into the String variable 'a'
        String a = scnr.nextLine();
        // We will separate all information with the sapces.
        String[] x = a.split(" ");
        //System.out.println(a);
        //System.out.println("This is x:" + x.length);
        // Checking if the dimesnisons are correct.
        int[] u = new int[x.length];
        //System.out.println("This is u:" + u.length);
        godKey = row(u.length);
        //counter = counter - 1;
        //monday[0] = Integer.parseInt(x[0]);
        //System.out.println(monday[0]);
          for(int i = 0; i < x.length; i++){
            u[i] = Integer.parseInt(x[i]);
          }
          for(int i = 0; i < x.length; i++){
            //System.out.println(u[i]);
            if(u[i] < 0){
              System.out.println("You cannot have negative calories!");
              System.out.println("Please fix your file.");
              System.exit(0);
            }
          }
          //System.out.println(u.length);
          column = column + 1;
          totalAmount = totalAmount + u.length;
      }
    }
    catch(NumberFormatException nfe){
      System.out.println("It seems your file has some mistakes");
      System.out.println();
    }
    //System.out.println("We will go for this: " + test());
    //System.out.println("this is godKey: " + godKey);
    if(column == 7 && totalAmount == 21 && godKey == true){
        return true;
      }
      return false;
    }

    public static boolean row(int length){
      int[] valuesPerLine = new int[1];
      for(int i = 0; i < 1; i++){
        valuesPerLine[i] = length;
      }
      //for(int i = 0; i < 1; i++){
        //System.out.println("da wey " + valuesPerLine[i]);
      //}
      if(valuesPerLine[0] == 3){
        return true;
      }
      return false;
    }
    /***************************************************************************
    * This method does not bring anything but wil return a boolean value. This
    * method will check if the file has something written in it. If the file has
    * something then we will return true, otherwise we will return false.
    ***************************************************************************/
    public static boolean fileValidation() throws FileNotFoundException{
        // Calling the file object
        File file = new File("input.txt");
        // Scanner will be the stream that will read the file
        Scanner scnr = new Scanner(file);
       String a = "";

        while(scnr.hasNextLine()){
          a = scnr.nextLine();
        }
        if(a.length() > 0){
          return true;
        }
        return false;
        /*
        // if the file has something written in it we will:
        if(scnr.hasNextLine()){
          return true;
        }
        // if condition not met then we will return false.
        return false;
        */


    }
}
