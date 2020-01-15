import java.util.Random;

//使用动态规划找出最长公共子序列(递归）
public class test4{
    public static void main(String[] args) {
        //随机生成指定长度的字符串
        int size = 20;
        String x  = generateRandomStr(size);
        String y  = generateRandomStr(size);

        int m = x.length();
        int n = y.length();
        //创建二维数组，也就是填表的过程
        int[][] c = new int[m+1][n+1];

        //初始化二维数组
        for (int i = 0; i < m+1; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            c[0][i] = 0;
        }

        //实现公式逻辑
        int[][] path = new int[m+1][n+1];//记录通过哪个子问题解决的，也就是递推的路径
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] + 1;
                }else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    path[i][j] = 1;
                }else{
                    c[i][j] = c[i][j-1];
                    path[i][j] = -1;
                }
            }
        }
        //输出查看c
      /*  System.out.println("c:");
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }
        //输出查看path
        System.out.println("path:");
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(path[i][j]+"\t");
            }
            System.out.println();
        } */

        System.out.printf("%s与%s的最长公共子序列为：\n",x,y);
        PrintLCS(path,x,m,n);


    }

    public static String generateRandomStr(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static void PrintLCS(int[][]b,String x,int i,int j){
        if(i == 0 || j == 0){
            return;
        }

        if(b[i][j] == 0){
            PrintLCS(b,x,i-1,j-1);
            System.out.printf("%c",x.charAt(i-1));
        }else if(b[i][j] == 1){
            PrintLCS(b,x,i-1,j);
        }else{
            PrintLCS(b,x,i,j-1);
        }
    }
}
