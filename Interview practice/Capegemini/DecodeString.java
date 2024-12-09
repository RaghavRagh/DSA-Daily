public class DecodeString {

    public static void main(String[] args) {
        String name = "A quick 0brown fox";
        String[] arr = name.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == '0' || arr[i].charAt(0) == '1' || arr[i].charAt(0) == '2' || arr[i].charAt(0) == '3' || arr[i].charAt(0) == '4' || arr[i].charAt(0) == '5' || arr[i].charAt(0) == '6' || arr[i].charAt(0) == '7' || arr[i].charAt(0) == '8' || arr[i].charAt(0) == '9') {
                StringBuilder rev = reverse(arr[i], 1);
                rev.deleteCharAt(rev.length() - 1);
                arr[i] = rev.toString();
            }
        }

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }

    private static StringBuilder reverse(String s, int i) {
        int n = s.length();
        int j = n - 1;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb;
    }
}