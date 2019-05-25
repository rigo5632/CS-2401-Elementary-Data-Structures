import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner{
  public static void main(String[] args) throws FileNotFoundException {
    boolean existence = fileExistence();
    if(existence == false){
      System.out.println("Please make sure you have information in your file!");
      System.exit(0);
    }
    boolean correctFormat = dimensions();
    if(correctFormat == false){
      System.out.println("Please make sure to include width, length, and height per line!");
      System.exit(0);
    }
    Box BoxList = boxInfo();
    SmallestBox(BoxList);
    //BiggestBox(BoxList);
  }

  public static void SmallestBox(Box head){
    int position = 0;
    int location = 0;
    Box small = head;

    while(head != null){
      if(small.getVolume() > head.getVolume()){
        small = head;
        location = position;
      }
      head = head.next;
      position++;
    }
    System.out.println("Smallest box: ");
    System.out.println("Index: " + location);
    System.out.println("Length: " + small.getLength());
    System.out.println("Length: " + small.getWidth());
    System.out.println("Length: " + small.getHeight());
    System.out.println("Volume: " + small.getVolume());
  }

  public static Box boxInfo() throws FileNotFoundException{
    Box head = new Box();
    Box temp = head;

    try{
      File file = new File("input.txt");
      Scanner scnr = new Scanner(file);

      while(scnr.hasNextLine()){
        String line = scnr.nextLine();
        String[] splitter = line.split(" ");
        double[] transfer = new double[splitter.length];

        for(int i = 0; i < splitter.length; i++){
          transfer[i] = Double.parseDouble(splitter[i]);
        }
      temp.next = new Box(transfer[0], transfer[1], transfer[2]);
      temp = temp.next;
    }
      head = head.next;
    }catch(NumberFormatException NFE){
      System.out.println("Please enter the correct values!");
      System.exit(0);
    }
    return head;
  }

  public static boolean dimensions() throws FileNotFoundException {
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);

    int rows = numOfRows();

    double[] columns = new double[rows];
    int counter = 0;

    while(scnr.hasNextLine()){
      String line = scnr.nextLine();
      String[] splitter = line.split(" ");
      columns[counter] = splitter.length;
      counter++;
    }
    int a = 0;
    for(int i = 0; i < columns.length; i++){
      if(columns[i] == 3){
        a++;
      }
    }

    if(a == rows)return true;
    return false;
  }

  public static int numOfRows() throws FileNotFoundException {
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);
    int counter = 0;

    while(scnr.hasNextLine()){
      String line = scnr.nextLine();
      counter++;
    }
    return counter;
  }

  public static boolean fileExistence() throws FileNotFoundException {
    try{
    File file = new File("input.txt");
    Scanner scnr = new Scanner(file);
    int counter = 0;

    while(scnr.hasNextLine()){
      String line = scnr.nextLine();
      counter++;
    }
    if(counter > 0) return true;
  }catch(FileNotFoundException FNFE){
    System.out.println("Please make sure the file, \"input.txt\" exists.");
  }
    return false;
  }
}
