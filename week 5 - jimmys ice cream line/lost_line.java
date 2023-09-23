import java.util.Scanner;

class LostLineup {
    static int[] build_line(int line_len, String line_str) {
        int[] line = new int[line_len];
        line[0] = 1;    // put jimmy in position 0

        // loop through line_str, and add to position line
        for (int i = 0; i < (line_len - 1); ++i) {
            int ppl_btwn_cur_and_jimmy = line_str.charAt(i * 2) - '0';    // cast char to int
            int og_line_pos = 1 + ppl_btwn_cur_and_jimmy;
            line[og_line_pos] = i + 2;
        }
        return line;
    }
    static void print_original_line(int line[]) {
        for (int i = 0; i < line.length; ++i) {
            if (i != line.length - 1)
            {
                System.out.print(line[i] + " ");
            }
            else {
                System.out.print(line[i]);
            }
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        // get input
        int line_len = s.nextInt();
        s.nextLine();
        String line_str = s.nextLine();

        // building line (array)
        int[] ice_cream_line = build_line(line_len, line_str);
        print_original_line(ice_cream_line);
    }
}
