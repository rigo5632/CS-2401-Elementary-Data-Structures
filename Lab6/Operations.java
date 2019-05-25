import java.util.Random;
import java.util.Scanner;

public class Operations {

 public static void main(String[] args){
 StringNode L=new StringNode("0"+getRandString(2+(int)(Math.random()*5)));
 StringNode temp = L;
 for (int i=1; i<=9;i++){
 temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));
 temp=temp.next;
 }

 System.out.println("All Strings in the list:");
 printMyList(L);
 System.out.println();

 boolean b = isListInOrder(L);
 System.out.println("List is ordered: "+b);
 System.out.println();

 System.out.println("Count of k-length strings");
 System.out.println("k\tNo. of Strings with length k");
 for (int k=0; k<7; k++){
 System.out.println(k+"\t"+countKLenghthStrings(L, k));
 }

 System.out.println("Longest String="+longestStringOfMyList(L));
 System.out.println("Length="+lengthOfMyList(L));

 L=reverseMyList(L);
 System.out.println("All string in the reversed list:");
 printMyList(L);
 System.out.println();

 System.out.println("Remove a given String");
 StringNode LL=removeAStringFromMyList(L, L.next.next.head);
 System.out.println("All strings in the new list:");
 printMyList(LL);
 System.out.println();


 System.out.println("All strings in the previous list:");
 printMyList(L);
 System.out.println();
/*
 System.out.println("Insert a string in a position of the new list:");
 LL=insertAStringIntoMyList(LL, "Hello world", 3);
 printMyList(LL);
 System.out.println();

 b = isListInOrder(L);
 System.out.println("List is ordered: "+b);
 System.out.println();

/*
 LL=insertAStringIntoMyList(LL, "ABBA", 3);
 LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);
 printMyList(LL);

 int c = countPalindromes(LL);
 System.out.println("Found "+c+" palindromes.");
*/

 }

 static String getRandString(int length) {
   Random r = new Random();
   String line = "";
   for(int i = 0; i < length; i++){
     char randChar = (char)(r.nextInt(26) + 'A');
     line = line + String.valueOf(randChar);
   }
   return line;
   //Done
 }


 /* Write a recursive method to print all the strings in separate lines.
 This method cannot contain any loop (that is, uses of for, while, do while
 are prohibited).
 */
 public static void printMyList(StringNode m){
   if(m == null)return;
   System.out.println(m.head);
   printMyList(m.next);
   //Done
}
 /* Write a recursive method to retrieve the number of strings that are longer
 than the length provided in the parameter. This method cannot contain any
 loop (that is, uses of for, while, do while are prohibited).
 */
 public static int countKLenghthStrings (StringNode m, int k){
   if(m == null)return 0;
   if(m.head.length() == k)return 1 + countKLenghthStrings(m.next, k);
   return countKLenghthStrings(m.next, k);
   // Done.
 }

 /* Write a recursive method to retrieve the largest String from the list.
 Assume that there is at least one String in the given list when the method
 is called from the main function. This method cannot contain any loop (that
 is, uses of for, while, do while are prohibited).
 */
 public static String longestStringOfMyList (StringNode m){
   /*if(m == null)return null;
   if(m.next == null)return m.head;
   if(m.head.length() < m.next.head.length()) longestStringOfMyList(m.next);
   m.next = m.next.next;
   return longestStringOfMyList(m.next);
   */
   return null;
 }

 /* Write a recursive method to compute the length of a list.
 This method cannot contain any loop (that is, uses of for, while, do while
 are prohibited).
 */
 public static int lengthOfMyList (StringNode m){
   if(m == null)return 0;
   return 1 + lengthOfMyList(m.next);
   // Done!
 }

 /* Write a recursive method named reverseMyList that will reverse a given
 linked list m. Return the head of the reversed linked list. It is fine
 if you need to modify the given linked list to obtain the reversed one.
 */
 public static StringNode reverseMyList (StringNode m){
   if(m == null || m.next == null)return m;
   StringNode temp = reverseMyList(m.next);
   m.next.next = m;
   m.next = null;
   return temp;
   //Done!
 }

 /* Write a recursive method to remove the first occurrence of a specific
 String from a list. As an example, if your list initially contains
 AA BB CC DD BB KK and if your removee is BB, the returned list should contain
 AA CC DD BB KK after the removal. Return a new head. You must make sure that
 the parameter list m remains intact after returning the new list to the main
 method. This method cannot contain any loop (that is, uses of for, while,
 do-while are prohibited).
 */
 public static StringNode removeAStringFromMyList(StringNode m,
 String removee){
   if(m == null)return m;
   StringNode temp = m;
   if(temp.head.equals(removee))return temp.next;
   temp.next = removeAStringFromMyList(temp.next, removee);
   return temp;
 }

 /* Write a recursive method to insert a String (insertee) into a specific
 position of a list. Positions start from 0 (that is, the position of
 the head of a list is 0). This method cannot contain any loop (that is,
 uses of for, while, do-while are prohibited).
 */
 public static StringNode insertAStringIntoMyList(StringNode m,
 String insertee, int position){
   if(m == null)return m;
   if((position - 1) == 0){
     m.next.head = insertee;
     return m.next;
   }
   m.next = insertAStringIntoMyList(m.next, insertee, position--);
   return m;

 }

 /* Write a recursive method to verify if the strings are
 lexicographically ordered in a linked list. Return true if they are
 ordered, false otherwise. This method cannot contain any loop (that is,
 uses of for, while, do-while are prohibited).
 */
 public static boolean isListInOrder(StringNode m){
   if(m == null || m.next == null)return true;
   if(m.head.charAt(0) > m.next.head.charAt(0))return false;
   return isListInOrder(m.next);
 }

 /* Write a recursive method that will count how many strings of a given
linked list are palindromes. The method must call another recursive
 method named isPalindrome to verify if a String is a palindrome, or
 not. Palindrome checks must NOT be case-sensitive. Neither countPalindromes
 nor isPalindrome may contain loops (that is, uses of for, while, do-while
 are prohibited).
 */
 public static int countPalindromes(StringNode m){


 return 0;
 }

 public static boolean isPalindrome(String s){
 /* Write your code here */
 return false;
 }
}
