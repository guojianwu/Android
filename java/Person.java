
public class Person {


	String name;
	int age;
	double height;
	void say(String c){
		System.out.println(c+"，我的名字叫"+name+",今年"+age+"岁，身高"+height+"公分");
	}
	void run(){
		System.out.println(name+"在摩擦摩擦,一步两步,你是魔鬼的步伐...");
	}
	public static void main(String[] args){
		Person p1=new Person();
		p1.name ="张三";
		p1.age =18;
		p1.height=178;
		p1.run();
		p1.say("约吗？");
		Person p2=new Person();
		p2.name="李四";
		p2.age=20;
		p2.height=180;
		p2.say("你好");
	}
}
