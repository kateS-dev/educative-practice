package stackQueues.IsBalanced;

public class IsBalanced {
    public static boolean isBalanced(String exp) {
        String[] s = exp.split("");
        MyStack<String> ms = new MyStack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("{") || s[i].equals("[") || s[i].equals("(")) {
                ms.push(s[i]);
            } else if (!ms.isEmpty() && ((s[i].equals("}") && ms.peek().equals("{")) || (s[i].equals("]") && ms.peek().equals("[")) || (s[i].equals(")") && ms.peek().equals("(")))){
                ms.pop();
            } else {
                return false;
            }
        }
        if (ms.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String input = "{}[]()";
        String input = "()){(({)[}}}()){((])";
        Boolean check = isBalanced(input);
        System.out.println(check);
    }
}