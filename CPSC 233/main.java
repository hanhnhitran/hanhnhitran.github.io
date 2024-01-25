import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = input.nextInt();
        float ans = 9/5 * a + 32;
        System.out.println("The answer in Farenheit is " + ans);
    }
}

