import java.lang.Math;
import java.util.Scanner;
// import org.apache.commons.lang3.time.StopWatch;

public class CBIS {
    public static void main(String[] args) {
        // int[] unsortedList = { 46, 24, 25, 71, 72, 84, 60, 87 };
        Scanner in = new Scanner(System.in);
        int[] unsortedList = new int[20000];
        for (int i = 0; i < 20000; i++) {
            unsortedList[i] = in.nextInt();
        }
        // long start = System.currentTimeMillis();
        int position = 0;
        for (int i = 1; i < unsortedList.length; i++) {
            int current = i;
            int value = unsortedList[i];
            int place = 0;
            if (value >= unsortedList[position]) {
                place = binaryLocationFinder(unsortedList, position + 1, current - 1, value);
                // right cluster
            } else {
                place = binaryLocationFinder(unsortedList, 0, position - 1, value);
                // left cluster
            }
            position = place;
            unsortedList = inserter(unsortedList, place, current);
        }

        // generate total runtime
        // long end = System.currentTimeMillis();
        // double runtime = (end-start)/1000000.0;
        // System.out.println("Elapsed time in mili second:" + (end - start));

        // generate output
        for (int i = 0; i < unsortedList.length; i++) {
            System.out.println(unsortedList[i]);
        }

    }

    static int binaryLocationFinder(int[] arr, int start, int end, int value) {
        int location = 0;
        if (start == end) {
            if (arr[start] > value) {
                location = start;
            } else {
                location = start + 1;
            }
            return location;
        }
        if (start > end) {
            location = start;
            return location;
        }

        int middle = (int) Math.floor((start + end) / 2);
        if (arr[middle] < value) {
            return binaryLocationFinder(arr, middle + 1, end, value);
        } else if (arr[middle] > value) {
            return binaryLocationFinder(arr, start, middle - 1, value);
        } else {
            return middle;
        }
    }

    static int[] inserter(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
        return arr;
    }

}