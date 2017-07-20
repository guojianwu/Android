class Employee{     //员工类的定义
	String name;    //姓名
	int number;     //编号
	int age;        //年龄
	int salary;     //薪水
	public Employee(String name,int number,int age,int salary){
		this.name=name;
		this.number=number;
		this.age=age;
		this.salary=salary;
	}
}
public class Example18_1{
	static Employee [] e=new Employee[5];
	//求平均值
	public static int average(String type){
		int sum=0;
		for (int i=0;i<e.length;i++){
			if (type.equals("age"))	sum=sum+e[i].age;
			if (type.equals("salary")) sum=sum+e[i].salary;
		}
		return sum/e.length;
	}
	public static int minimum(String type){
		int min=0;
		if (type.equals("age")){
			min=e[0].age; 
			for (int i=1;i<e.length;i++){
				if (e[i].age<min) min=e[i].age;
			}
		}
		if (type.equals("salary")){
			min=e[0].salary;
			for (int i=1;i<e.length;i++){
				if (e[i].salary<min) min=e[i].salary;
			}
		}
		return min;
	}
	public static int maximum(String type){
		int max=0;
		if (type.equals("age")){
			max=e[0].age; 
			for (int i=1;i<e.length;i++){
				if (e[i].age>max) max=e[i].age;
			}
		}
		if (type.equals("salary")){
			max=e[0].salary;
			for (int i=1;i<e.length;i++){
				if (e[i].salary>max) max=e[i].salary;
			}
		}
		return max;
	}
	public static void main(String [] args){
		e[0]=new Employee("张三",1,25,1500);
		e[1]=new Employee("李四",2,30,2800);
		e[2]=new Employee("王五",3,45,4500);
		e[3]=new Employee("刘六",4,28,2400);
		e[4]=new Employee("赵七",5,32,3000);
		if (args.length==2){
			if (args[0].equals("age"))
			{	if(args[1].equals("min")) {
					System.out.println("最小年龄是"+minimum("age"));
				}
				else if(args[1].equals("max")) {
					System.out.println("最大年龄是"+maximum("age"));
				}
				else if(args[1].equals("avg")) {
					System.out.println("平均年龄是"+average("age"));
				}
				else 
System.out.println("输入不正确，请正确输入!");	
			}
			else if(args[0].equals("salary")){
				if(args[1].equals("min") ) {
					System.out.println("最低工资是"+minimum("salary"));
				}
				else if(args[1].equals("max")) {
					System.out.println("最高工资是"+maximum("salary"));
				}
				else if (args[1].equals("avg")) {
					System.out.println("平均工资是"+average("salary"));
				}
				else 
System.out.println("输入不正确，请正确输入!");		
			}
			else  System.out.println("输入不正确，请正确输入!");	
		}	
		else  System.out.println("输入不正确，请正确输入!");
	}	
}
