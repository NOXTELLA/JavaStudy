
# Review Java
***
### 자바 이름규칙

1 . 클래스 이름규칙

  - Camel Case모델을 지킬것 
    - 클래스 이름의 첫 문자는 대문자로 시작
    - 둘 이상의 단어가 묶여서 하나의 이름을 이룰 때는 새로 시작하는 단어의 첫 글자는 대문자로 해줄것
    - ex : Camel + Case = CameCase
    
    
2 . 메소드와 변수 이름규칙

  - 변형된 Camel Case모델을 지킬것
    - 메소드와 변수는 Camel Case모델에서 하나가 변형된다. 바로 첫문자를 소문자로 한다는 것이다
    - ex : Camel + Case = camelCase
    
    
3 . 상수 이름규칙

  - 상수의 이름 규칙은 모든 글자를 대문자로 구성하는것을 관례로 한다
  - ex : final int INTEAGER_A
 
### 자바 생성자에 대해(Java Constructor)

- 생성자 이름은 자신이 선언된 클래스의 이름과 동일해야 한다.
- 생성자는 어떠한 반환타입도 가지지 않는다.
- 생성자 호출은 인스턴스 생성의 마지막 단계에 해당한다.
- 어떤 경우든 생성자가 존재하지 않는 경우는 인스턴스로 볼 수 없다.
  - 생성자 선언을 안한 경우가 존재한다.그런 경우에는 JavaCompiler에서 '디폴트 생성자'(Default Compiler)를 클래스에 넣어서 규칙을 성립하게 만들어 준다.
  
 ### 자바 접근 수준 지시자(Access-level Modifiers)
 
 1 . 종류 : public, protected, private, default
 
 2 . 특징 
 
  - default
    - 의미 : 아무런 선언도 하지 않은 상황을 의미함
    - 사용되는경우 
      - 클래스 정의
      - 클래스의 인스턴스 변수와 메소드
   
  - public
    - 의미 : 어디서든 해당 클래스의 인스턴스를 생성할 수 있다.
    - 반대로 default로 클래스가 정의되는 경우 동일 패키지로 묶인 클래스 내에서만 인스턴스 생성을 허용한다.
   
  - private
    -의미 : 정보은닉을 위해서 사용된다. private로 변수를 선언할 시 동일 클래스 내에 정의된 메소드를 통해서만 해당 변수에 접근이 가능해 진다.
  - protected

### 클래스 변수(Class Variable)

- 클래스 변수는 변수에 static을 붙여서 선언을 하게된다. 클래스 변수는 선언된 클래스의 모든 인스턴스가 공유하는 변수이다.
- 클래스 변수는 인스턴스 생성 전에 메모리상에 존재한다.

``` java
class Op{
    static int io = 0;
    void Op(){
        io++;
    }
}
public class ClassVar2 {
    public static void main(String[] args)
    {
        Op.io += 1;
        System.out.println(Op.io); // 1이 나온다
        //인스턴스 선언 없이도 클래스변수에 접근하여 연산을 할 수 있다. 이를 통해서 클래스 변수는 인스턴스 생성 전에 메모리에 존재함을 알 수 있다.
    }
}
```

- 클래스 로딩(Class loading) : '클래스 정보를 가상머신이 읽는다'라는 표현의 정의이다. 이는 가상머신이 특정 클래스 정보를 읽는 행위를 가리켜 '클래스 로딩'이라고 한다.특정 클래스의 인스턴스가 생성되기 위해서는 해당 클래스가 반드시 가상머신에 의해 읽혀져야 한다. 즉 인스턴스 생성보다 클래스 로딩이 먼저 된다는것을 알 수 있다.
- 클래스 변수는 인스턴스간 데이터 공유가 필요한 상황에서 클래스 변수를 선언한다.

```java
class Circle_Ck{
    // 원주율 pi는 모든 Circle_Ck 인스턴스가 참조해야하는 값이지만 각각의 인스턴스가 지녀야하는 값은 아니고 변경해서는 안되는 고유값이므로 final로 상수선언까지 해준것이다. 
    //이러한 변수들을 클래스 변수들로 선언해주면 좋다.
    static final double pi = 3.14;
    private double rad;
    Circle_Ck(double rad_n){
        rad = rad_n;
    }
    public void showRound()
    {
        System.out.println("Round length of circle : " + (rad * 2 * pi));
    }
    public void width()
    {
        System.out.println("Width of circle : " + (rad * rad * pi));
    }
}

public class Circle {
    public static void main(String[] args)
    {
        Circle_Ck ui = new Circle_Ck(3.5);
        ui.showRound();
        ui.width();
    }
}
```

### 클래스 메소드(Class Method)

- 클래스 메소드 : 클래스 메소드도 클래스 변수와 동일하게 static을 통해서 선언을 해준다
- 클래스 메소드의 성질은 다음과 같다.
  - 인스턴스 생성 전부터 접근이 가능하다.
  - 어떠한 인스턴스에도 속하지 않는다.
  - 클래스 메소드 또한 인스턴스 생성 전에 호출이 된다

```java
class NumberPrint{
    private int num = 0;
    static void showInt(int a)
    {
        System.out.println("A : " + a);
    }
    static void showDouble(double b)
    {
        System.out.println("B : " + b);
    }
    void setNum(int c)
    {
        num = c;
    }
}
public class ClassMethod {
    public static void main(String[] args)
    {
        //클래스 메소드도 클래스 변수와 동일하게인스턴스 생성 전부터 접근할 수 있다.
        NumberPrint.showDouble(3.14);
        NumberPrint.showInt(10);
        NumberPrint op = new NumberPrint();
        op.showDouble(4.1);
        op.showInt(20);
    }
}

/*결과
B : 3.14
A : 10
B : 4.1
A : 20
 */
 ```
 - 클래스 메소드 선언이 이점이 되는 경우
 
 ```java
 //이와 같은 경우에 Cal이라는 클래스에는 단지 외부에 기능을 제공하기 위해서 사용되는 메소드밖에 없다. 또한 인스턴스 변수의 값을 참조하거나 수정하지 않는다.
//즉 이러한 메소드들은 딱히 인스턴스에 속할 필요가 없다는것을 알 수 있다. 이러한 경우에는 클래스 메소드로 사용하는것이 좋은 방법이다.
class Cal{
    static final double pi = 3.14;
    static int add(int a, int b)
    {
        return a - b;
    }
    static int min(int a, int b)
    {
        return a - b;
    }
    static int multi(int a, int b)
    {
        return a * b;
    }
    static double divide(int a, int b)
    {
        return a / b;
    }
}
public class ClassMethodCons {
    public static void main(String[] args)
    {
        System.out.println("10 - 1 is " + Cal.min(10,1));
        System.out.println("5 + 6 is " + Cal.add(5,6));
        System.out.println("10 x 3 is " + Cal.multi(10,3));
        System.out.println("10 / 4 is " + Cal.divide(10,4));
    }
}
```

### 왜 public static void main(String[] args)인가?

- 여기까지 알았다면 왜 main메소드를 public static void main() 형태로 쓰는지 이해할 수 있을것이다. 우선 이 형태는 일종의 약속이라는것을 알고가면 좋다.

- **public** : 우선 main메소드가 호출되는 영역인 클래스의 외부에서 호출된다. 그렇기 때문에 우선 public선언을 해주는것이 맞다.
- **static** : main메소드는 인스턴스가 생성되기 이전에 호출된다. 즉 static선언을 해주어야 한다.
- void : 반환형

- 이러한 단계로 public static void main()이 되는것을 알 수 있다.

### static 선언

- 다음과 같은 코드가 있다고 가정하자

```java
public class StaticInitial {
    static String date;
    public static void main(String[] args)
    {
        System.out.println("Today date : " + date);
    }
}
```
- 위 코드는 현재 날짜 정보가 담긴 클래스 변수 date를 출력하는것을 시도하고 있다.
- 하지만 클래스 변수는 선언과 동시에 메모리에 올라가기 때문에 따로 초기화를 시켜줄수 있는 방법이 있다. 만약 date변수가 클래스 변수가 아닌 인스턴스 변수인 경우에는 

```java
import java.time.LocalDate;

LocalDate dNow = LocalDate.now();
date = dNow.toString();
```
- 위 부분을 추가해 주면 된다. 하지만 현재는 클래스 변수이므로 static선언을 이용하여 선언과 동시에 초기화가 가능하도록 해주어야한다.

```java
import java.time.LocalDate;

public class StaticInitial {
    static String date;
    static {
        LocalDate dNow = LocalDate.now();
        date = dNow.toString();
    }
    public static void main(String[] args)
    {
        System.out.println("Today date : " + date);
    }
}
```
### 메소드 오버로딩(Method Overloading)

- 한 클래스 내에서 동일한 이름의 메소드를 둘 이상 정의하는것은 문법상 허용되지 않는다. 하지만 매개변수의 선언을 다르게 하면 메소드 오버로딩(Method Overloading)이라는 것이 허용되며 동일한 메소드를 둘 이상 정의하는것이 허용되게 된다.

- 메소드 오버로딩이 되는 경우는 두가지가 있다

  - 동일한 메소드의 이름, 자료형 + 매개변수 개수가 다른경우
  - 동일한 메소드의 이름, 자료형, 매개변수 개수, 매개변수의 자료형
 
- 메소드 오버로딩이 허용되지 않는 경우

  - 메소드의 이름은 같으나 선언된 자료형이 다른 경우.
 
- 예시 코드와 위의 경우를 살펴보자.

```java
class OpTest{
    public static void CP(int a)
    {
        int op = a;
        System.out.println(op);
    }
    public static void CP(int a, int b)
    {
        int lp =  a + b;
        System.out.println(lp);
    }
    public static void CP(double a)
    {
        double ip = a;
        System.out.println(ip);
    }
    public static int CP(int a) // 컴파일 에러
    {
        return a;
    }
}

public class MethodOveerloading {
    public static void main(String[] args)
    {
        OpTest t = new OpTest();
        t.CP(30);
        t.CP(30,40);
        t.CP(2.10);
    }
}
/*결과
30
70
2.10*/
```
- 생성자(Constructor) 또한 메소드 오버로딩의 대상이 될 수 있다.

```java
class Uo{
    private int t = 0;
    private int e = 0;
    private double q = 0;
    Uo(int a, int b)
    {
        t = a;
        e = b;
    }
    Uo(int a, double b)
    {
        t = a;
        q = b;
    }
    void test()
    {
        System.out.println(t);
        System.out.println(e);
        System.out.println(q);
    }
}
public class MethodOverloading2 {
    public static void main(String[] args)
    {
        Uo qw = new Uo(10, 20);
        Uo er = new Uo(40,4.5);
        qw.test();
        er.test();
    }
}
/*
10
20
0.0

40
0
4.5
*/
```
- 위의 예시코드를 보면 Uo 생성자 2개가 존재한다. 하는 int, int를 받는것이고, 하나는 int, double을 받는것이다.main메소드를 보면 알 수 있듯이, 두개의 형태의 생성자를 선언할 수 있다.(qw, er)

### String 클래스

- 문자열을 선언할떄는 String클래스를 이용해서 선언한다. 이부분은 기본적인 선언이기에 기초지식은 생략하겠다.
- 우선 이 코드를 한번 살펴보자.

```java
public class StringClass {
    public static void main(String[] args)
    {
        String str3 = "Hello";
        String str4 = "Hello";

        String str5 = new String("World");
        String str6 = new String("World");
        /*
            참조변수를 대상으로 == 연산을 할 경우에는 참조변수의 참조값에대한 비교연산을 한다.
         */
        if(str3 == str4)
        {
            System.out.println("str3와 str4는 동일한 인스턴스 참조한다");
        }
        else
        {
            System.out.println("str3와 str4는 다른 인스턴스 참조한다");
        }

        if(str5 == str6)
        {
            System.out.println("str5와 str6는 동일한 인스턴스 참조");
        }
        else
        {
            System.out.println("str5와 str6는 다른 인스턴스 참조");
        }
    }
}
```

-이 코드의 결과를 한번 예상해보자. 문자열을 비교할때는 .equals()를 쓰는 거라고 알고있는 사람들은 str3==str4가 약간 의아하게 보일수도 있다. 우선 이 코드의 결과는 다음과 같다.

~~~
 str3와 str4는 동일한 인스턴스 참조한다
 str5와 str6는 다른 인스턴스 참조
~~~

- 여기서 말하는 str3 == str4의 문자열 값에 대한것을 말하는것이 아니다. 여기서 말하는것은 String 인스턴스가 참조하는 참조값에 대한것을 이야기 하는 것이다.

- 그렇다면 str3 str4비교와 str5 str6의 비교에는 어떠한 차이가 있는것일까? 우선적으로 바로 보이는 차이점부터 보면 str3 str4는 String 타입을 바로 대괄호로 선언한 것이고, str5,str6는 String 인스턴스를 각각 만들어 준것이다.

- 지금 말한 그 차이점이 결과값에 차이를 보였다고 할 수있다. 그 이유는 다음과 같다.

> 자바의 String인스턴스는 immutable한 인스턴스이다.

- 여기서 immutable이란 **변경이 불가능하다** 라는 뜻을 지니고 있는 단어이다.그리고 String인스턴스가 기본적으로 변경할 수 없는것은 인스턴스가 갖는 문자열의 내용이다. 즉 여기서 하는 말은 즉슨

```java
String str3 = "Hello";
String str4 = "Hello";
```

- 위의 코드는 

```java
String str3 = "Hello";
String str4 = str3;
```

- 와 같은 의미를 지니게 되는것이다. 이를 통해서 알 수 있는것은 문자열 내용이 같은경우에는 하나의 인스턴스를 생성해서 이를 공유하는 방식으로 처리한다는것을 알 수 있다.


### 배열(Array)

- 배열의 정의 : 타입이 동일한 둘 이상의 데이터를 저장할 수 있는 1차원 구조의 메모리 공간

- 자바에서의 기본적인 배열 형태는 다음과 같다. 이와 같이 선언한 경우 배열은 **null** 혹은 **0**으로 초기화되게 된다.
    ~~~
    (자료형)[] 참조변수 = new (자료형)[배열의 크기]
    ~~~


- 기본적인 자바에서 배열 선언예시는 다음과 같다
    ```java
    public class Array1 {
    public static void main(String[] args)
    {
        int[] arrayT = new int[10];
        double[] arrayY = new double[100];
        String[] arrayU = new String[90];
    }
    }
    ```

- 배열에서 요소를 지정하기 위해서는 인덱스번호를 이용해서 접근할 수 있다. 당연한 이야기이지만 Index번호는 0번부터 시작을 하게된다.

    ```java
    class Box{
    private String cont;
    Box(String cont){
        this.cont = cont;

    }
    public String getCont(){
        return this.cont;
    }
    }

    public class Array2 {
    private String conts;
    public static void main(String[] args)
    {
        Box[] arrayU = new Box[3];
        arrayU[0] = new Box("Hello");
        arrayU[1] = new Box("World");
        arrayU[2] = new Box("Java");
        for(int a = 0;a < arrayU.length;a++)
        {
            System.out.println(arrayU[a].getCont());
        }
    }
    }
    ```

- 배열 생성과 동시에 초기화 또한 가능하다.

    ```java
    class sumArray{
    static int sumArr(int[] arr)
    {
        int sum = 0;
        for(int count = 0;count < arr.length;count++)
        {
            sum += arr[count];
        }
        return sum;
    }
    }

    public class Array4 {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sumArray.sumArr(arr));
    }
    }
    ```

- 배열에는 두가지의 대표적인 메소드가 있다. 자세한건 예시코드 주석으로 작성해 놓았다.

    ~~~
    - length : 배열의 길이를 반환해준다.
    - fill : 특정 값으로 채워준다.
    - arraycopy : 배열을 복사해준다.
    ~~~

    ```java
    import java.util.Arrays;

    public class ArrayMethods {
    public static void main(String[] args)
    {
        int[] arr1 = new int[10];
        System.out.println("arr1's length : "+arr1.length);
        int[] arr2 = new int[10];
        //.length : 배열.length를 해준면된다
        //.fill : java.util.Arrays를 선언해야 사용이 가능하다. 기본적으로 fill(배열, 채울값) 순서의 매개변수를 가진다.
        //.arraycopy : 기본적으로  System클래스 안에있다. System.arraycopy(복사 원배열,복사할 값의 인덱스 번호,복사할 배열, 값 복사 시작 인덱스, 복사할 개수)
        Arrays.fill(arr1,10);
        System.arraycopy(arr1,0,arr2,2,4);
        for(int e: arr1)
        {
            System.out.print(e + " ");
        }
        System.out.println();
        for(int e : arr2)
        {
            System.out.print(e + " ");
        }
    }
    }

    ```
    ~~~
    결과
    arr1's length : 10
    10 10 10 10 10 10 10 10 10 10 
    0 0 10 10 10 10 0 0 0 0 
    ~~~

- Enhanced for : 프로그램을 작성하다 보면 배열에 저장된 모든 요소들을 출력하거나 연산하는 경우가 있다. 배열에 대해 Enhanced for를 쓰면 for문을 좀더 간결하게 사용할 수 있다. 약간 파이썬에서 list에 대해 for문을 쓸때와 비슷한 기능을 할 수 있게해준다.

- Enhanced for의 기본 형태는 다음과 같다.
    ~~~
    Enhanced for statement

    for(요소 : 배열)
    {

    }
    ~~~
    ```python
    #Python : for statement with list
    li = [1,2,3,4,5]
    for a in li:
        print(a)
    ```
    ```java
    /*
    Java : Enhanced for statement with array

    Enhanced For
    형태

    -파이썬의 for문과 역할이 비슷해진다.

    for(요소  : 배열){
    }

    */

    public class Array5 {
        public static void main(String[] args)
        {
            int[] ar = {1,2,3,4,5,6,7,8,9,10};
            for(int e : ar)
            {
                System.out.println(e);
            }
            int sum = 0;
            for(int e : ar)
            {
                sum += e;
            }
            System.out.println(sum);
        }
    }

    ```

