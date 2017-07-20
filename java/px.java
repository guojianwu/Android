import java.util.Scanner;
public class px {
	public static void main(String args[]){
		System.out.println("请输入第四个数字：");
		  Scanner sc =new Scanner(System.in);
		  int[] a=new int[6];
		  for(int i=0;i<=a.length-1;i++){
			  a[i] = sc.nextInt();
	  }
		  
		  for(int i=0;i<a.length-1;i++){
			  for(int j=i+1;j<a.length-1;j++){
				  if(a[i]>a[j]){
					  int temp;
					  temp=a[i];
					  a[i]=a[j];
					  a[j]=temp;
					  
				  }
			  }
		  }
		  for(int i=0;i<=a.length-1;i++){
			  System.out.println(a[i]+"  ");
		  }
        

}
}