import java.util.Scanner;
import java.util.HashSet;

class One_D_Frogger {
    private static int[] readInBoardValues(int boardLength, Scanner myScanner) {
        int[] myBoard = new int[boardLength + 1];
        for (int i = 1; i <= boardLength; ++i) {
            myBoard[i] = myScanner.nextInt();
        }
        return myBoard;
    }

    private static int moveFroggy(int[] myBoard, int start, int magicNum) {
        HashSet<Integer> visitedTiles = new HashSet<Integer>();     // make set to track visited tiles
        int numHops = 0;                                            // number of frog "hops"
        int frogPointer = start;                                    // initialize frog pointer with starting location

        while (true) {
            // condition 2 - frog falls off left end of board
            if (frogPointer <= 0)
            {
                System.out.println("left");
                return numHops;
            }
            // condition 3 - frog falls off right end of board
            else if (frogPointer >= myBoard.length) {
                System.out.println("right");
                return numHops;
            }
            // condition 1 - WIN!
            else if (myBoard[frogPointer] == magicNum) {
                System.out.println("magic");
                return numHops;
            }
            // condition 4 - frog hops onto a square where the frog has been before, AKA Cycle
            else if (visitedTiles.contains(frogPointer)) {
                System.out.println("cycle");
                return numHops;
            }
            else {
                visitedTiles.add(frogPointer);          // add current tile frog is on to set
                frogPointer += myBoard[frogPointer];    // move froggy
                ++numHops;
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n, s, m;
        n = scanner.nextInt();     // num board squares
        s = scanner.nextInt();     // starting square
        m = scanner.nextInt();     // magic win number
        scanner.nextLine();

        // read in board values
        int[] board = readInBoardValues(n, scanner);

        // now we have to actually move the frog
        System.out.println(moveFroggy(board, s, m));
    }
}
