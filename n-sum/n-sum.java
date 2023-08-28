import java.util.Scanner;

class N_Sum {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int numInputs;
        String sumString;
        int sum = 0;

        // System.out.println("How many inputs would you like (2 <= # inputs <= 10)?");
        numInputs = s.nextInt();
        s.nextLine();
        // enter ints to be summed
        // System.out.println("enter ints to be summed");
        sumString = s.nextLine();
        
        String[] arrNumStrings = sumString.split(" ", numInputs); // isolates all int values into array
        
        // sums all values in arrNumStrings
        for (int i = 0; i < numInputs; i++)
        {
            String curInt = arrNumStrings[i];
            sum = sum + Integer.parseInt(curInt); // convert string to int and then sum
        }
        
        System.out.println(sum);
    }
}