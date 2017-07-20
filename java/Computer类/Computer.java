

 class Computer1 {
	 private String zidong;
	String pc_name;
	String pc_color;
	String pc_type;
	int pc_ram;//内存容量
	int pc_harddisk;//硬盘容量
	double pc_price;
	String pc_state;
	String pc_open;
	String pc_close;
	void pc_name(String c){
		System.out.println("电脑名称："+c);
	}void pc_color(String c){
		System.out.println("电脑的颜色："+c);
	}void pc_type(String c){
		System.out.println("电脑cpu的型号："+c);
	}void pc_ram(int c){
		System.out.println("电脑的内存容量为："+c+"G");
	}void pc_harddisk(int c){
		System.out.println("电脑的硬盘内存为："+c+"G");
	}void pc_price(double c){
		System.out.println("电脑的价格为："+c+"元");
	}void pc_open(String c){
		System.out.println(c);
	}void pc_state(String c){
		System.out.println(c);
	}void pc_colose(String c){
		System.out.println(c);
	
		
	}
	}
public class Computer{
	public static void main(String[] args){
		Computer1 p1=new Computer1();
		p1.pc_name("太阳");
		p1.pc_color("白色");
		p1.pc_type("Inter G600");
		p1.pc_ram(12);
		p1.pc_harddisk(230);
		p1.pc_price(8860.00);
		p1.pc_open("电脑正在启动中...");
		p1.pc_state("电脑正在使用中...");
		p1.pc_colose("电脑正在关机中...");
		
	}
}
