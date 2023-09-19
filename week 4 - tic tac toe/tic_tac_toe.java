import java.util.Scanner;

public class tic_tac_toe {
    public static void main(String args[])
    {
        // notes, trying to figure this out
        /**
         * each octal digit represents 3 bits in our gamestate
         * if - the octal digit is a 7 or a 3 (in the first bits 0-8 bits), then if the corresponding
         * octal digit (3 octal digits to the left (or [9-12] bits)) is also the same number (7 or 3), then either X or O wins, respectively.
         * else if - (bits 0-8 are all ones with bitwise &), then cats game
         * else - draw
         * just didn't have time to do this :c
         * 
         */
        
        Scanner s = new Scanner(System.in);

        int numGames = s.nextInt();
        s.nextLine();

        for (int i = 0; i < numGames; i++)
        {
            int gameState = 0b00000000000000000; // 18 bits
            int cats = 0b11111111000000000;
        

            int octalNum = s.nextInt();
            s.nextLine();

            int catsTest = cats & octalNum;

            int octalDigit = octalNum % 10;
            if (octalDigit == 7)
            {
                int temp = octalNum << 9;
                if (temp == octalDigit)
                {
                    System.out.println("X wins");
                }
            }
            else if (octalDigit == 0)
            {
                int temp = octalNum << 9;
                if (temp == octalDigit)
                {
                    System.out.println("O wins");
                }
            }
            else if (catsTest == cats)
            {
                System.out.println("Cat's");
            }
            else
            {
                System.out.println("In progress");
            }
        }
        s.close();
    }
}
