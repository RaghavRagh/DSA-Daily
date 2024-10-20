import java.util.*;

public class Main {

    public static void retrievePasscodes(List<String> strips) {
        int n = strips.size();
        List<String> passcodes = new ArrayList<>(Collections.nCopies(n, ""));
        
        Comparator<String> comp = (a, b) -> {
            return (a.charAt(0) - '0') - (b.charAt(0) - '0');
        };
        
        strips.sort(comp);
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                passcodes.set(j, passcodes.get(j) + strips.get(i).charAt(j));
            }
        }
        
        for (String pass : passcodes) {
            System.out.println(pass);
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<String> strips = Arrays.asList("1Au", "5qx", "4uf");
        retrievePasscodes(strips);
    }
}
