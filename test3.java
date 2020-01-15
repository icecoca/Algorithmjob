//javac -encoding UTF-8 test3.java，求最小k个数
import java.util.Arrays;
/**先给数值里的值进行从小到大排序，然后取从0到k-1索引的数组值
* @创建一个数组,包含11个元素,求5个最小的数
* @author Administrator
*
*/
public class test3 {
public static void main(String[] args) {
//最小元素的个数
int k=5;
//创建一个数组,
int[] arr = {1,3,45,33,67,12,88,11,46,32,89};
//操作数组的工具Arrays,sort()方法自动排序,由小到大
Arrays.sort(arr);
for(int i=0;i<k;i++){
System.out.println(arr[i]);
}
}
}