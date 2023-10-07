import java.util.Scanner;
import java.util.Arrays;

class roomPainting {
    /**
     * put all sizes store offers into an array, and sort array
     * @param n
     * @param myScanner
     * @return sizesOfferedList, a sorted array of the paint can sizes the store offers
     */
    private static int[] storeOfferedSizes(int n, Scanner myScanner) {
        int[] sizesOfferedList = new int[n+1];
        for (int i = 0; i < n; ++i) {
            sizesOfferedList[i] = myScanner.nextInt();
            myScanner.nextLine();
        }
//        Arrays.sort(sizesOfferedList);
        return sizesOfferedList; // save a nlogn
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSizesOffered = scanner.nextInt();
        int numSizesNeeded = scanner.nextInt();
        scanner.nextLine();

        int[] sizesOfferedList = storeOfferedSizes(numSizesOffered, scanner);

        // find paint wasted
        int paintWasted = 0, lastIndex = 0;
        for (int i = 0; i < numSizesNeeded; ++i) { // loop through paints Joe is looking for
            int nextSizeNeeded = scanner.nextInt();
            scanner.nextLine();

            if (i == 0) {
                sizesOfferedList[numSizesOffered] = nextSizeNeeded;
            }
            else {
                sizesOfferedList[lastIndex] = nextSizeNeeded;
            }
            Arrays.sort(sizesOfferedList); // nlogn
            int indexAt = Arrays.binarySearch(sizesOfferedList, nextSizeNeeded); // nlogn
            lastIndex = indexAt;

            paintWasted += sizesOfferedList[indexAt + 1] - nextSizeNeeded;
        } // loop should be at worst O(n*2nlogn)

        scanner.close();
        System.out.println(paintWasted);
    }
}
// what if you always add nextSizeNeeded to the list and binarysearch it
