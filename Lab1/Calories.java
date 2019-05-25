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
    // After everything has been checked we will print the summary of the user.
    userInfo();
  }

  /*************************************************************************************************
  * This method does not bering anything in nor returns anything. This method will stroe all the
  * values inside the .txt file into 3 different arrays (Breakfast, Lunch, and Dinner). Each array
  * will hold 7 values, each per one day of the week. After the arrays have been sorted out, we will
  * print out a calorioe intake summary for the user to read. The summary will include:
  * - Calories consumed per meal.
  * - Sum of all calories taken per day.
  * - Average of calories taken per day.
  * - Checking if the user is eating the correct amount of colories per day.
  **************************************************************************************************/
  public static void userInfo() throws FileNotFoundException, ArrayIndexOutOfBoundsException{
    // Creating an object, and initalizing it with the name of the file.
    File file = new File("input.txt");
    // Creating and initalizing scanner, will be used to read file.
    Scanner scnr = new Scanner(file);

    // Creating and initialzing arrays (breakfast, Lunch, dinner, and week), this arrays will store
    // the values in the .txt file and the name of each day of the week.
    int[] breakfast = new int[7];
    int[] lunch = new int[7];
    int[] dinner = new int[7];
    String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    // Counter will be used to help us store the values into the above arrays
    int counter = 0;

    // While scnr has a next line to read, we will:
    while(scnr.hasNextLine()){
      // Store that line into a string.
      String newLine = scnr.nextLine();
      // Split all info by the whitesapces they may contain
      String[] splitter = newLine.split(" ");

      // Create an array that will temporarily hold the info of the lines, will reset after the start
      // of each new line.
      int[] values = new int[splitter.length];

      // Storing the values
      for(int i = 0; i < splitter.length; i++){
        values[i] = Integer.parseInt(splitter[i]);
      }

      // If the counter is less than 7, we will:
      if(counter < 7){
        // store the value inisde location[0...] inside breakfast, lucnh and dinner.
        // Counter is being used as a for loop "int i", to store values in their correspoding locations
        breakfast[counter] = values[0];
        lunch[counter] = values[1];
        dinner[counter] = values[2];
      }
      // After all has been done, we will update the counter value by one.
      // This process will repeat until scanner has no more lines to read.
      counter++;
    }
    // Prints out user summary
    // Loop will place all the data.
    System.out.println("********************** Weekly Calorie Summary ****************************");
    for(int i = 0; i < week.length; i++){
    System.out.println("Calories conusmed on: " + week[i]);
    System.out.println("Breakfast: " + breakfast[i] + " cal.");
    System.out.println("Lunch: " + lunch[i] + " cal.");
    System.out.println("Dinner: " + dinner[i] + " cal.");
    // Sends info to method so that we can get the sum.
    int caloriesConsumed = sumOfCalories(breakfast[i], lunch[i], dinner[i]);
    System.out.println("Total amount of calories consumed: " + caloriesConsumed + " cal.");
    // Seneds info to method so that we can get the average.
    int avgcaloriesConsumed = average(caloriesConsumed);
    System.out.println("Average calories consumed on " + week[i] + ": " + avgcaloriesConsumed + " cal.");
    // Sends info so that we can get if the user is eating healthy.
    boolean healthyIntake = intake(caloriesConsumed);
    if(healthyIntake == true) System.out.println("You need to consume more colories!");
    if(healthyIntake == false) System.out.println("You need to consume less calores!");
    // After each loop, we will have a space that will separate all info.
    System.out.println();
    }
  }

/***************************************************************************************************
* Takes the sum of the calories consumed per day and will return a boolean answer(True/False). This
* method wi9ll check if the user is eating the right amount of calories.
****************************************************************************************************/
  public static boolean intake(int calorieIntake){
    // If the sum of the calories is greater than '2250', we will: return false
    if(calorieIntake > 2250) return false;
    // Otherwise we will return true.
    return true;
  }

/***************************************************************************************************
* This method will bring in the sum of the calories the user has eaten, and will return the average
* amount back.
***************************************************************************************************/
  public static int average(int totalCalories){
    // Since we know that the user will always have 3 meals a day, we can divide it by 3.
    int averageCalories = totalCalories / 3;
    // returns the average amount of calories.
    return averageCalories;
  }

/***************************************************************************************************
* This method will take 3 values of the arrays, brekfast, lunch, and dinner, and will return the sum
* of the those values.
****************************************************************************************************/
  public static int sumOfCalories(int bf, int ln, int dn){
    // sum of all those 3 values.
    int sum = bf + ln + dn;
    // returning the sum.
    return sum;
  }
     
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
