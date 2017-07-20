//写一个Person类包含姓名和年龄两个属性，还有一个说话的行为
//给出教师类（Teacher）和学生类（Students),分别继承Person类

class Person1 {
	public String name;
	public int age;
	public void say(){
		System.out.println("我是人类");
	}

}
class Teacher extends Person1{
	public String dept;
	public void say(){
		super.say();
		System.out.println("我叫"+name+",今年"+age+"岁。我在上课");
	}
}
class Student extends Person1{
	public void say(){
		System.out.println("我叫"+name+",今年"+age+"岁。我在学习");
	}
}
public class Person{
	public static void main(String[] args){
		Teacher t = new Teacher();
		t.name="小郭";
		t.age=25;
		t.say();
		Student s=new Student();
		s.name="小建";
		s.age=20;
		s.say();
		//Person p=new Person();
		//p.say();
     }
}
