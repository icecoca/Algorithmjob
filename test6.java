//背包问题的贪心算法
public class test6{
	public static void main(String[] args) {
		int n = 3; //物品数量
		float m = 20; //背包总容量
		float[] p = {25,24,15}; //物品价值
		float[] w = {18,15,10}; //物品重量
		float[] x = {1,1,1}; //每个物品装入背包的量

		test(n, m, p, w, x);
	}

	public static void test(int n,float m,float[] p,float[] w,float[] x){
		float[] value = new float[n]; //物品单位价值
		float sum = 0; //用于存放装入的总价值
		for(int i = 0;i<n;i++){
			value[i]=p[i]/w[i]; //将计算好的物品单位价值放入数组
		}
		//降序排序,将物品价值，物品重量都以单位价值从大到小排序
		for(int i = 0;i < n;i++){
			for(int j = i;j < n;j++){
				//第一轮，将数组第一位与每一位比较，每次比较把值大的放入第一位，能保证循环结束后第一位一定是最大的。
				//第二轮，就从数组第二位开始，保证第二位是剩余数中最大的，以此达到降序排列
				//将物品价值，物品重量降序排序，保证之后的循环一定是单位价值高的物品先装入
				if(value[i] < value[j]){
					float temp = value[i];
					value[i] = value[j];
					value[j] = temp;
					float temp2 = p[i];
					p[i] = p[j];
					p[j] = temp2;
					float temp3 = w[i];
					w[i] = w[j];
					w[j] = temp3;
				}
			}
		}
		//初始化，表示所有东西都没装
		for(int i = 0;i < n;i++){
			x[i]=0;
		}
		int index = 0; //用于存放最后一个没装入的物品索引
		//先将单位价值最高的物品放入书包
		for(int i = 0;i < n;i++){
			index = i;
			if(w[i]>m){ //当当前物品重量大于背包剩余重量时结束循环
				break;
			}
			x[i]=1; //代表全部装入
			m -= w[i]; //减去已转入的物品重量
		}
		//可能存在最后一个物品总重量已经大于剩余重量，但能够装一部分进去的情况
		if(index < n){
			x[index]=m / w[index]; //计算其能装入多少
		}
		//计算总价值
		for(int a = 0;a <= index;a++){
			sum += x[a]*p[a]; //装入的比例*该物品的总价值
		}
		System.out.println("贪心算法所计算的总价值为：" + sum);
	}
}