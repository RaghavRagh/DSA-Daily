import java.util.Scanner;

public class Equation {
    
    private static int solve(int a, int b) {
        return (int) Math.pow(a + b, 3);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();

        System.out.println("Enter b: ");
        int b = sc.nextInt();

        System.out.println(solve(a, b));
        sc.close();
    }
}
