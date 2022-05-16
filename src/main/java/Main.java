import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Task1. Enter numbers separated by commas");
        String input1 = scanner.nextLine();
        int[] nArr1 = Arrays.stream(input1.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Max of (nums[i]-1)*(nums[j]-1): " + maximumOf(nArr1));

        System.out.println("Task2. Enter numbers separated by commas");
        String input2 = scanner.nextLine();
        int[] nArr2 = Arrays.stream(input2.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Sorted array of squares of numbers: " + Arrays.toString(squares(nArr2)));

    }

    public static int maximumOf(int[] nArr) {
        int max = 0;
        for (int i = 0; i < nArr.length; i++) {
            for (int ii = 0; ii < nArr.length; ii++) {
                if ((i!=ii)&(nArr[i]-1)*(nArr[ii]-1) > max) {
                    max = (nArr[i]-1)*(nArr[ii]-1);
                }
            }
        }
        return max;
    }

    public static int[] squares(int[] nArr) {
        int[] rez;

        for (int i = 0; i < nArr.length; i++) {
            nArr[i] = nArr[i] * nArr[i];
        }

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < nArr.length-1; i++) {
                if(nArr[i] > nArr[i+1]){
                    isSorted = false;
                    buf = nArr[i];
                    nArr[i] = nArr[i+1];
                    nArr[i+1] = buf;
                }
            }
        }
        return nArr;
    }
}
