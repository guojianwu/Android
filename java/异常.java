public class jia {
	public static void main(String[] args){
    try{
    	int a=3/0;
    	int[] b=new int[2];
    	System.out.println(b[2]);
    }
    catch(ArithmeticException e1){
       System.out.println("0����������");
	}
	catch(ArrayIndexOutOfBoundsException e2){
		System.out.println("����Խ��");}
   catch(Exception e){
	   System.out.println("����쳣");

	}finally{
		System.out.println("ʼ�ջᱻִ��һ��");
	}
}

}