
class Person {


	String name;
	private int age;
	double height;
	void say(String c){
		System.out.println(c+"���ҵ����ֽ�"+name+",����"+age+"�꣬���"+height+"����");
	}
	void run(){
		System.out.println(name+"��Ħ��Ħ��,һ������,����ħ��Ĳ���...");
	}
	void setAge(int a){
		if(a>=0&&a<=150)
		age=a;
		else{
			System.out.println("����������䲻�Ϸ�");
		}
		
		}
	int getAge(){
			return age;
	}
	}

public class Test{
	public static void main(String[] args){
		Person  p1=new Person ();
		p1.name ="����";
		p1.setAge(180);
		p1.height=178;
		p1.run();
		p1.say("Լ��");
         Person p2=new Person ();
		p2.name="����";
		p2.setAge(19);
		p2.height=180;
		p2.say("���");
		System.out.println(p1.getAge());
}}