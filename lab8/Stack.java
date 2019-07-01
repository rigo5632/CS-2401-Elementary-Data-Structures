public class Stack{
  public GenericStack top;

  public Stack(){}

// Checks if the stack is empty by checking the top element
  public boolean isEmpty(){
    if(top == null)return true;
    return false;
  }

// adds a new stack to the top of the list
  public void pushStack(int newStack){
    // creates a new object
    GenericStack temp = new GenericStack(newStack);
    temp.next = top;
    top = temp;
  }

  // We can see the top element with destorying the list
  public GenericStack peek(){
    // checks if stack is empty
    if(top == null){
      System.out.println("Stack is empty.");
      return null;
      //System.exit(0);
    }
    return top;
  }
// returns the top stack and deletes it from the list
  public GenericStack popStack(){
    if(isEmpty() == true)return null;
    GenericStack temp = top;
    // makes next item in list the tip
    top = top.next;
    return temp;
  }
// pops all elements from the stack
  public void popAllStacks(){
    // if top is lost then all elements are lost.
    top = null;
  }

}
