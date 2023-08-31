import java.util.*;

public class J02011{
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]  a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a, i , min);
            System.out.print("Buoc " + (i + 1) + ": ");
            for(int k = 0; k < n; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }
}