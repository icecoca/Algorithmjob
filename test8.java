//桥本分法回溯法,三角形三边相等
public class test8{
	public static void main(String[] args){
		int[] a = new int[7];
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
			if(i==6 && g==1 && a[1]<a[3]&& a[3]<a[5]){
				int m1=a[2];
				int m2=a[4];
				int m3=a[6];
				if(a[1]+a[3]+m1==a[3]+a[5]+m2 && a[1]+a[3]+m1==a[1]+a[5]+m3 && a[1]+a[5]+m3==a[3]+a[5]+m2){
					ans++;
					System.out.println(a[1]);System.out.println(m1);System.out.println(a[3]);
					System.out.println(m2);System.out.println(a[5]);System.out.println(m3);
					System.out.println("\n");
					//System.out.println(a[1]+m1+a[3]+m2+a[5]+m3);
				}
			}
			if(i<6 && g==1){
				i++;
				a[i] = 1;
				continue;
			}
			while(a[i]==6 && i>1){
				i--;
			}
			if(a[i]==6 && i==1) break;
			else a[i]++;
		}
	}
}