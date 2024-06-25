public class ReverseWords {
    
    private static String reverseWords(String str) {
        String[] arr = str.trim().split("\\s+");
        int i = 0, j = arr.length - 1;
        while(i < j) {
            String temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }

        return String.join(" ", arr);
    }
    
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.err.println(reverseWords(str));
    }
}
