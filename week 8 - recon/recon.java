import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class recon {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner scanner = new Scanner(System.in);

        int numVehicles = scanner.nextInt();
        if (numVehicles == 0) { // if only one vehicle, print '0' and quit main
            System.out.println(0);
            System.exit(0);
        }

        boolean convergent = true;
        int[] positions = new int[numVehicles];  int[] velocities = new int[numVehicles];
        velocities[0] = scanner.nextInt();  positions[0] = scanner.nextInt();
        int lv = velocities[0];  int lp = positions[0];
        for (int i = 1; i < numVehicles; ++i) {
            positions[i] = scanner.nextInt();  // position
            velocities[i] = scanner.nextInt();  // velocity
            if (velocities[i] < lv && positions[i] < lp) {
                lv = velocities[i]; lp = positions[i];
            }


        }
        scanner.close();

        long endTime   = System.nanoTime();
        double totalTime = (endTime - startTime) * 0.000000001;
        System.out.println(totalTime);

    }
}