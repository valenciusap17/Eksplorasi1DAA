import java.lang.Math;
import java.util.Scanner;

public class CBIS {
    public static void main(String[] args) {
        // int[] unsortedList = { 46, 24, 25, 71, 72, 84, 60, 87 };
        Scanner in = new Scanner(System.in);
        int[] unsortedList = new int[200];
        for (int i = 0; i < 200; i++) {
            unsortedList[i] = in.nextInt();
        }
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

        // System.out.println("hasil: ");
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