import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class FileTest {
	public static void main(String[] args)throws IOException{
		
	}
	
}
	









/*public static void main(String[] args)throws IOException{
		//从键盘上读取数据，并把读到的数据保存到out.txt中，知道用户输入了exit推出程序
		RandomAccessFile raf=new RandomAccessFile("out.txt","rw");
		Scanner sc=new Scanner(System.in);
		String s =sc.nextLine();  //读一行的内容放到s中
		while(!s.equals("exit")){
			//把s的内容写到raf所指向的文件中
			//把读写指钟移到文件的末尾
			raf.seek(raf.length());
			raf.write((s+"\r\n").getBytes());
			s =sc.nextLine();
			
		}
		raf.close();
	}		
}



		//读写文件过程有可能会产生IO异常，此时要进行处理或抛出，否则程序报错
	//类属性，没有static修饰的就是实例方法new FileTest().main()
	public static void main(String[] args)throws IOException{
		 * File file = new File(".");//"."表示当前路径
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		File tmpFile =File.createTempFile("aaa",".txt",file);
		tmpFile.deleteOnExit();
		
		//long毫秒数，123456789""="123456789"
		File newFile=new File(System.currentTimeMillis() + "");
		
		System.out.println("newFile"+ newFile.exists());
		newFile.createNewFile();  //如果文件不存在，则直接创建，如果文件存在，则覆盖
		
	
	}
	public static void main(String[] args) throws IOException{
		FileInputStream fis=new FileInputStream("a.txt");
		FileOutputStream fos=new FileOutputStream("newA.txt");
		byte[] buf =new byte[1024];
		int hasRead =0; //记录实际读取的字节数
		hasRead = fis.read(buf);
		while(hasRead >0){
			fos.write(buf,0,hasRead);
			hasRead=fis.read(buf);
			
		}	
		fis.close();
		fos.close();
	}
	public static void main(String[] args) throws IOException{
		FileReader fis=new FileReader("a.txt");
		FileWriter fos=new FileWriter("newb.txt");
		char[] buf =new char[1024];
		int hasRead =0; //记录实际读取的字节数
		hasRead = fis.read(buf);
		while(hasRead >0){
			fos.write(buf,0,hasRead);
			hasRead=fis.read(buf);
			
		}	
		fis.close();
		fos.close();
	}
}*/
