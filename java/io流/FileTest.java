import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class FileTest {
	public static void main(String[] args)throws IOException{
		
	}
	
}
	









/*public static void main(String[] args)throws IOException{
		//�Ӽ����϶�ȡ���ݣ����Ѷ��������ݱ��浽out.txt�У�֪���û�������exit�Ƴ�����
		RandomAccessFile raf=new RandomAccessFile("out.txt","rw");
		Scanner sc=new Scanner(System.in);
		String s =sc.nextLine();  //��һ�е����ݷŵ�s��
		while(!s.equals("exit")){
			//��s������д��raf��ָ����ļ���
			//�Ѷ�дָ���Ƶ��ļ���ĩβ
			raf.seek(raf.length());
			raf.write((s+"\r\n").getBytes());
			s =sc.nextLine();
			
		}
		raf.close();
	}		
}



		//��д�ļ������п��ܻ����IO�쳣����ʱҪ���д�����׳���������򱨴�
	//�����ԣ�û��static���εľ���ʵ������new FileTest().main()
	public static void main(String[] args)throws IOException{
		 * File file = new File(".");//"."��ʾ��ǰ·��
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		File tmpFile =File.createTempFile("aaa",".txt",file);
		tmpFile.deleteOnExit();
		
		//long��������123456789""="123456789"
		File newFile=new File(System.currentTimeMillis() + "");
		
		System.out.println("newFile"+ newFile.exists());
		newFile.createNewFile();  //����ļ������ڣ���ֱ�Ӵ���������ļ����ڣ��򸲸�
		
	
	}
	public static void main(String[] args) throws IOException{
		FileInputStream fis=new FileInputStream("a.txt");
		FileOutputStream fos=new FileOutputStream("newA.txt");
		byte[] buf =new byte[1024];
		int hasRead =0; //��¼ʵ�ʶ�ȡ���ֽ���
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
		int hasRead =0; //��¼ʵ�ʶ�ȡ���ֽ���
		hasRead = fis.read(buf);
		while(hasRead >0){
			fos.write(buf,0,hasRead);
			hasRead=fis.read(buf);
			
		}	
		fis.close();
		fos.close();
	}
}*/
