import java.util.Arrays;

public class test1 {

    public static void main(String[] args) {
        // 测试代码,循环二分查找法
        int[] arr = { 4, 58, 69, 54, 2, 48, 62, 78 };

        // 对数组进行排序，以便使用二分查找（也称折半查找），并打印排序后的数组，
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr, 69));
    }

    /**
     * @param arr    操作数组
     * @param target 查找目标
     * @return 查找到，返回目标在数组中的索引，没找到返回-1
     */
    public static int myBinarySearch(int[] arr, int target) {
        int start = 0;// 开始查找的索引
        int end = arr.length - 1;// 结束查找的索引

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            }
            if (target < arr[mid]) {
                end = mid - 1;
            }
        }
        System.out.println("没找到就返回");
        return 0;

    }

}