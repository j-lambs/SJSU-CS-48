import java.util.Scanner;
import java.util.Stack;

public class game_of_throws {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();      // num students
        int k = scanner.nextInt();      // num commands

        int curPosition = 0;
        Stack<Integer> myStack= new Stack<>();
        myStack.push(curPosition);

        for (int i = 0; i < k; i++) {
            String tempStr = scanner.next();
            if (tempStr.equals("undo")) {
                int undoBy = scanner.nextInt();
                int j = 0;
                while (j < undoBy) {
                    myStack.pop();
                    ++j;
                }
                curPosition = myStack.peek();
            }
            else {
                int movePos = Integer.parseInt(tempStr);
                if (movePos < 0) {
                    movePos = n - ((-1*movePos % n));
                }
                curPosition = (curPosition + movePos) % n;
                myStack.push(curPosition);
            }

        }
        scanner.close();
        System.out.println(curPosition);
    }
}
