import java.util.ArrayList;
import java.util.List;
/**
 * This is an ArrayList Implementation of stack, Where size is not a problem we
 * can extend the stack as much as we want.
 *
 * @author Ramesh Fadatare
 *
 */
public class StackUsingArrayList {
    /** ArrayList representation of the stack */
    List<Integer> stackList;

    /**
     * Constructor
     */
    StackUsingArrayList() {
        stackList = new ArrayList<>();
    }

    // Adds value to the end of list which is the top for stack
  
    void push(int value) {
        stackList.add(value);
    }

    //Pops last element of list which is indeed the top for Stack
   
     int pop() {

         if (!isEmpty()) { // checks for an empty Stack
              int popValue = stackList.get(stackList.size() - 1);
              stackList.remove(stackList.size() - 1); // removes the poped element             
              return popValue;
         } else {
              System.out.print("The stack is already empty  ");
              return -1;
         }
    }

    // Checks for empty Stack
     
     boolean isEmpty() {
          if (stackList.isEmpty()){
               return true;
          } else {
                return false;
          }
     }

    // Top element of stack
     
    int peek() {
         return stackList.get(stackList.size() - 1);
    }

    public static void main(String[] args) {
     StackUsingArrayList myStack = new StackUsingArrayList(); // Declare a stack of maximum size 4
         // Populate the stack
         myStack.push(5);
         myStack.push(8);
         myStack.push(2);
         myStack.push(9);

         System.out.println(myStack.isEmpty()); // will print false
         System.out.println(myStack.peek()); // will print 9
         System.out.println(myStack.pop()); // will print 9
         System.out.println(myStack.peek()); // will print 2
         System.out.println(myStack.pop()); // will print 2
    }
}
