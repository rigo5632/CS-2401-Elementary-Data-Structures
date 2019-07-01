/*******************************************************************
* Lab 7 Runtime Analysis:
* By: Rigoberto Quiroz
* Description:
* This algorithm will first create an array, then sort in from least to greatest
* double values. Then it will find a random value using Linear search and Binary search
* while conduting those searches we will calculate how long it takes to find the value
* and print in.
**********************************************************************/
import java.util.Random;

public class Search{
  public static void main(String[] args){
    //  Creats and initalizes r(random), arr(double), and newArr(double)
    Random r = new Random();
    double[] arr = randomArray(10000);
    double[] newArr = sortArr(arr);

    // For Loop: Calucates how long Linaer and Binary search take to find the value, and prints it.
    for(int i = 0; i < 30; i++){
      // Creates a random valew to look for.
      double numToLook = r.nextDouble() * newArr.length;
      // takes time in nano seconds.
      long start = System.nanoTime();
      linearSearch(newArr, numToLook);
      long finish = System.nanoTime();
      long start1 = System.nanoTime();
      binarySearch(newArr, numToLook);
      long finish1 = System.nanoTime();
      // Output is in nano seconds
      System.out.println("Linear Search Avg. (NanoSeconds): " + finish - start);
      System.out.println("Binary Seacrh Avg. (NanoSeconds): " + finish1 - start1);
    }
  }
  /*
  Sorts the values from list to be from
  least to greatest. (Bubble Sorting)
  */
  public static double[] sortArr(double[] arr){
    double temp = 0;
    // Nested Loops, compares values from list
    for(int i = 0; i < arr.length - 1; i++){
      for(int j = 0; j < (arr.length - i - 1); j++){
        if(arr[j] > arr[j + 1]){
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  /*
  Splits the list and half and searches left or right
  to find target value. Continues to split until it
  cannot find value.
  */
  public static int binarySearch(double[] arr, double target){
    int low = 0;
    int high = arr.length - 1;
    // Splits list in half
    while(high >= low){
      int middle = (low + high) / 2;
      if(target < arr[middle])high = middle - 1;
      if(target == arr[middle])return middle;
      low = middle + 1;
    }
    return -1;
  }

  /*
  Searches each value from list and comapres it with
  target value, if they are the same, then it will return it
  otherwise it will return '-1'.
  */
  public static int linearSearch(double[] arr, double target){
    for(int i = 0; i < arr.length; i++){
      //  compares each value in the list
      if(arr[i] == target){
        return i;
      }
    }
    return -1;
  }

  /*
  Creates an array with random values inside
  */
  public static double[] randomArray(int length){
    // initalizes r(random) and new array
    Random r = new Random();
    double[] newArr = new double[length];

    for(int i = 0; i < length; i++){
      newArr[i] = r.nextDouble();
    }
    // returns array
    return newArr;
  }
}
