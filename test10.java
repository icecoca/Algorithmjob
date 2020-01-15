//背包问题0-1递归
public class test10{
    public static void main(final String... args) {
        int[] arr = new int[5];
        arr[0] = 11;
        arr[1] = 8;
        arr[2] = 7;
        arr[3] = 5;
        arr[4] = 3;
        test10 k = new test10();
        System.out.println(k.knapsack(arr, 0, 20, 20));
    }
 
    /**
     *@param arr    all of items in knapsack
     *@param start  the start item to be put into the knapsack
     *@param left   the remaining capacity of knapsack
     *@param sum    capacity of knapsack
     */
    public boolean knapsack(int[] arr, int start, int left, int sum) {
 
        if (arr.length == 0) {
            return false;
        }
 
        // start from the next item in original array
        if (start == arr.length) {
            int[] tempArr = new int[arr.length - 1];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = arr[i + 1];
            }
            return knapsack(tempArr, 0, sum, sum);
        } else if (arr[start] > left) {
            return knapsack(arr, start + 1, left, sum);
        } else if (arr[start] == left) {
            for (int i = 0; i < start + 1; i++) {
                // print the answer out
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
            return true;
        } else {
            return knapsack(arr, start + 1, left - arr[start], sum);
        }
    }
}