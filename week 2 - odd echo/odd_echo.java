import java.util.ArrayList;
import java.util.Scanner;

class Odd_Echo {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);

        // get num strings that will be inputted into program
        int numStrings = s.nextInt();
        s.nextLine();

        // build list only containing undisturbed words
        ArrayList<String> strList = new ArrayList<String>();
        for (int i = 0; i < numStrings; i++)
        {
            String tempStr = s.nextLine();
            if (i % 2 == 0)
            {
                strList.add(tempStr);
            }
        }
       
        // now print all strings that we will "only hear through the echo disturbances"
        for (String i : strList) 
        {
            System.out.println(i);
        }

    }
}
