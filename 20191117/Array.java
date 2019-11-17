import java.util.Arrays;
class aa{
    private int a = 0;
    aa(int a){
        this.a = a;
    }
}

public class Array {
    public static void main(String[] args) {
        /*
        예외처리
        try{}
        catch(예외클래스 참조변수){(내용)}
        finally{}

        finally문은 무조건 실행되는 부분이다
        */

       try
        {
            int[] arr1 = new int[5];// int, double float의 자료형으로 선언한 기본적인 배열은 0으로 초기화가 되고
            String[] arr2 = new String[5]; // String 혹은 다른 객체의 자료형을 가진 배열들은 null로 초기화가 된다.
            //.length
            for(int count = 0; count < arr1.length;count++)
            {
                System.out.print(arr1[count] + " ");
            }
            //0 0 0 0 0
            System.out.println();
            for(int count = 0;count < arr2.length;count++)
            {
                System.out.print(arr2[count] + " ");
            }
            //null null null null null
            System.out.println();
            aa[] arr3 = new aa[5];
            for(int count = 0; count < arr3.length;count++)
            {
                System.out.print(arr3[count] + " ");
            }
            //null null null null null
            int[] arr4 = {1,2,3,4,5,6};
            String[] arr5 = {"a","b","c"};
            int[] arr6 = new int[10];
            Arrays.fill(arr6,9);
            System.out.println();
            for(int count = 0;count < arr6.length;count++)
            {
                System.out.print(arr6[count] + " ");
            }
            int[] arr7 = new int[10];
            System.arraycopy(arr4,2,arr7,1,4);
            System.out.println();
            for(int count = 0;count < arr7.length;count++)
            {
                System.out.print(arr7[count] + " ");
            }
            int sum = 0;
            for(int e : arr7)
            {
                sum += e;
            }
            System.out.println();
            System.out.println("Sum of Array7 is " + sum);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println();
            System.out.print("Wrong Index Number");
        }
    }
}
