import java.util.Scanner;

class LostLineup {
    static int[] build_line(Scanner my_scanner, int line_len) {
        int[] line = new int[line_len - 1];

        for (int i = 0; i < line_len - 1; ++i) {
            int ppl_btwn_cur_and_jimmy = my_scanner.nextInt();
            line[ppl_btwn_cur_and_jimmy] = i + 2;
        }

        return line;
    }
    static void print_original_line(int[] line) {
        System.out.print(1);
        for (int j : line) {
            System.out.print(" " + j);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // get input
        int line_len = s.nextInt();
        s.nextLine();

        int[] ice_cream_line = build_line(s, line_len);
        print_original_line(ice_cream_line);
        s.close();
    }
}
