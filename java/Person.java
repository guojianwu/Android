
public class Person {


	String name;
	int age;
	double height;
	void say(String c){
		System.out.println(c+"���ҵ����ֽ�"+name+",����"+age+"�꣬���"+height+"����");
	}
	void run(){
		System.out.println(name+"��Ħ��Ħ��,һ������,����ħ��Ĳ���...");
	}
	public static void main(String[] args){
		Person p1=new Person();
		p1.name ="����";
		p1.age =18;
		p1.height=178;
		p1.run();
		p1.say("Լ��");
		Person p2=new Person();
		p2.name="����";
		p2.age=20;
		p2.height=180;
		p2.say("���");
	}
}
