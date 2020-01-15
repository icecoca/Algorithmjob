//桥本分法回溯法
public class test7{
	public static void main(String[] args){
		int[] a = new int[10];
		int ans = 0;
		int i = 1;
		a[1] = 1;
		while(true){
			int g = 1;
			for (int k = i-1; k >= 1; k--) {
				if(a[i] == a[k]) {
					g = 0;
					break;
				}
			}
			if(i==9 && g==1 && a[1]<a[4]){
				int m1 = a[2]*10+a[3];
				int m2 = a[5]*10+a[6];
				int m3 = a[8]*10+a[9];
				if(a[1]*m2*m3+a[4]*m1*m3==a[7]*m1*m2){
					ans++;
					System.out.print("("+ans+")");
					System.out.println(a[1]+"/"+m1+"+"+a[4]+"/"+m2+"="+a[7]+"/"+m3);
				}
			}
			if(i<9 && g==1){
				i++;
				a[i] = 1;
				continue;
			}
			while(a[i]==9 && i>1){
				i--;
			}
			if(a[i]==9 && i==1) break;
			else a[i]++;
		}
	}
}