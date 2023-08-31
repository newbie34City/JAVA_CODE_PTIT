import java.util.*;

public class J02104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                if(a[i][j] ==1){
                    arr.add(j + 1);
                }
            }
            System.out.print("List(" + (i + 1) + ") = ");
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
