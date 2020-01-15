//递归二分查找
public class test {
    	public static void main(String[] args) {


        int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };



         int a=binary(arr, 9, 0, arr.length - 1);
        System.out.println("The index position of the searched number is:"+a);
    }

	public static int binary(int []arr,int targe,int start,int end){
		int mid=(start+end)/2;
			if (targe < arr[start] || targe > arr[end] || start > end) {
           			 return -1;
        				}

			if(arr[mid]==targe){
				return mid;}
			else if(arr[mid]>targe){
				return binary(arr,targe,start,mid-1);}
			else if(arr[mid]<targe){
				return binary(arr,targe,mid+1,end);
			}
		  return 0;
	}
}