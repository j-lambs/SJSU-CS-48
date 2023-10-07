import java.util.Scanner;
import java.util.Arrays;

class roomPainting {
    /**
     * put all sizes store offers into an array, and sort array.
     * O(n + nlogn)
     * @param n
     * @param myScanner
     * @return sizesOfferedList, a sorted array of the paint can sizes the store offers
     */
    private static int[] storeOfferedSizes(int n, Scanner myScanner) {
        int[] sizesOfferedList = new int[n];
        for (int i = 0; i < n; ++i) {
            sizesOfferedList[i] = myScanner.nextInt();
            myScanner.nextLine();
        }
        Arrays.sort(sizesOfferedList);
        return sizesOfferedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSizesOffered = scanner.nextInt();
        int numSizesNeeded = scanner.nextInt();
        scanner.nextLine();

        int[] sizesOfferedList = storeOfferedSizes(numSizesOffered, scanner);

        // find paint wasted
        int paintWasted = 0;
        for (int i = 0; i < numSizesNeeded; ++i) { // loop through paints Joe is looking for
            int nextSizeNeeded = scanner.nextInt();
            scanner.nextLine();

            int indexAt = Arrays.binarySearch(sizesOfferedList, nextSizeNeeded); // logn
            if (indexAt < 0) {
                indexAt = -1 * (indexAt+1); // oops didn't read binarySearch documentation
            }

            paintWasted += sizesOfferedList[indexAt] - nextSizeNeeded;
        }

        scanner.close();
        System.out.println(paintWasted);
    }
}
