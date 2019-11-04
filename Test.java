import java.util.*;

class b{
	private int a,c;
	b(int a,int c){
		this.a = a;
		this.c = c;
	}
	public int getA() {
		return this.a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getC() {
		return this.c;
	}
	public void setC(int c) {
		this.c=c;
	}
}

public class Test {
	public static void main(String[] args)
	{
		b rt = new b(10,20);
		/*System.out.println("A의값은 " + rt.getA());//10
		System.out.println("C의값은 " + rt.getC());//20
		
		rt.setA(50);
		rt.setC(100);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ변경후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("A의값은 " + rt.getA());//50
		System.out.println("C의값은 " + rt.getC());//100*/
		
		Scanner sc = new Scanner(System.in);
		
		String pp = "Hello World";
		String newString = sc.next();
		System.out.println(pp + newString); //Hello WorldJava
		sc = new Scanner(System.in);
		String string2 = sc.nextLine();
		System.out.println(pp + string2);
	}
}


