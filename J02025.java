import java.util.*;

public class J02025 {
    static int n;
    static int[] a = new int[20];
    static List<Integer> x = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    static Map<List<Integer>, Integer> m = new HashMap<>();

    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    static void generateSubarrays(int k, int s) {
        for (int i = k + 1; i <= n; i++) {
            generateSubarrays(i, s);
            x.add(a[i]);
            if (isPrime(s + a[i])) {
                if (m.get(x) == null || m.get(x) == 0) {
                    m.put(new ArrayList<>(x), 1);
                    ans.add(new ArrayList<>(x));
                }
            }
            generateSubarrays(i, s + a[i]);
            x.remove(x.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ans.clear();
            m.clear();
            n = sc.nextInt();
            for (int i = 1; i <= n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a, 1, n + 1);
            for (int i = 1; i <= n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - i + 1];
                a[n - i + 1] = temp;
            }
            generateSubarrays(0, 0);
            for (List<Integer> subarr : ans) {
                for (int num : subarr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}