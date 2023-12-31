import java.util.*;
public class blabberfish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> dictionary = new HashMap<String, String>(); // key=non english, value=english

        // add english words and their translations to hashmap "dictionary"
        String temp = scanner.nextLine();
        while (!temp.equals("")) {
            String[] nextEntry = temp.split(" ");
            dictionary.put(nextEntry[1], nextEntry[0]);
            temp = scanner.nextLine();
        }
        // translate
        while (scanner.hasNextLine()) {
            boolean tbool = scanner.hasNextLine();
            temp = scanner.nextLine();
            System.out.println(dictionary.getOrDefault(temp, "eh"));
        }
        scanner.close();
    }
}
