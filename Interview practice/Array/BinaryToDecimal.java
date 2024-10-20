public class BinaryToDecimal {

    public static String binaryToDecimal(String binaryString) {
        int num = Integer.parseInt(binaryString);
        int sum = 0;
        int i = 0;

        while (num > 0) {
            sum += (num % 10) * Math.pow(2, i++);    
            num /= 10;
        }

        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        String binary = "1101";
        String ternary = binaryToDecimal(binary);
        System.out.println(binary + " in binary is " + ternary + " in decimal");
    }
}