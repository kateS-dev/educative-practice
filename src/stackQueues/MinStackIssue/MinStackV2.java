package stackQueues.MinStackIssue;

public class MinStackV2 {
    int maxSize;
    MyStack < Integer > mainStack;
    MyStack < Integer > minStack;
    //constructor
    public MinStackV2(int maxSize) {
        //We will use two stacks mainStack to hold original values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new MyStack <Integer> (maxSize);
        minStack = new MyStack  <Integer> (maxSize);
    }
    //removes and returns value from stack
    public int pop() {
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value) {
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if (minStack.isEmpty() || minStack.top() > value)
            minStack.push(value);
        else
            minStack.push(minStack.top());
    }
    //returns minimum value in O(1)
    public int min() {
        return minStack.top();
    }
}
