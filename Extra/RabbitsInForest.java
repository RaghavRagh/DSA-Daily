import java.util.HashMap;

public class RabbitsInForest {

    private static int numRabbits(int[] answers) {
        int n = answers.length;
        if (n == 1) {
            return answers[0] + 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int minRabbits = 0;
        for (var set : map.entrySet()) {
            int x = set.getKey(), freq = set.getValue();
            int groups = (int) Math.ceil(freq / (double) (x + 1));
            int groupSize = x + 1;
            minRabbits += groupSize * groups;
        }   

        return minRabbits;
    }
    
    public static void main(String[] args) {
        int[] answers = { 2, 1, 2, 2, 2, 2, 2, 2, 1, 1 };
        System.out.println(numRabbits(answers));
    }
    /* 
    test case - 2, 1, 2, 2, 2, 2, 2, 2, 1, 1
    map [2 = 7, 1 = 3]
    7 / 2 + 1 = 2.3 (3 groups)
    [2,2,2] [2,2,2] [2]
    ans = 3 groups * 3 rabbits = 9
    Note - although we have only 1 rabbit in last group, still we are multiplying it by 3 rabbits
    because rabbit who says "There are 2 others like me" → that means:
    ! There must be 2 more rabbits that give the same answer, even if we don’t see them in the input.
    We have no way to tell if the rabbits are talking about the same group or different ones, so we must assume the worst-case
    
    3 / 1 + 1 = 1.5 (2 groups)
    [1,1] [1]
    ans = 2 groups * 2 rabbits = 4
    final ans = 13
    */
}
