import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calories2{
  public static void main(String[] args)throws FileNotFoundException{
    boolean a = fileValidation();
    if(a == false){
      System.out.println("Please enter calories into input2.txt");
      System.exit(0);
    }
    boolean b = correctDimensions();
    if(b == false){
      System.out.println("Please revise yoru file for mistakes.");
      System.exit(0);
    }
    userInfo();
  }

  public static void userInfo() throws FileNotFoundException, ArrayIndexOutOfBoundsException{
    File file = new File("input2.txt");
    Scanner scnr = new Scanner(file);
    int[][] foodConsumed = new int[7][3];
    String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    int row = 0;

    try{
    while(scnr.hasNextLine()){
      String newLine = scnr.nextLine();
      String[] splitter = newLine.split(" ");
      int[] u = new int[splitter.length];
        for(int i = 0; i < splitter.length; i++){
          u[i] = Integer.parseInt(splitter[i]);
          //System.out.println(u[i]);
          foodConsumed[row][i] = u[i];
        }
        row++;
      }
    }catch(NumberFormatException NFE){
      System.out.println("Check the format of your file");
      System.exit(0);
    }
    catch(ArrayIndexOutOfBoundsException AIOBE){
      System.out.println("Please check your file, your spacing is off");
      System.exit(0);
    }

      int[] APD = new int[7];
      int[] MNPD = new int[7];
      System.out.println("/************************ Calorie Summary *************************/");
      for(int i = 0; i < foodConsumed.length; i++){
          System.out.println("Calories consumed on: " + weekdays[i]);
          System.out.println("Breakfast: " + foodConsumed[i][0]);
          System.out.println("Lunch: " + foodConsumed[i][1]);
          System.out.println("Dinner: " + foodConsumed[i][2]);
          APD = averagePerDay(foodConsumed);
          System.out.println("Average calories on " + weekdays[i] +": " + APD[i]);
          MNPD = caloriesPerDay(foodConsumed);
          System.out.println("Max amount of calories consumed on " + weekdays[i] + ": " + MNPD[i]);
          System.out.println();
      }
      System.out.println("*********************************************************************");
      int[] weeklyCalories = new int[3];
      String[] mealType = {"Breakfast", "Lunch", "Dinner"};
      weeklyCalories = caloriesPerWeek(foodConsumed);
      for(int i = 0; i < 3; i++){
      System.out.println("Weekly max calorie intake " + mealType[i] + ": " + weeklyCalories[i]);
      System.out.println("Weekly average calorie intake " +mealType[i] + ": " + weeklyCalories[i] / 7);
      System.out.println();
      }
  }
  public static int[] caloriesPerWeek(int[][] calories){
    int[] weeklyMax = new int[3];
    for(int i = 0; i < calories.length; i++){
      weeklyMax[0] = weeklyMax[0] + calories[i][0];
      weeklyMax[1] = weeklyMax[1] + calories[i][1];
      weeklyMax[2] = weeklyMax[2] + calories[i][2];
    }
    return weeklyMax;
  }



  public static int[] caloriesPerDay(int[][] calories){
    int[] test = new int[7];
    int sum = 0;

    for(int i = 0; i < calories.length; i++){
      for(int j = 0; j < calories[i].length; j++){
        if(i == 0)test[i] = test[i] + calories[i][j];
        if(i == 1)test[i] = test[i] + calories[i][j];
        if(i == 2)test[i] = test[i] + calories[i][j];
        if(i == 3)test[i] = test[i] + calories[i][j];
        if(i == 4)test[i] = test[i] + calories[i][j];
        if(i == 5)test[i] = test[i] + calories[i][j];
        if(i == 6)test[i] = test[i] + calories[i][j];
      }
    }
    return test;
  }


  public static int[] averagePerDay(int[][] calories){
    int[] test = new int[7];
    int sum = 0;

    for(int i = 0; i < calories.length; i++){
      for(int j = 0; j < calories[i].length; j++){
        if(i == 0)test[i] = test[i] + calories[i][j];
        if(i == 1)test[i] = test[i] + calories[i][j];
        if(i == 2)test[i] = test[i] + calories[i][j];
        if(i == 3)test[i] = test[i] + calories[i][j];
        if(i == 4)test[i] = test[i] + calories[i][j];
        if(i == 5)test[i] = test[i] + calories[i][j];
        if(i == 6)test[i] = test[i] + calories[i][j];
      }
    }
    for(int i = 0; i < test.length; i++){
      test[i] = test[i] / 3;
    }
    return test;
  }

  public static int averagePerWeek(int[][] calories){
    int sum = 0;
    for(int i = 0; i < calories.length; i++){
      for(int j = 0; j < calories[i].length; j++){
        sum = sum + calories[i][j];
      }
    }
    return sum / 21;
  }

  public static boolean correctDimensions() throws FileNotFoundException{
    File file = new File("input2.txt");
    Scanner scnr = new Scanner(file);

    int row = 0;
    int totalNumbers = 0;
    int[] column = new int[8];
    int counter = 0;

      while(scnr.hasNextLine()){
        String newLine = scnr.nextLine();
        String[] splitter = newLine.split(" ");
        column[counter] = splitter.length;
        totalNumbers = totalNumbers +  column[counter];
        counter++;
        row++;
      }
    if(totalNumbers == 21 && row == 7 && chkingColumnVal(column) == true) return true;
    return false;
  }

  public static boolean chkingColumnVal(int[] column){
    for(int i = 0; i < column.length; i++){
      if(column[i] == 3) return true;
    }
    return false;
  }

  public static boolean fileValidation() throws FileNotFoundException{
    try{
    File file = new File("input2.txt");
    Scanner scnr = new Scanner(file);

    String a = "";

    while(scnr.hasNextLine()){
      a = scnr.nextLine();
    }
    if(a.length() > 0) return true;
  }catch(FileNotFoundException FNE){
    System.out.println("We did not find your file!");
    System.exit(0);
  }
    return false;
  }
}
