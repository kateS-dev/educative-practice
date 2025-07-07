package stackQueues.CheckSort;

public class CheckSort {
    public static Stack < Integer > sortStack(Stack< Integer > stack) {
        int len = stack.getCurrentSize();
        Stack < Integer > result = new Stack < Integer > (len);

        while (!stack.isEmpty()) {
            int top = stack.pop();
            insertData(result, top);
        }

        return result;
    }

    public static void insertData(Stack<Integer> res, int current) {
        int len = res.getCurrentSize();
        if (len == 0) {
            res.push(current);
        } else {
            Stack<Integer> tmp = new Stack<>(len+1);
            int top = res.pop();
            if (top >= current) {
                res.push(top);
                res.push(current);
            } else {
                tmp.push(top);
                insertData(res, current);
                res.push(top);
            }
        }
    }

    public static void printStack(Stack<Integer> input) {
        while (!input.isEmpty()) {
            System.out.print(input.pop() + "=>");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> aa = new Stack<>(5);
        Integer[] data = {5,2,6,-2};

        for (int i = 0; i < data.length; i++) {
            aa.push(data[i]);
        }

        Stack output = sortStack(aa);
        printStack(output);
    }
}
