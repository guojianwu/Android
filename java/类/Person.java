//дһ��Person����������������������ԣ�����һ��˵������Ϊ
//������ʦ�ࣨTeacher����ѧ���ࣨStudents),�ֱ�̳�Person��

class Person1 {
	public String name;
	public int age;
	public void say(){
		System.out.println("��������");
	}

}
class Teacher extends Person1{
	public String dept;
	public void say(){
		super.say();
		System.out.println("�ҽ�"+name+",����"+age+"�ꡣ�����Ͽ�");
	}
}
class Student extends Person1{
	public void say(){
		System.out.println("�ҽ�"+name+",����"+age+"�ꡣ����ѧϰ");
	}
}
public class Person{
	public static void main(String[] args){
		Teacher t = new Teacher();
		t.name="С��";
		t.age=25;
		t.say();
		Student s=new Student();
		s.name="С��";
		s.age=20;
		s.say();
		//Person p=new Person();
		//p.say();
     }
}
