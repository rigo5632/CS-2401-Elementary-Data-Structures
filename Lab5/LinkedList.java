public class LinkedList {
 private Box head;
 private Box iterator;
 LinkedList(){}

 /* Add b as the last node of the linked list.*/
 void addNode(Box b){
   if(head == null){
     head = b;
     initiateIterator();
   }else{
     iterator.next = b;
     getNextBox();
   }
 }

 /* Insert b in position pos. If insertion is successful
 * return true, otherwise return false.
 */
// boolean insertNode(Box b, int pos){
/*
  int counter = 0;
  while(head != null){
    if(counter == pos){
      b.next = head;
      return true;
    }
    head = head.next;
    counter++;
  }
  return false;
  */
// }

 /**Print width, height, length, and volume of each of the boxes in
 * this linked list. */
 void printAllBoxes(){
  while(iterator != null){
    System.out.println(iterator.getLength());
    System.out.println(iterator.getWidth());
    System.out.println(iterator.getHeight());
    iterator = iterator.next;
  }
 }

 /** Remove the box in position pos. Return true if removal
 * is successful, otherwise return false.*/
// boolean removeNode(int pos){
// WRITE YOUR CODE HERE.
  //return false;
 //}

 /** Return the box in position pos. Return null when pos is
 * invalid.*/
// Box getBox(int pos){
   /*
   int counter = 0;
   while(head != null){
     head = head.next;
     counter++;
   }
   if(counter == pos){
     return head;
   }
   return null;
   */
// }

 /**Print width, height, length, and volume of each of the boxes in
 * this linked list in reverse order.*/
 void printReverse(){
   if(getNextBox() == null) return;
   iterator = getNextBox();
   printReverse();
   System.out.println(iterator.getLength());
   System.out.println(iterator.getWidth());
   System.out.println(iterator.getHeight());
 }

 /**Initiate the iterator variable*/
 void initiateIterator(){
  iterator = head;
 }

 /**
 * Return the box in the current iterator position.
 */
 Box getNextBox(){
  //iterator = iterator.next;
  return iterator.next;
 }

}
