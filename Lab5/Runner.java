// Imports the Scnner tool
import java.util.Scanner;
// imports the File tool
import java.io.File;
// Imports the FileNotFoundException
import java.io.FileNotFoundException;

public class Runner{

  public static void main(String[] args) throws FileNotFoundException{
    Box ab = new Box(1,2,3);
    Box bc = new Box(1,213,312);
    Box af = new Box(1,1,3);
    LinkedList b = new LinkedList();
    b.initiateIterator();
    b.addNode(ab);
    b.addNode(bc);
    b.addNode(af);
    b.printAllBoxes();

    //Scanner scnr = new Scanner(System.in);
    //System.out.println("Please enter a filename: ");
    //File filename = new File(scnr.nextLine());
    //System.out.println("-----------------------------------------------------");
    //Box list = goodFile(filename);
    /*while(list != null){
      System.out.println(list.getLength());
      System.out.println(list.getWidth());
      System.out.println(list.getHeight());
      list = list.next;
    }
    */
  }
  /*****************************************************************************
  * AvgVolumeCubic method: (Takes: Box Head | Returns nothing)
  * Variables Declared: sumOfVol(Double), counter(int)
  * This method will go thorugh the link list and will check each object if it
  * is a cube. Once we have founf all the cube objects from out list we will add
  * the volume of the cube objects and find the average.
  *****************************************************************************/
  //public static void AvgVolumeCubic(Box head){

  //}
  /*****************************************************************************
  * AvgVolume method: (Takes: Box head | returns nothing)
  * Variables Declared: sumOfVol(double), counter(int)
  * This method will go through the entire list and will add all the volumes of
  * all the objects and find the average.
  *****************************************************************************/
  //public static void AvgVolume(Box head){

  //}
  /*****************************************************************************
  * LargestCubic method: (Takes: Box head | returns nothing)
  * Variables Declared: position(int), tracker(int), locate(Box)
  * This method will go through the list and will compare the information from
  * each object that are cubic to find the largest one. Once found we will print
  * out the info of that object.
  *****************************************************************************/
  //public static void LargestCubic(Box head){

  //}
  /*****************************************************************************
  * SmallestCubic method: (Takes head(Box) | return nothing)
  * Variables Declared: position(int), tracker(int), locate(box)
  * This method will go through the list of objects and find objects that are
  * cubic, then it will compare the data stored in those objects to find the
  * smallest cubic object. Once we have found that we will print out the data.
  *****************************************************************************/
  //public static void SmallestCubic(Box head){

  //}
  /*****************************************************************************
  * numOfCubic method: (Takes head(box) | returns nothing)
  * Variables Declared: counter(int)
  * This method will go through the list and will keep count of the objects that
  * are cubic.
  *****************************************************************************/
  //public static void numOfCubic(Box head){

  //}
  /*****************************************************************************
  * BiggestBox method: (Takes head(box) | returns nothing)
  * Variables Declared: position(int), location(int), big(Box)
  * This method will go through the list of box objects and will compare all the
  * objects in the list to find which one is the largest one. Once found we will'
  * print out the biggest object.
  *****************************************************************************/
  //public static void BiggestBox(Box head){

  //}

  /*****************************************************************************
  * SmallestBox method: (Takes head(Box) | returns nothing)
  * Variables Declared: positon(int), location(int), small(Box)
  * This method will go through the list of box objects and will compare the
  * information of each object until we have found the smallest object. Once
  * found we will print out that objects info.
  *****************************************************************************/
  //public static void SmallestBox(Box head){

  //}
  /*****************************************************************************
  * goodFile Method: (Takes File| returns Box)
  * Decalred Variables: Head(Box), temp(Box), line(String), splitter(String[])
  * This method will create a linked list from the file the user entered, the
  * file must have 3 values per row, must exist and must only contain numbers. If
  * user does not satisfy these condition then program will output error
  ******************************************************************************/
  public static Box goodFile(File file) throws FileNotFoundException{
    Box temp = new Box();
    //try{
      LinkedList link = new LinkedList();
      Scanner scnr = new Scanner(file);
      while(scnr.hasNextLine()){
        String line = scnr.nextLine();
        String[] splitter = line.split(" ");
        if(splitter.length != 3){
          System.out.println("Please make sure your file has length, width, and height in each row!");
          System.exit(0);
        }
        temp = new Box(Double.parseDouble(splitter[0]), Double.parseDouble(splitter[1]), Double.parseDouble(splitter[2]));
        link.addNode(temp);
      }
    //}catch(FileNotFoundException FNFE){
      //System.out.println("File: " + file + " was not found!");
      //System.exit(0);
    //}
    //catch(NumberFormatException NFE){
      //System.out.println("Please make sure you are using numbers!");
      //System.exit(0);
    //}
    //return head;
    link.printAllBoxes();
    return temp;
  }
}
