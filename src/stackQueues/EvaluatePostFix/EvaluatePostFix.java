package stackQueues.EvaluatePostFix;

public class EvaluatePostFix {
    public static int evaluatePostFix(String expression) {
        MyStack<Integer> nums = new MyStack<>();
        String[] x = expression.split("");
        int total = 0;
        for (int i = 0; i < x.length; i++) {
            String item = x[i];
            if (item.equals("+")  ||item.equals("-") ||item.equals("*") ||item.equals("/")) {
                int next = nums.pop();
                int prev = nums.pop();
                switch (item) {
                    case "+":
                        total = prev + next;
                        nums.push(total);
                        break;
                    case "-":
                        total = prev - next;
                        nums.push(total);
                        break;
                    case "*":
                        total = prev * next;
                        nums.push(total);
                        break;
                    case "/":
                        total = prev / next;
                        nums.push(total);
                        break;
                }
            } else {
                nums.push(Integer.parseInt(item));
            }

        }
        return total;
    }

    public static void main(String[] args) {
        String input = "34*2+";
        int res = evaluatePostFix(input);

        System.out.println(res);
    }
}
