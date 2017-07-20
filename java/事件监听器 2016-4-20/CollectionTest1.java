import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class CollectionTest {
	public static void main (String[] args){
		Collection c=new ArrayList();
		c.add(new Integer(6));
		c.add("Html5");
		System.out.println("c集合的元素为:"+c);
		System.out.println("c集合的元素为:"+c.size());
		c.remove(new Integer(6));
		System.out.println("c集合的元素为:"+c);
		System.out.println("c集合的元素为:"+c.size());
		System.out.println("c的集合是否包含\"Html5\"字符串："+c.contains("Html5"));
		c.add("Android");
		System.out.println("c集合的元素为:"+c);
		
		Collection book=new HashSet();  //无序，元素不可重复的集合类型
		book.add("java");
		book.add("Andriod");
		System.out.println("book集合的元素为:"+book);
		System.out.println("c集合是否包含\"book\"集合?:"+c.containsAll(book));
		c.removeAll(book);
		System.out.println("c集合的元素为:"+c);
		c.clear();
		System.out.println("c集合的元素为:"+c);
		book.retainAll(c);
		System.out.println("book集合的元素为:"+book);
		
		
		
		
		
		
	}

}
