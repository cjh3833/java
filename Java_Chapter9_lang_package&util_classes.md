# java.lang패키지
- String클래스나 System클래스를 import문 없이 사용할 수 있었던 이유가 바로 java.lang패키지에 속한 클래스들이기 때문

<br><br>

### Object 클래스
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

<pre>
<code>
public final class Class implements...{ //Class클래스<
    ...
}
</code>
<pre>
