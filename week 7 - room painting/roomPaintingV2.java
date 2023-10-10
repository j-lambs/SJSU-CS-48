import java.util.Scanner;
import java.util.Arrays;

public class roomPaintingV2 {
    /**
     * sort both lists.
     * loop through JOe's paints, and only binary search for each STORE OFFERED bucket size once
     * only binary search again once store size isn't useful to us anymore
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paintWasted = 0;
        int numSizesOffered = scanner.nextInt();
        int numSizesNeeded = scanner.nextInt();
        int[] sizesOfferedList = new int[numSizesOffered];
        int[] joesPaintList = new int[numSizesNeeded];

        for (int i = 0; i < numSizesOffered; ++i) {
            sizesOfferedList[i] = scanner.nextInt();
        }
        Arrays.sort(sizesOfferedList);

        for (int i = 0; i < numSizesNeeded; ++i) { // loop through paints Joe is looking for
            joesPaintList[i] = scanner.nextInt();
        }
        Arrays.sort(joesPaintList);

        int nextSizeNeeded = 0; int j = 0; int indexAt = 0;
        while (j < numSizesNeeded) {
            nextSizeNeeded = joesPaintList[j];
            if (nextSizeNeeded > sizesOfferedList[indexAt]) {
                indexAt = Arrays.binarySearch(sizesOfferedList, nextSizeNeeded);
            }
            if (indexAt < 0) {
                indexAt = -1 * (indexAt + 1); // oops didn't read binarySearch documentation
            }
            ++j;

            paintWasted += sizesOfferedList[indexAt] - nextSizeNeeded;
        }

        scanner.close();
        System.out.println(paintWasted);
    }
}
