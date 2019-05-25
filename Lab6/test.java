import java.util.Random;
import java.util.Scanner;

public class test{
  public static void main(String[] args){
    //System.out.println(getRandString(8));
    StringNode a = new StringNode("ai");
    StringNode b = new StringNode("de");
    StringNode c = new StringNode("c meet you");
    a.next = b;
    a.next.next = c;
    printMyList(a);
    /*
    printMyList(a);
    char com = 'a';
    char com2 = 'b';
    System.out.println("******************************************");
    if(com > com2)System.out.println(com + "" + com2);
    System.out.println(com2 + "" + com);
    */
    System.out.println("******************************************");
    System.out.println(isListInOrder(a));
  }

  static String getRandString(int length) {
    Random r = new Random();
    String line = "";
    for(int i = 0; i < length; i++){
      char randChar = (char)(r.nextInt(26) + 'A');
      line = line + String.valueOf(randChar);
    }
    return line;
  }
  public static void printMyList(StringNode m){
    if(m == null)return;
    System.out.println(m.head);
    printMyList(m.next);
 }
 public static boolean isListInOrder(StringNode m){
   if(m == null || m.next == null)return true;
   if(m.head.charAt(0) > m.next.head.charAt(0))return false;
   return isListInOrder(m.next);
 }
}
