import java.util.PriorityQueue;

public class LongestHappyString {

    private static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (y.count - x.count));
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char chars = p.chars;

            if (ans.length() >= 2 && ans.charAt(ans.length() - 1) == p.chars
                    && ans.charAt(ans.length() - 2) == p.chars) {
                if (pq.isEmpty())
                    break;

                Pair temp = pq.poll();
                ans.append(temp.chars);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.chars));
                }
            } else {
                count--;
                ans.append(chars);
            }

            if (count > 0) {
                pq.add(new Pair(count, chars));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 2;
        System.out.println(longestDiverseString(a, b, c));
    }
}

class Pair {
    int count;
    char chars;

    Pair(int count, char chars) {
        this.count = count;
        this.chars = chars;
    }
}
