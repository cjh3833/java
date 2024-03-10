/* 예제 9-7 */
class Point implements Cloneable {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "X = " + x + ", Y = " + y;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone(); // clone()은 반드시 예외처리 해줘야한다
        } catch (CloneNotSupportedException e) {

        }
        return obj;
    }
}

class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point) original.clone(); // 복제(clone)해서 새로운 객체 생성, clone은 Object메서드니까 point로 형변환

        System.out.println(original);
        System.out.println(copy);
        System.out.println(original.hashCode());
        System.out.println(copy.hashCode());
    }
}

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