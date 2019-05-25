import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner{
  public static void main(String[] args)throws FileNotFoundException{
    int Exists = fileExists();
    if(Exists < 0){
      System.out.println("Please make sure your have information in your file!");
      System.exit(0);
    }
    boolean a = Dimensions(Exists);
    if(a == false){
      System.out.println("Make sure each row has width, height and length!");
      System.exit(0);
    }
    Package[] b = packageInfo(Exists);
    largestPackage(b);
    int cubicAmount = cubic(b);
    cubicInfo(b);
    avgCubeVol(b, cubicAmount);
  }

  public static void avgCubeVol(Package[] list, int cubicAmount){
    double volume = 0;
    for(int i = 0; i < list.length; i++){
      if(list[i].isCubic() == true){
        volume = volume + list[i].getVolumn();
      }
    }
    System.out.println("Average volume of cubic packages: " + (volume/cubicAmount));
  }

  public static void cubicInfo(Package[] list){
    int counter = 0;
    int cubicIndex = 0;
    for(int i = 0; i < list.length; i++){
      if(list[i].isCubic() == true){
      System.out.println("Index of cubic package: " + (i + 1));
      System.out.println("Width: " + list[i].getWidth());
      System.out.println("Height: " + list[i].getHeight());
      System.out.println("Length: " + list[i].getlength());
      }
    }
    System.out.println();
  }

  public static int cubic(Package[] list){
    int cubic = 0;
    int nonCubic = 0;
    for(int i = 0; i < list.length; i++){
      if(list[i].isCubic() == true) cubic++;
      if(list[i].isCubic() == false) nonCubic++;
    }
    System.out.println("Amount of cube packages in list: " + cubic);
    System.out.println("Amount of non-cube packages in list: " + nonCubic);
    System.out.println();
    return cubic;
  }

  public static void largestPackage(Package[] list){
    double maxPackage = list[0].getVolumn();
    int maxIndex = 0;
    for(int i = 1; i < list.length; i++){
      if(maxPackage < list[i].getVolumn()){
        maxPackage = list[i].getVolumn();
        maxIndex = i;
      }
    }
    System.out.println("Largest package index: " + (maxIndex + 1));
    System.out.println("Width: " + list[maxIndex].getWidth());
    System.out.println("height: " + list[maxIndex].getHeight());
    System.out.println("length: " + list[maxIndex].getlength());
    System.out.println("Volume: " + list[maxIndex].getVolumn());
    System.out.println();
  }

  public static Package[] packageInfo(int row)throws FileNotFoundException{
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);
    int counter = 0;
    Package[] a = new Package[row];

    while(scnr.hasNextLine()){
      String newLine = scnr.nextLine();
      String[] splitter = newLine.split(" ");
      double[] u = new double[splitter.length];

      for(int i = 0; i < splitter.length; i++){
        u[i] = Double.parseDouble(splitter[i]);

        if(u[i] <= 0){
          System.out.println("You cannot have less then or equal to 0 info in your .txt file! ");
          System.exit(0);
        }
      }
      a[counter] = new Package(u[0], u[1], u[2]);
      counter++;
    }
    return a;
  }

  public static boolean Dimensions(int row)throws FileNotFoundException{
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);
    int[] column = new int[row];
    int counter = 0;

    while(scnr.hasNextLine()){
      String newLine = scnr.nextLine();
      String[] splitter = newLine.split(" ");
      column[counter] = splitter.length;
      counter++;
    }
    int correct = 0;
    for(int i = 0; i < column.length; i++){
      if(column[i] == 3)correct++;
    }
    if(correct == row) return true;
    return false;
  }

  public static int fileExists()throws FileNotFoundException{
    try{
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);
    int row = 0;

    while(scnr.hasNextLine()){
      String newLine = scnr.nextLine();
      row++;
    }
    return row;

  }catch(FileNotFoundException FNFE){
    System.out.println("We could not find your file!");
    System.exit(0);
  }
  return 0;
  }
}
