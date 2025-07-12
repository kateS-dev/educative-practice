package stackQueues.FindCelebrity;

public class FindCelebrity {
    public static int findCelebrity(int[][] matrix, int n) {
        MyStack<Integer> celebrityFilter = getIntegerMyStack(matrix, n);

        // filter the second round
        MyStack<Integer> celebrityFilterSecond = new MyStack<>();
        while (celebrityFilter.size() > 0) {
            int person = celebrityFilter.peek();
            for (int j = 0; j < n; j++) {
                int heKnows = matrix[person][j];
                if (heKnows == 1 && person != j) {
                    celebrityFilter.pop();
                    break;
                }
            }

            if (celebrityFilter.size() > 0 && celebrityFilter.peek() == person) {
                celebrityFilter.pop();
                celebrityFilterSecond.push(person);
            }
        }

        if (!celebrityFilterSecond.isEmpty()) {
            return celebrityFilterSecond.pop();
        }

        return -1;
    }

    private static MyStack<Integer> getIntegerMyStack(int[][] matrix, int n) {
        MyStack<Integer> celebrity = new MyStack<>();
        int total = n;
        while (total >= 1) {
            celebrity.push(total-1);
            total--;
        }

        // filter the first round
        MyStack<Integer> celebrityFilter = new MyStack<>();
        while (celebrity.size() > 0) {
            int person = celebrity.peek();
            for (int j = 0; j < celebrity.size(); j++) {
                int otherKnows = matrix[j][person];
                if (otherKnows == 0 && person != j) {
                    celebrity.pop();
                    break;
                }
            }

            if (celebrity.size() > 0 && celebrity.peek() == person) {
                celebrityFilter.push(person);
                celebrity.pop();
            }
        }
        return celebrityFilter;
    }

    public static void main(String[] args) {
        int[][] input = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0}
        };

//        [[0,0,0,0],[1,0,0,1],[1,0,0,1],[1,1,1,0]] , 4
//        [[0,1,1,0],[1,0,1,1],[0,0,0,1],[0,1,1,0]] , 4
        int output = findCelebrity(input, 4);
        System.out.println(output);
    }
}
