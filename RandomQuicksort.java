import java.util.Random;
import java.util.Scanner;

public class RandomQuicksort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ukuran dari array input dapat disesuaikan secara manual
        int[] arr = new int[20000];
        for (int i = 0; i < 20000; i++) {
            arr[i] = in.nextInt();
        }

        // Variabel yang menyimpan nilai runtime saat proses baru dimulai
        // long start = System.currentTimeMillis();

        quicksort(arr, 0, arr.length - 1);

        // Variabel yang menyimpan nilai runtime saat proses sudah selesai
        // long end = System.currentTimeMillis();

        // Print total runtime
        // System.out.println("Elapsed time in mili second: " + (end - start));

        // Print memory usage
        // printMemoryUsage();

        // Print output
        System.out.println("hasil: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        in.close();
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

    static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used (bytes): " + memoryUsed);
    }

}
