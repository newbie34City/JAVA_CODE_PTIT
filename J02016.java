import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class J02016{
    public static int find(long[] a, int l, int r , long x){
        int res = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(a[mid] == x){
                res = mid;
                break;
            }
            else if(a[mid] < x){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            long[] f = new long[(int)n];
            for(int i = 0; i < n; i ++){
                a[i] = sc.nextInt();
                f[i] = (long)Math.pow(a[i],2);
            }
            Arrays.sort(f);
            int ok = 0;
            outer: for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    int x = find(f, j + 1, n - 1, f[i] + f[j]);
                    if(x != -1){
                        ok = 1;
                        break outer;
                    }
                }
            }
            if(ok == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}