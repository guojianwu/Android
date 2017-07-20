
class Person {


	String name;
	private int age;
	double height;
	void say(String c){
		System.out.println(c+"，我的名字叫"+name+",今年"+age+"岁，身高"+height+"公分");
	}
	void run(){
		System.out.println(name+"在摩擦摩擦,一步两步,你是魔鬼的步伐...");
	}
	void setAge(int a){
		if(a>=0&&a<=150)
		age=a;
		else{
			System.out.println("你输入的年龄不合法");
		}
		
		}
	int getAge(){
			return age;
	}
	}

public class Test{
	public static void main(String[] args){
		Person  p1=new Person ();
		p1.name ="张三";
		p1.setAge(180);
		p1.height=178;
		p1.run();
		p1.say("约吗？");
         Person p2=new Person ();
		p2.name="李四";
		p2.setAge(19);
		p2.height=180;
		p2.say("你好");
		System.out.println(p1.getAge());
}}