import java.util.Scanner;


public class fbnq {
	public static void main(String[] args) {
		System.out.println("请输入你所求的项数（>=1）：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result =new fbnq().fei(num);
		System.out.println(result);
	}
	int fei(int n){
        if(n==1||n==2){
        	return 1;
        }
        return fei(n-1)+fei(n-2);
	}
}
/*public static void main(String[] args) {
int a=1,b=1,c=0;
System.out.println("斐波那契的数为：");
System.out.println(a+" "+b+" ");

}
  
}*/
