import java.util.Random;
import java.util.Scanner;

public class RandomQuicksort {

    public static void main(String[] args) {
        // int[] arr = { 46, 24, 25, 71, 72, 84, 60, 87 };
        Scanner in = new Scanner(System.in);
        int[] arr = new int[20000];
        for (int i = 0; i < 20000; i++) {
            arr[i] = in.nextInt();
        }
        // long start = System.currentTimeMillis();
        quicksort(arr, 0, arr.length - 1);
        // long end = System.currentTimeMillis();
        // System.out.println("Elapsed time in mili second: " + (end - start));
        // System.out.println("hasil: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int p = randomPartition(arr, low, high);
            quicksort(arr, low, p - 1);
            quicksort(arr, p + 1, high);
        }
    }

    static int randomPartition(int[] arr, int low, int high) {
        Random randomer = new Random();
        int random = randomer.nextInt(high - low + 1) + low;
        int temp = arr[random];
        arr[random] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int back = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[back];
                arr[back] = arr[i];
                arr[i] = temp;
                back++;
            }
        }
        int temp2 = arr[back];
        arr[back] = arr[high];
        arr[high] = temp2;
        return back;
    }

}
