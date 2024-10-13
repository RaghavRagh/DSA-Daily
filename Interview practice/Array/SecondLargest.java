public class SecondLargest {

    private static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > first) {
                second = first;
                first = i;
            }
            else if (i  > second && i != first) {
                second = i;
            }
        }

        return second;
    }
    
    public static void main(String[] args) {
        int[] arr = { 50, 20, 40, 89, 20, 10 };
        System.out.println(secondLargest(arr));
    }
}
