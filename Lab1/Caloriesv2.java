/***************************************************************************************************
* This program will take a .txt file and extract the information that is written
*  in it. After that the values will be stored into different arrays "breakfast
*  lunch, and dinner", as well has separarting it by the days of the week. After
*  that we will calculate how much calories the person eats each day.
***************************************************************************************************/

// Import scanner object to read the file
import java.util.Scanner;
// Import file object
import java.io.File;
// import exceptions in the case user does not input file.
// IOexception deals with input and output issues user might face.
import java.io.FileNotFoundException;

public class Calories{
  public static void main(String[] args) throws FileNotFoundException{
    // Step 1: Check if the user has something written in it.
    boolean a = fileValidation();
    // In the case the file does not have nothing, then we will:
    if(a == false){
      // Print out the following: and we will end the program.
      System.out.println("Invalid user input.");
      System.out.println("Please enter your calories consumed for the week.");
      System.exit(0);
    }
    // Step 2: Check if the .txt file has the right requirements. .txt requirements:
    boolean fileRequirements = correctDimensions();
    // In the case that the requirements are wrong then we will:
    if(fileRequirements == false){
      // We will print the following: and end the program.
      System.out.print("The dimensions of your file are incorrect." + '\n' + "Please fix your file.");
      System.exit(0);
    }
    // This is where I left off 9/2/2018.
    //System.out.println("This works!");
    userInfo();
  }

  public static void userInfo() throws FileNotFoundException, ArrayIndexOutOfBoundsException{
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);

    int[] breakfast = new int[7];
    int[] lunch = new int[7];
    int[] dinner = new int[7];
    String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    int counter = 0;

    while(scnr.hasNextLine()){
      String newLine = scnr.nextLine();
      String[] splitter = newLine.split(" ");

      int[] values = new int[splitter.length];

      for(int i = 0; i < splitter.length; i++){
        values[i] = Integer.parseInt(splitter[i]);
      }
      //System.out.println("This are the values that are in the file: " + values[0]);
      //System.out.println();
      //System.out.println("This are the values that are in the file: " + values[1]);
      //System.out.println("This are the values that are in the file: " + values[2]);
      /*
      for(int i = 0; i < splitter.length; i++){
        breakfast[i] = values[0];
      }
      for(int i = 0; i < splitter.length; i++){
        lunch[i] = values[1];
      }
      for(int i = 0; i < splitter.length; i++){
        dinner[i] = values[2];
      }
      */
      //coloriesConsumedPerDay(values[0], values[1], values[2]);
      if(counter < 7){
        breakfast[counter] = values[0];
        lunch[counter] = values[1];
        dinner[counter] = values[2];
      }
      /*
      for(int i = 0; i < 1; i++){
        System.out.println("This is the users breakfast: " + breakfast[i]);
      }
      for(int i = 0; i < 1; i++){
        System.out.println("This is the users lunch: " + lunch[i]);
      }
      for(int i = 0; i < 1; i++){
        System.out.println("This is the users dinner: " + dinner[i]);
      }
      System.out.println();
      */
      counter++;
    }
    /*
    for(int i = 0; i < breakfast.length; i++){
      System.out.println(week[i]);
      System.out.println("This is the users breakfast: " + breakfast[i]);
      System.out.println("This is the users lunch: " + lunch[i]);
      System.out.println("This is the users dinner: " +dinner[i]);
      System.out.println();
    }
    */

    System.out.println("********************** Weekly Calorie Summary ****************************");
    for(int i = 0; i < week.length; i++){
    System.out.println("Calories conusmed on: " + week[i]);
    System.out.println("Breakfast: " + breakfast[i] + " cal.");
    System.out.println("Lunch: " + lunch[i] + " cal.");
    System.out.println("Dinner: " + dinner[i] + " cal.");
    int caloriesConsumed = sumOfCalories(breakfast[i], lunch[i], dinner[i]);
    System.out.println("Total amount of calories consumed: " + caloriesConsumed + " cal.");
    int avgcaloriesConsumed = average(caloriesConsumed);
    System.out.println("Average calories consumed on " + week[i] + ": " + avgcaloriesConsumed + " cal.");
    boolean healthyIntake = intake(caloriesConsumed);
    if(healthyIntake == true) System.out.println("You need to consume more colories!");
    if(healthyIntake == false) System.out.println("You need to consume less calores!");
    System.out.println();
    }
    //else System.out.println("You are consuming the right of calories!");

    //System.out.println("User consumed " + caloriesConsumed + " on " + week[0]);
    //caloriesConsumed = sumOfCalories(lunch);
    //System.out.println()
    //average(breakfast, lunch, dinner);
  }

  public static boolean intake(int calorieIntake){
    if(calorieIntake > 2250) return false;
    return true;
  }

  public static int average(int totalCalories){
    int averageCalories = totalCalories / 3;
    return averageCalories;
  }

  public static int sumOfCalories(int bf, int ln, int dn){
    int sum = bf + ln + dn;
    return sum;
  }
/*
  public static void coloriesConsumedPerDay(int breakfast, int lunch, int dinner){
    String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    for(int i = 0; i < 2; i++){
      System.out.println("Calories consumed on " + week[i] + " : ");
    }
    System.out.println("Breakfast: " + breakfast);
    System.out.println("Lunch: " + lunch);
    System.out.println("Dinner: " + dinner);
  }
  */

  /*************************************************************************************************
  * This method will not bring anything but will return a boolean value. This method will check if
  * the file was written in the right format that is 7 rows and 3 columns. I have to throw the
  * "NumberFormatException" because if the user inputs some extra spaces in the file, the program
  * wont crash. It will check if the user entered negative numbers, and later on it will check
  * if the user entered the wrong data type.
  *************************************************************************************************/
  public static boolean correctDimensions() throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException{
    // Bringing and stroing input.txt file in variable file.
    File file = new File("input.txt");
    // Bringing in scanner so that we can check the file.
    Scanner scnr = new Scanner(file);

    // The following variables will be used  to check the file requirements:
      // Right amount of row: 7
      // Right amount of values in txt file: 21
      // Right amount of values in each column: 3
    int column = 0;
    int totalAmount = 0;
    boolean godKey = true;

    // We will try the following, we will catch the NumberFormatException if it were to happen.
    try{
      // While .txt has information, we will:
      while(scnr.hasNextLine()){
      // Store the incoming lines into the String variable 'a'
      String newLine = scnr.nextLine();
      // We will separate all information with the sapces. If spaced out wrong then
      // NumberFormatException will kick in. Catch will stop the program from crashing.
      String[] splitter = newLine.split(" ");
      // Create a new array that will help us get the amount of columns and rows the user has entered.
      // The length of the array is determined by the amount of info in the first line that is
      // separatedby spaces.
      int[] u = new int[splitter.length];

      // Checks if the user entered the right amount of values per line.
      godKey = row(u.length);
      // Will convert all info into ints, if its not possible then the catch will deal with it.
      for(int i = 0; i < splitter.length; i++){
        u[i] = Integer.parseInt(splitter[i]);
      }

      // Checks each value of the .txt file for any negative values. If found then we will:
      for(int i = 0; i < splitter.length; i++){
        if(u[i] < 0){
          // Print the following and end the program.
          System.out.println("You cannot have negative calories!");
          System.out.println("Please fix your file.");
          System.exit(0);
        }
      }
      // updates information as loop advances.
      column = column + 1;
      totalAmount = totalAmount + u.length;
      }
    }
    // If file sapces are off, the we will do the following:
    catch(NumberFormatException nfe){
    // Print out the following:
    System.out.println("It seems your file has some mistakes");
    System.out.println();
    }
    catch(ArrayIndexOutOfBoundsException AIOBE){
      System.out.println("It seems that your values are out of bounds, please revise your file.");
    }

    // If the requirements are all right, then we will return true to the main method.
    if(column == 7 && totalAmount == 21 && godKey == true){
      return true;
    }

    // Otherwise we will return false.
    return false;
  }

  /***************************************************************************************************
  * This method will be used to store the length of each row. If one of the lengths would be off then
  * we would have to return false. We will be returning a boolean value, brining in the length of each
  * row in the users .txt files.
  ***************************************************************************************************/
  public static boolean row(int length){
    // Created and initalized array, this will temporarily store the length of each rowe
    int[] valuesPerLine = new int[1];

    for(int i = 0; i < 1; i++){
      valuesPerLine[i] = length;
    }

    // Checks if each row has 3 values, if we do then we will:
    if(valuesPerLine[0] == 3){
      // return true;
      return true;
    }

    // Otherwise return false;
    return false;
  }

  /*************************************************************************************************
  * This method does not bring anything but wil return a boolean value. This
  * method will check if the file has something written in it. If the file has
  * something then we will return true, otherwise we will return false.
  *************************************************************************************************/
  public static boolean fileValidation() throws FileNotFoundException{
    // Calling the file object
    File file = new File("input.txt");
    // Scanner will be the stream that will read the file
    Scanner scnr = new Scanner(file);

    // Creates an empty String, it will be updated by the file, if it exist.
    String a = "";

    // While scanner has a following line, we will keep reading
    while(scnr.hasNextLine()){
      // Stores each line. Will be replaced by the following line
      a = scnr.nextLine();
    }
    // If the length of the String is greater than 0, we will do the following
    if(a.length() > 0){
      // return true
      return true;
    }
    // Otherwise return false.
    return false;
  }
}
