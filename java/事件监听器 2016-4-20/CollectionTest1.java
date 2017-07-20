import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class CollectionTest {
	public static void main (String[] args){
		Collection c=new ArrayList();
		c.add(new Integer(6));
		c.add("Html5");
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c);
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c.size());
		c.remove(new Integer(6));
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c);
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c.size());
		System.out.println("c�ļ����Ƿ����\"Html5\"�ַ�����"+c.contains("Html5"));
		c.add("Android");
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c);
		
		Collection book=new HashSet();  //����Ԫ�ز����ظ��ļ�������
		book.add("java");
		book.add("Andriod");
		System.out.println("book���ϵ�Ԫ��Ϊ:"+book);
		System.out.println("c�����Ƿ����\"book\"����?:"+c.containsAll(book));
		c.removeAll(book);
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c);
		c.clear();
		System.out.println("c���ϵ�Ԫ��Ϊ:"+c);
		book.retainAll(c);
		System.out.println("book���ϵ�Ԫ��Ϊ:"+book);
		
		
		
		
		
		
	}

}
