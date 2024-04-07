# java.lang패키지
- String클래스나 System클래스를 import문 없이 사용할 수 있었던 이유가 바로 java.lang패키지에 속한 클래스들이기 때문

<br><br>

## Object 클래스
- Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 멤버들은 모든 클래스에서 바로 사용가능하다

Object클래스의 메서드 | 설 명
--- | ---
protected Object clone() | 객체 자신의 복사본을 반환한다
public boolean equals(Object obj) | 객체 자신과 객체 obj가 같은 객체인지 알려준다 (같으면 true)
protected void finalize() | 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이 때 수행되어야하는 코드가 있을 때 오버라이딩한다 (거의 사용안함)
public Class getClass() | 객체 다신의 클래스 정보를 담고 있는 Class인스턴스를 반환한다
public int hachCode() | 객체 자신의 해시코드를 반환한다
public String toString() | 객체 자신의 정보를 문자열로 반환한다
public void notify() | 객체 자신이 사용하려고 기다리는 쓰레드를 하나만 깨운다
public void notifyAll() | 자신이 사용하려고 기다리는 모든 쓰레드를 깨운다
public void wait()<br>public void wait(long timeout)<br>public void wait(long timeout, int nanos) | 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 한다

- Object클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있다

<br><br>

### equals(Object obj)
- 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려주는 역할을 한다

- 두 객체의 같고 다름을 참조변수의 값으로 판단한다

```
public boolean equals(Object obj) {
    return (this == obj)
}
```
<br> 

- equals메서드는 주소값으로 비교

- String클래스등등은 Object클래스의 equals메서드를 오버라이딩한 뒤 String인스턴스가 가지는 문자열 값을 비교하도록 되어있다

<br><br>

### hashCode()
- 이 메서드는 해싱 기법에 사용되는 해시함수를 구현한 것

- 해싱은 데이터관리기법중 하나인데 다량의 데이터를 저장하고 검색하는 데 유용하다
- 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드(hashcode)를 반환한다

- 64bit JVM에서는 8byte 주소값으로 해시코드(4byte)를 만들기 때문에 해시코드가 중복될 수 있다
- String클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록 hashCode메서드가 오버라이딩되어 있기 때문에 문자열의 내용이 같은 str1("abc")과 str2("abc")에 대해 hashCode()를 호출하면 항상 동일한 해시코드값을 얻는다

- System.identityHashCode(Object x)는 Object클래스의 hashCode메서드처럼 객체의 주소값으로 해시코드를 반환하기 때문에 모든 객체에 대해 항상 다른 해시코드값을 반환

<br><br>

### toString()
- 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의

<br>
Object클래스에 정의된 toString()은 아래<br><br>

```
public String toString(){
    return getClass().getName() + "@" + Integet.toHexString(hashCode());
}
```
<br>


- 클래스를 작성할 때 toString()을 오버라이딩하지 않았다면 위와 같은 내용을 사용, toString()을 호출하면 클래스이름에 16진수의 해시코드값을 얻는다

- String 클래스의 toStirng()은 String인스턴스가 가지고 있는 문자열을 반혼하도록 오버라이딩되어 있다

- Object클래스에 정의된 toString()의 접근 제어자가 public이므로 Card클래스의 toString()의 접근제어자도 public
  - 조상에 정의된 접근범위보다 자손의 접근범위가 같거나 넓어야 한다

<br><br>

### clone()
- 자신을 복제하여 새로운 인스턴스를 생성하는 일을 한다

- Object클래스에 정의된 clone()은 단순히 인스턴스변수의 값만 복사하기 때문에 참조타입의 인스턴스 변수가 있는 클래스는 완전한 인스턴스 복제가 이뤄지지않는다

- ex) 배열의 경우 복제된 인스턴스도 같은 배열 주소를 가지기 때문에 작업이 원래 인스턴스에 영향을 끼친다, 이럴 경우 오버라이딩해서 새로운 배열을 생성하고 배열의 내용 복사하는 편이 좋다

- clone()을 사용하려면 복제할 클래스가 Cloneable인터페이스를 구현해야하고, clone()을 오버라이딩하면서 접근 제어자를 protect에서 public으로 변경해야 상속관계가 없는 다른 클래스에서 clone()을 호출가능해진다

<br>
참고 : Object클래스의 clone()은 Cloneable을 구현하지 않은 클래스 내에서 호출되면 예외를 발생시킴

<br>

- Cloneable인터페이스가 구현되어있다는 것은 클래스 작성자가 복제를 허용한다는 의미


<br><br>

### 공변타입 반환
- 이 기능은 오버라이딩할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것

<br><br>

### 얕은 복사와 깊은 복사
- 얕은 복사(shallow copy) : 얕은 복사에서는 원본을 변경하면 복사본도 영향을 끼친다
- 깊은 복사(deep copy) : 원본이 참조하고 있는 객체까지 복제, 원본과 복사본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복사본에 영향을 끼치지 않는다

- Object클래스의 clone()은 원본 객체가 가지고 있는 값만 그대로 복사한다

<br><br>

### getClass()
- 자신이 속한 클래스의 Class객체를 반환하는 메서드, Class객체는 이름이 'Class'인 클래스의 객체이다, Class클래스는 아래와 같이 정의되어있다

```
public final class Class implements...{ //Class클래스<
    ...
}
```

- 클래스 파일을 읽어서 사용하기 편한 형태로 저장해 놓은 것이 클래스객체

### 클래스 객체를 얻는 방법

```
Class cObj = new Card().getClass(); //생성된 객체로부터 얻는 방법
```

```
Class cObj = Card.class; //클래스 리터럴(*.class)로 부터 얻는 방법
```

```
Class cObj = Class.forName("Card"); //클래스의 이름으로부터 얻는 방법
```


Class객체를 이용하면 클래스에 정의된 멤버의 이름이나 개수 등 클래스에 대한 모든 정보를 얻을 수 있기 때문에 Class객체를 통해 객체를 생성하고 메서드를 호출하는 등 보다 동적인 코드 사용가능

<br>

```
Card c = new Card(); //new연산자를 이용해서 객체생성
```

```
Card c = new Card.class.newInstance(); //Class객체를 이용해서 객체생성
```

<br><br>

## String 클래스

★String 클래스는 중요하니 여러 번 보기★

<br>

### 변경 불가능한(immutable)클래스
- String 클래스에는 문자열을 저장하기 위해 문자형 배열 참조변수(char[]) value를 인스턴스 변수로 정의해놓고 있다

(참고) String클래스는 앞에 final이 붙어있어서 다른 클래스의 조상이 될 수 없다

```
public final class String implements java.io.Seializable, Comparable{
    private char[] value;
    ...
}
```

<br>

- 한 번 생성된 String 인스턴스가 가지고 있는 문자열은 읽어 올 수만 있고 변경은 못한다 (Read Only)

<br>

```
String a = "a";
String b = "b";
       a = a + b;
```

0x100 -> "a"<br>
0x200 -> "b"<br><br>
0x300 -> "ab"<br>
새로운 String인스턴스 생성

<br>

- 문자열간의 결합, 추출, 문자열을 다루는 작업이 많을 경우 StringBuffer클래스를 사용
- StringBuffer 인스턴스에 저장된 문자열은 변경가능, 1개의 인스턴스로 문자열을 다루는 게 가능

<br><br>

### 문자열의 비교
문자열을 만드는 방법은
1. 문자열 리터럴을 지정하는 방법
2. String 클래스의 생성자 사용해서 만드는 방법

```
String str1 = "abc"; //문자열 리터럴 "abc" 주소가 str1에 저장
String str2 = "abc"; //문자열 리터럴 "abc" 주소가 str2에 저장
String str3 = new String("abc"); //새로운 String인스턴스 생성
String str4 = new String("abc"); //새로운 String인스턴스 생성
```
<br>

- 문자열 리터럴- 이미 존재하는 것을 재사용
  - str1 == str2
  - 0x100 == 0x100
  - True
- String클래스 생성자 - 항상 새로운 String인스턴스 생성
  - str3 == str4
  - 0x200 == 0x300
  - False

<br>

문자열 == ->주소값 비교<br>
문자열 equals -> 내용물 비교

- 자바소스에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장

<br><br>

### 빈 문자열(empty stirng)
- String s = ""; 가능
- char형 변수에는 반드시 하나의 문자를 지정

```
String s = ""; //빈 문자열로 초기화
char c = ' '; 공백으로 초기화
```

<br><br>

### String 클래스의 생성자와 메서드
- String(string s)

- String(char[] value)
- String(StringBuffer buf)
- char charAt(int index)
- int compareTo(String str)
- String concat(String str)
- boolean endsWith(String suffix)
- boolean equals(Object obj)
- boolean equalsIgnoreCase(String str)
- int indexOf(int ch)
- int indexOf(int ch, int pos)
- int indexOf(String str)
- String intern()
- int lastIndexOf(int ch)
- int lastIndexOf(String str)
- int length()
- String replace(char old, char nw)
- String replace(CharSequence old, CharSequence nw)
- String replaceAll(String regex, String replacement)
- String[] split(String regex)
- String[] split(String regex, int limit)
- boolean startsWith(String prefix)
- String substring(int begin)<br>String substring(int begin, int end)
- String toLowerCase()
- String toString()
- String toUpperCase()
- String trim()

- static String valueOf()

<br><br>

### join()과 StringJoiner
- join()은 여러 문자열 사이에 구분자를 넣어서 결합
- split()와 반대의 작업

<br><br>

### String.format()

- format()은 형식화된 문자열을 만들어내는 간단한 방법
- printf()하고 사용법이 완전 똑같다

```
String str = String.format(%d 더하기 %d는 %d입니다.", 3, 5, 3+5)
System.out.println(str); //3 더하기 5는 8입니다
```

<br><br>

### 기본형 값을 String으로 변환

- 기본형을 문자열로 변경하는 방법은 숫자에 빈 문자열 ""을 더해준다
- valueOf()를 이용하는 방법도 있음

```
int i = 100;
String str1 = i + "";
String str2 = String.valueOf(i);
```

<br><br>


### String을 기본형 값으로 변환
- valueOf() 사용
- parseInt() 사용

```
int i = Integer.parseInt("100");
int i2 = Integer.valueOf("100");
```

기본형 -> 문자열 | 문자열 -> 기본형
--- | ---
String String.valueOf(boolean b)<br>String String.valueOf(char c)<br>String String.valueOf(int i)<br>String String.valueOf(long i)<br>String String.valueOf(float f)<br>String String.valueOf(double d) | boolean Boolean.parseBoolean(String s)<br> byte Byte.parseByte(String s)<br>short Short.parseShort(String s)<br>int Integer.parseInt(String s)<br>long Long.parseLong(String s)<br>float Float.parseFloat(Stirng s)<br>double Double.parseDouble(String s)
----
이 변환들은 프로그래밍에서 반드시 알고 있어야 하는 아주 중요한 내용

<br><br>

### StringBuffer 클래스와 StringBuilder클래스
- String클래스는 인스턴스를 생성할 때 지정된 문자열 변경x
- StringBuffer클래스는 변경가능

- StringBuffer인스턴스가 생성될 때, char형 배열이 생성되며, 이 때 생성된 char형 배열을 인스턴스 변수 value가 참조하게됨

```
public final class StringBuffer implements java.io.Serializble{
    private char[] value;
    ...
}
```

<br><br>

### StringBuffer의 생성자
- StringBuufer 클래스의 인스턴스를 생성할 때, 적절한 길이의 char형 배열이 생성되고 이 배열은 문자열을 저장하고 편집하기 위한 공간(Buffer)로 사용된다

- StringBuffer 인스턴스를 생성할 때 생성자 StringBuffer(int length)를 사용해서 저장될 문자열의 길이를 고려해서 여유있는 크기로 지정하는 것이 좋다

- 버퍼의 크기를 지정해주지 않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성

```
public StringBuffer(int length){
    value = new char[length];
    shared = false;
}

public StringBuffer(){
    this(16); // 버퍼 크기를 지정하지 않으면 크기는 16
}

public StringBuffer(String str){
    this(str.length() + 16); // 지정한 문자열의 길이보다 16 더 크게 버퍼 생성
    append(str);
}
```


<br><br>

### StringBuffer의 변경
- StringBuffer는 내용 변경 가능

```
StringBuffer sb = new StringBuffer("abc");

sb.append("123"); // sb 내용 뒤에 "123" 추가

StringBuffer sb2 = sb.append("ZZ");
System.out.println("sb"); // abc123ZZ
System.out.println("sb2"); //abc123ZZ
```

sb, sb2는 같은 주소 참조

<br><br>

### StringBuffer의 비교

- String 클래스에서는 equals메서드를 오버라이딩해서 문자열의 내용을 비교하도록 구현
- StringBuffer클래스는 equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도 등가비교연산자(==)로 비교한 것과 같은 결과

```
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb == sb2); //false
Systme.out.println(sb.equals(sb2)); //false
```

<br>

- 반면 toString()은 오버라이딩 되어있어 StringBuffer인스턴스에 toStirng()을 호출하면 담고있는 문자열을 String으로 반환한다

- String인스턴스에 담긴 문자열을 비교하기 위해선 StringBuffer 인스턴스에서 toString()을 호출한 뒤 String인스턴스를 얻은 다음 equals메서드를 사용해서 비교

<br>

```
String s = sb.toString();
String s2 = sb2.toString();

System.out.println(s.eqials(s2)); // true
```

<br><br>

### StringBuffer 클래스의 생성자와 메서드

StringBuffer는 추가, 변경, 삭제와 같이 저장된 내용을 변경할 수 있는 메서드들이 추가로 제공된다

480p 참고

<br><br>

### StringBuilder란 ?

- StringBuffer에서 쓰레드의 동기화를 제거한 것이 StringBuilder

<br><br>

## Math클래스
- Math클래스는 기본적인 수학계산에 유용한 메서드로 구성

- Math클래스의 생성자는 접근 제어자가 private, 다른 클래스에서 Math인스턴스를 생성할 수 없다

- 그 이유는 클래스 내에 인스턴스 변수가 하나도 없어서 인스턴스를 생성할 필요가 없다

<br>

### 올림, 버림, 반올림

- 소수n번째 자리에서 반올림한 값을 얻기 위해선 10의 n제곱으로 곱한 뒤 round()를 써주고 다시 곱한 수로 나눠주면 간단하다

목록 | 코드 |
--- | ---
ceil() | 올림
floor() | 버림
round() | 소수 첫째자리에서 반올림
rint() | 주어진 값과 가장 가까운 정수형 값을 double형태로 반환<br>두 정수의 정가운데 있는 값은 가장 가까운 짝수 정수를 반환


<br>

### 예외를 발생시키는 메서드

1000000 , 00000000 , 00000000 , 00000000   -> -2147483648 int의 최소값<br>
'~'연산(0은 1로, 1은 0으로 변환)<br><br>
0111111 , 11111111 , 11111111 , 11111111   -> 2147483648 int의 최대값<br>
(+1 오버플로우 발생)<br><br>
1000000 , 00000000 , 00000000 , 00000000   -> -2147483648


- 이렇게 되면 int의 최소값이 다시 원래 값이 되어버린다 그래서 try-catch문을 사용해 오버플로우가 발생하면 처리해주는 역할을 넣어주면 해결된다

<br><br>

### StrictMath클래스

- 반올림 처리 방법 설정이 OS마다 다를 수 있기 때문에 컴퓨터마다 결과가 다를 수 있다<br>이러한 차이를 없애기 위해 성능을 다소 포기하더라도 어떤 OS에서 실행되어도 항상 같은 결과를 얻도록 Math클래스를 새로 작성하는 것이 StrictMath클래스이다

<br>
Math클래스의 메서드 종류<br>
책 489쪽 참고

<br><br>

### 래퍼(wrapper)클래스
- 기본형 변수도 어쩔 수 없이 객체로 다뤄야할 때가 있다


예를들어
1. 매개변수로 객체를 요구할 때
2. 기본형 값이 아닌 객체로 저장해야할 때
3. 객체간의 비교가 필요할 때 등등

경우에는 기본형 값들을 객체로 변환하여 작업을 수행

<br><br>

- 이 때 사용되는 것이 래퍼 클래스이다, 8개의 기본형을 대표하는 8개의 레퍼클래스가 있는데, 이 클래스를 이용하면 기본형의 값을 객체로 다를 수 있다

- 래퍼클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받는다

<br>

아래 코드는 int형의 래퍼 클래스인 Integer클래스의 실제 코드이다
```
public final class Integer extends Number implements Comparale{
    ...
    private int value;
    ...
}
```

<br><br>

기본형 | 래퍼클래스 | 생성자 | 활용예
--- | --- | --- | ---
boolean | Boolean | Boolean(boolean value)<br>Boolean(String s) | Boolean b = new Boolean(true);<br>Boolean b2 = new Boolean("true");
char | Character | Character(char value) | Character c = new Character('a');
byte | Byte | Byte (byte value)<br>Byte (String s) | Byte b = new Byte(10);<br>Byte b2 = new Byte("10");
short | Short | Shrot (short value)<br>short (String s) | Shrot s = new Short(10);<br>Short s2 = new Short("10");
int | Integer | Integer(int value)<br>Integer(String s) | Integer i = new Integer(100);<br>Integer i2 = new Integer("100");
long | Long | Long (long value)<br>Long (String s) | Long l = new Long(100);<br>Long l2 = new Long("100")
double | Double | Double (double value)<br>Double (String s) | Double d = new Double(1.0);<br>Double d2 = new Double("1.0");

래퍼 클래스의 생성자


<br>
- 래퍼 클래스는 모두 equals()가 오버라이딩되어 있어서 주소값이 아닌 객체가 가지고 있는 값을 비교한다, 그래서 실행결과를 보면 equals()를 이용한 두 Interger객체의 비교결과가 true라는 것을 알 수 있다


<br><br>

### Number 클래스
- Number클래스(부모) - wrapper클래스(자손)


<br><br>

### 문자열을 숫자로 변환하기
- 문자열을 숫자로 변환할 때는

```
int i = new Integer("100").intValue();
int i2 = Integer.parseInt("100"); // 주로 이 방법을 많이 사용한다
Integer i3 = Integer.valueOf("100"); // wrapper 클래스

```


| 문자열 -> 기본형 | 
| --- |
byte b = Byte.parseByte("100");
short s = Short.parseShort("100");
int i = Integer.parseInt("100");
long l = Long.parseLong("100");
float f = Float.parseFloat("3.14");
double d = Double.parseDouble("3.14");


<br>

| 문자열 -> 래퍼 클래스 | 
| --- | 
Byte b = Byte.valueOf("100");
Short s = Short.valueOf("100");
Integer i = Integer.valueOf("100");
Long l = Long.valueOf("100");
Float f = FLoat.valueOf("3.14");
Double d = Double.valueOf("3.14");

<br>

- JDK1.5 부터 도입된 오토박싱 기능때문에 반환값이 기본형일때와 래퍼클래스일때의 차이가 없어졌다<br>그래서 구별없이 valueOf()를 쓰는것도 괜찮다

<br><br>

### 오토박싱 & 언박싱(autoboxing & unboxing)
- JDK1.5 이후에는 기본형과 참조형 간의 덧셈이 가능

```
int i = 5;
Integer iObj = new Integer(7);

int sum = i + iObj; //에러, 기본형과 참조형 간의 덧셈 불가(JDK1.5 이전)
```

- 컴파일러가 자동으로 변환하는 코드를 넣어주기 떄문
- 아래의 경우 Integer객체를 int타입의 값으로 변환해주는 intValue()를 추가해준다

<br>

컴파일 전의 코드 | 컴파일 후의 코드
--- | ---
int i = 5;<br>Integer iObj = new Integer(7);<br><br>int sum = i + iObj; | int i = 5;<br>Integer iObj = new Integer(7);<br><br>int sum = i + iObj.intValue();


<br>

- 오토박싱 : 기본형 값을 래퍼 클래스의 객체로 자동 변환해주는 것

- 언박싱 : 래퍼 클래스의 객체를 기본형 값으로 자동 변환


```
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10); //오토박스. 10 -> new Integer(10);

int Value = list.get(0); //언박싱. new Integer(10) -> 10
```

<br>

컴파일 전의 코드 | 컴파일 후의 코드
--- | ---
Integer intg = (Integer)i;<br>Object obj = (Object)i;<br>Long lng = 100L; | Integer intg = Integer.valueOf(i);<br>Object obj = (Object)Integer.valueOf(i);<br>Long lng = new Long(100L);

<br><br>

## 2. 유용한 클래스
