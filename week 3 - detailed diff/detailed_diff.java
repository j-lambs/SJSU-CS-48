import java.util.Scanner;

class Detailed_Diff 
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int num_test_cases = s.nextInt() ;
        s.nextLine();

        for (int i = 0; i < num_test_cases; i++)
        {
            String str1 = s.nextLine();
            String str2 = s.nextLine();
            StringBuilder buildingStr = new StringBuilder();
            for (int j = 0; j < str1.length(); j++)
            {
                if (str1.charAt(j) == str2.charAt(j))
                {
                    buildingStr.append(".");
                }
                else
                {
                    buildingStr.append("*");
                }
            }
            buildingStr.toString();
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(buildingStr);
        }

        s.close();
    }
}
