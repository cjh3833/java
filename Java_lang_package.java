
class StringEx6 {
    public static void main(String[] args) {
        int iVal = 100;
        String strVal = String.valueOf(iVal);

        double dVal = 200.0;
        String strVal2 = dVal + "";

        double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);

        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);

        System.out.println("sum + " + sum + ", sum2 = " + sum2);
    }
}

/* 예제 9-14 */
// class StringEx4 {
// public static void main(String[] args) {
// String animals = "dog,car,bear";
// String[] arr = animals.split(",");

// for (String s1 : arr)
// System.out.println(s1);

// System.out.println(String.join("-", arr));

// StringJoiner sj = new StringJoiner("/", "[", "]");

// for (String s : arr)
// sj.add(s);

// System.out.println(sj.toString());
// }
// }

/* 예제 9-13 */
// class StringEx3 {
// public static void main(String[] args) {
// // 길이가 0인 배열을 생성한다
// char[] cArr = new char[0];
// String s = new String("");
// String cs = new String(cArr);

// System.out.println("cArr.length = " + cArr.length);
// System.out.println("s.length = " + s.length());
// System.out.println("@@@" + cs + "@@@");
// }
// }

/* 예제 9-11 */
// class StringEx1 {
// public static void main(String[] args) {
// String str1 = "abc";
// String str2 = "abc";
// System.out.println("String str1 = \"abc\";");
// System.out.println("String str2 = \"abc\";");

// System.out.println("str1 == str2 ? " + (str1 == str2)); // true
// System.out.println("str1.equals(str2) ? " + str1.equals(str2)); // true
// System.out.println();

// String str3 = new String("\"abc\"");
// String str4 = new String("\"abc\"");

// System.out.println("String str3 = new String(\"abc\");");
// System.out.println("String str4 = new String(\"abc\");");

// System.out.println("str3 == str4 ? " + (str3 == str4)); // false
// System.out.println("str3.equals(str4) ? " + str3.equals(str4)); // true
// }
// }

/* 9-9예제 */
// class Circle implements Cloneable {
// Point p;
// double r;

// Circle(Point p, double r) {
// this.p = p;
// this.r = r;
// }

// public Circle shallowCopy() { // 얕은 복사
// Object obj = null;
// try {
// obj = super.clone();
// } catch (CloneNotSupportedException e) {

// }

// return (Circle) obj;
// }

// public Circle deepCopy() { // 깊은 복사
// Object obj = null;
// try {
// obj = super.clone();
// } catch (CloneNotSupportedException e) {

// }

// Circle c = (Circle) obj;
// c.p = new Point(this.p.x, this.p.y);

// return c;
// }

// public String toString() {
// return "(p = " + p + ", r = " + r + ")";
// }
// }

// class Point {
// int x, y;

// Point(int x, int y) {
// this.x = x;
// this.y = y;
// }

// public String toString() {
// return "(" + x + ", " + y + ")";
// }
// }

// class ShallowDeepCopy {
// public static void main(String[] args) {
// Circle c1 = new Circle(new Point(1, 1), 2.0);
// Circle c2 = c1.shallowCopy();
// Circle c3 = c1.deepCopy();

// System.out.println("c1 = " + c1);
// System.out.println("c2 = " + c2);
// System.out.println("c3 = " + c3);

// c1.p.x = 9; // 작동방식 ?
// c1.p.y = 9;

// System.out.println("c1의 값 변경 후");

// System.out.println("c1 = " + c1); // 원본은 그대로 갈거고
// System.out.println("c2 = " + c2); // 얕은 복사는 원본따라 바뀔거고
// System.out.println("c3 = " + c3); // 깊은 복사는 원본이랑 다르게 값 유지할거고
// }
// }

// /* 예제 9-8 */
// import java.util.*;

// class CloneEx2 {
// public static void main(String[] args) {
// int[] arr = { 1, 2, 3, 4, 5 };
// int[] arrClone = arr.clone(); // 배열 arr을 복제
// arrClone[0] = 6;

// System.out.println(Arrays.toString(arr));
// System.out.println(Arrays.toString(arrClone));
// }
// }

// /* 예제 9-7 */
// class Point implements Cloneable {
// int x, y;

// Point(int x, int y) {
// this.x = x;
// this.y = y;
// }

// public String toString() {
// return "X = " + x + ", Y = " + y;
// }

// public Object clone() {
// Object obj = null;
// try {
// obj = super.clone(); // clone()은 반드시 예외처리 해줘야한다
// } catch (CloneNotSupportedException e) {

// }
// return obj;
// }
// }

// class CloneEx1 {
// public static void main(String[] args) {
// Point original = new Point(3, 5);
// Point copy = (Point) original.clone(); // 복제(clone)해서 새로운 객체 생성, clone은
// Object메서드니까 point로 형변환

// System.out.println(original);
// System.out.println(copy);
// System.out.println(original.hashCode());
// System.out.println(copy.hashCode());
// }
// }

/* 예제 9-6 */
// class Card {
// String kind;
// int number;

// Card() {
// this("SPADE", 1); // Card(String kind, int number)를 호출
// }

// Card(String kind, int number) {
// this.kind = kind;
// this.number = number;
// }

// public String toString() {
// return "kind : " + kind + ", number : " + number; // Card 인스턴스의 kind와 number를
// 문자열로 반환한다
// }
// }

// class CardtoString2 {
// public static void main(String[] args) {
// Card c1 = new Card();
// Card c2 = new Card("HEART", 10);

// System.out.println(c1.toString());
// System.out.println(c2.toString());
// }
// }

/*
 * class ToStringTest {
 * public static void main(String[] args) {
 * String str = new String("KOREA");
 * java.util.Date today = new java.util.Date();
 * 
 * System.out.println(str);
 * System.out.println(str.toString());
 * System.out.println(today);
 * System.out.println(today.toString());
 * }
 * }
 */

/*
 * class Card {
 * String kind;
 * int number;
 * 
 * Card() {
 * this("SPADE", 1);
 * }
 * 
 * Card(String kind, int number) {
 * this.kind = kind;
 * this.number = number;
 * }
 * }
 * 
 * class CardToString {
 * public static void main(String[] args) {
 * Card c1 = new Card();
 * Card c2 = new Card();
 * 
 * System.out.println(c1.toString());
 * System.out.println(c2.toString());
 * }
 * }
 */

/*
 * class HashCodeEx1 {
 * public static void main(String[] args) {
 * String str1 = new String("abc");
 * String str2 = new String("abc");
 * 
 * System.out.println(str1.equals(str2));
 * System.out.println(str1.hashCode());
 * System.out.println(str2.hashCode());
 * System.out.println(System.identityHashCode(str1));
 * System.out.println(System.identityHashCode(str2));
 * }
 * }
 */

/*
 * class Person {
 * long id;
 * 
 * public boolean equals(Object obj) {
 * if (obj instanceof Person)
 * return id == ((Person) obj).id; // id값을 비교하기 위해서
 * else
 * return false;
 * }
 * 
 * Person(long id) {
 * this.id = id;
 * }
 * }
 * 
 * class EqualsEx2 {
 * public static void main(String[] args) {
 * Person p1 = new Person(8011081111222L);
 * Person p2 = new Person(8011081111222L);
 * 
 * if (p1 == p2)
 * System.out.println("p1 == p2");
 * else
 * System.out.println("p1 != p2");
 * 
 * if (p1.equals(p2))
 * System.out.println("p1 == p2");
 * else
 * System.out.println("p1 != p2");
 * }
 * }
 */

/*
 * class EqualsEx1 {
 * public static void main(String[] args) {
 * Value v1 = new Value(10);
 * Value v2 = new Value(10);
 * 
 * if (v1.equals(v2)) // equals는 주소값으로 비교
 * System.out.println("v1 == v2");
 * else
 * System.out.println("v1 != v2");
 * 
 * v2 = v1;
 * 
 * if (v1.equals(v2))
 * System.out.println("v1 == v2");
 * else
 * System.out.println("v1 != v2");
 * 
 * }
 * }
 * 
 * class Value {
 * int value;
 * 
 * Value(int value) {
 * this.value = value;
 * }
 * }
 */