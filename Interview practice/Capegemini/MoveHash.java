import java.util.Scanner;

public class MoveHash {

    private static String moveHash(String str) {
        String s1 = new String("");
        String s2 = new String("");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                s1 += str.charAt(i);
            } else {
                s2 += str.charAt(i);
            }
        }

        return s1 + s2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(moveHash(str));
        sc.close();
    }
}