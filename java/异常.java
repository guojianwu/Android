public class jia {
	public static void main(String[] args){
    try{
    	int a=3/0;
    	int[] b=new int[2];
    	System.out.println(b[2]);
    }
    catch(ArithmeticException e1){
       System.out.println("0不能作除数");
	}
	catch(ArrayIndexOutOfBoundsException e2){
		System.out.println("数组越界");}
   catch(Exception e){
	   System.out.println("最大异常");

	}finally{
		System.out.println("始终会被执行一次");
	}
}

}