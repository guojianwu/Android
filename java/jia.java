import java.util.Scanner;
public class jia{
public static void main(String args[]){
	System.out.println("请输入第四个数字：");
	
	  Scanner sc =new Scanner(System.in);
	  int[] a=new int[4];
	  for(int i=0;i<=a.length-1;i++){
	  a[i] = sc.nextInt();
	  }
	 if(a[0]<a[1]&&a[0]<a[2]&&a[0]<a[3])
		 System.out.println(a[0]);
	 else if(a[1]<a[2]&&a[1]<a[3])
		 System.out.println(a[1]);
	 else if(a[2]<a[3])
		 System.out.println(a[2]);
	 else
		 System.out.println(a[3]);
  
   } }