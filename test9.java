//合并排序
import java.util.Arrays;
public class test9{
    public static void main(String[] args) {
        int[] arr1 = {4,2,6,3,5};
        System.out.println(Arrays.toString(arr1));
        mergeSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void mergeSort(int[] arr,int l,int r) {
        //0 4
        if (l<r) {
            int q = (l+r)/2;
            mergeSort(arr,l,q);
            mergeSort(arr,q+1,r);
            merge(arr,l,q,r);
        }
    }

    /**
     *
     * @param arr  排序数组
     * @param l    数组最左边下标
     * @param q    数组中间位置下标
     * @param r    数组最右位置下标
     */
    public static void merge(int[] arr, int l, int q, int r) {
        /**因为每次切割后左边下标都是（l,q），右边数组的下标是(q+1,r)
         * 所以左边数组的元素个数就是q - l + 1
         * 右边的数组元素个数就是r - q
         * **/
        final int n1 = q-l+1;//切割后左边数组的数据长度
        final int n2 = r-q;//切割后右边数组的数据长度
        /**创建两个新数组将切割后的数组分别放进去，长度加1是为了放置无穷大的数据标志位**/
        final int[] left = new int[n1+1];//加一操作是增加无穷大标志位
        final int[] right = new int[n2+1];//加一操作是增加无穷大标志位
        //两个循环将数据添加至新数组中
        /**左边的数组下标是从l到q**/
        /**遍历左边的数组*/
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l+i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[q+1+i];
        }

        //将最大的正整数放在两个新数组的最后一位
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0,j = 0;
        //谁小谁放在前面
        for (int k = l; k <= r; k++) {
            if (left[i]<=right[j]) {
                arr[k] = left[i];
                i = i+1;
            } else {
                arr[k] = right[j];
                j = j+1;
            }
        }
    }
}