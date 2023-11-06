import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCharges = 0;
        int n = scanner.nextInt();
        int[] blocks = new int[n];
        // read in block heights
        for (int i = 0; i < n; ++i) {
            blocks[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(blocks);

        // if least floor is 1, then destroy all level 1's
        // run while blocks are not all destroyed
        int search = 0;
        while (search >= 0)
        {
            search = Arrays.binarySearch(blocks, 1);
            if (search >= 0) {
                ++numCharges;
                for (int i = 0; i < n; ++i) {
                    --blocks[i];
                }
            }
        }

        // else destroy block
        int temp = 1;
        int backwardsC = n - 1;
        while (temp > 0) {
            temp = blocks[backwardsC];
            if (temp > 0) {
                ++numCharges;
            }
            blocks[backwardsC] = 0;
            --backwardsC;
        }

        System.out.println(numCharges);

    }
}