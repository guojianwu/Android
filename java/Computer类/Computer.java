

 class Computer1 {
	 private String zidong;
	String pc_name;
	String pc_color;
	String pc_type;
	int pc_ram;//�ڴ�����
	int pc_harddisk;//Ӳ������
	double pc_price;
	String pc_state;
	String pc_open;
	String pc_close;
	void pc_name(String c){
		System.out.println("�������ƣ�"+c);
	}void pc_color(String c){
		System.out.println("���Ե���ɫ��"+c);
	}void pc_type(String c){
		System.out.println("����cpu���ͺţ�"+c);
	}void pc_ram(int c){
		System.out.println("���Ե��ڴ�����Ϊ��"+c+"G");
	}void pc_harddisk(int c){
		System.out.println("���Ե�Ӳ���ڴ�Ϊ��"+c+"G");
	}void pc_price(double c){
		System.out.println("���Եļ۸�Ϊ��"+c+"Ԫ");
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
		p1.pc_name("̫��");
		p1.pc_color("��ɫ");
		p1.pc_type("Inter G600");
		p1.pc_ram(12);
		p1.pc_harddisk(230);
		p1.pc_price(8860.00);
		p1.pc_open("��������������...");
		p1.pc_state("��������ʹ����...");
		p1.pc_colose("�������ڹػ���...");
		
	}
}
