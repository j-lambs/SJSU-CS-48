import java.util.*;
public class pinkrose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of button packages in the box
        scanner.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String tempStr = scanner.nextLine();
            tempStr = tempStr.toLowerCase();
            if (tempStr.contains("pink") || tempStr.contains("rose")) { // find pink or rose in string
                count++;
            }
        }
        scanner.close();
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("I must watch Star Wars with my daughter");
        }
    }
}
