import java.util.Scanner;

class pp{
    private int a;
    private int b;
    // a b를 인스턴스 생성과 동시에 초기화시켜주는 생성자와 a b 각각의 getter setter를 this를 이용해서 작성
    pp(int a, int b){
        this.a=a;
        this.b=b;
    }
    int getA()
    {
        return this.a;
    }
    int getB()
    {
        return this.b;
    }
    void setA(int a)
    {
        this.a = a;
    }
    void setB(int b)
    {
        this.b = b;
    }

}
public class test {
    public static void main(String[] args)
    {
        pp u = new pp(1,2);
        System.out.println("a : " + u.getA());
        System.out.println("b :"+u.getB());
        u.setA(3);
        u.setB(4);
        System.out.println("a :" + u.getA());
        System.out.println("b :"+ u.getB());
    }

}
