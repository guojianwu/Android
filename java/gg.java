import java.util.Scanner;
public class gg {
	public static void main(String args[]){
		System.out.println("请输入第四个数字：");
		  Scanner sc =new Scanner(System.in);
		  int[] a=new int[4];
		  for(int i=0;i<=a.length-1;i++){
			  a[i] = sc.nextInt();
		  }
		  int min=a[0];
		  for(int j=1;j<=a.length-1;j++){
			  if(a[j]<min){
				  min=a[j];
			  }
		  }
		  System.out.println(min);
      }
}
