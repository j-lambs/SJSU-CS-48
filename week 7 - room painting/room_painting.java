import java.util.Scanner;
import java.util.Arrays;

class roomPainting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSizesOffered = scanner.nextInt();
        int numSizesNeeded = scanner.nextInt();

        // not calling a function saves O(n) operation? hopefully helps
        int[] sizesOfferedList = new int[numSizesOffered];
        for (int i = 0; i < numSizesOffered; ++i) {
            sizesOfferedList[i] = scanner.nextInt();
        }
        Arrays.sort(sizesOfferedList);

        // find paint wasted
        // code segment is O(m * logn)
        int paintWasted = 0;
        for (int i = 0; i < numSizesNeeded; ++i) { // loop through paints Joe is looking for
            int nextSizeNeeded = scanner.nextInt();

            int indexAt = Arrays.binarySearch(sizesOfferedList, nextSizeNeeded); // logn
            if (indexAt < 0) {
                indexAt = -1 * (indexAt + 1); // oops didn't read binarySearch documentation
            }
            paintWasted += sizesOfferedList[indexAt] - nextSizeNeeded;
        }

        scanner.close();
        System.out.println(paintWasted);
    } // total big O should be: O(n+nlogn + m*logn)
}
