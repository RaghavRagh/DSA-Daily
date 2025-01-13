public class MajorityElements {

    private static int countOccurence(int[] arr) {
        int count = 0, canditate = -1;
        for (int i : arr) {
            if (count == 0) {
                canditate = i;
                count = 1;
            } else {
                if (i == canditate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i : arr) {
            if (i == canditate) {
                count++;
            }
        }

        if (count > (arr.length / 2)) {
            return canditate;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 2, 2, 3, 3 };
        System.out.println(countOccurence(arr));
    }
}
