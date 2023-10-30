import java.util.Arrays;
import java.util.Scanner;
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

        scanner.close();

        int nextSize; int j = 0; int indexAt = 0;
        while (j < numSizesNeeded) {
            nextSize = joesPaintList[j];
            if (nextSize > sizesOfferedList[indexAt]) {
                indexAt = Arrays.binarySearch(sizesOfferedList, nextSize);
            }
            if (indexAt < 0) {
                indexAt = -1 * (indexAt + 1); // oops didn't read binarySearch documentation
            }
            paintWasted += sizesOfferedList[indexAt] - nextSize;
            ++j;
        }

        System.out.println(paintWasted);
    }
}
