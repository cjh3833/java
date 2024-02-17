import static java.lang.System.out;
import static java.lang.Math.*;

class InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();

        if (fe instanceof FireEngine) {
            System.out.println("This is a FireEngine instance");
        }

        if (fe instanceof Car) {
            System.out.println("This is a Car instance");
        }

        if (fe instanceof Object) {
            System.out.println("This is an Object instance");
        }
    }
}

class Car {

}

class FireEngine extends Car {

}

/*
 * class CastingTest1 {
 * public static void main(String[] args) {
 * Car car = null;
 * Car car2 = null;
 * FireEngine fe = null;
 * 
 * car.drive();
 * fe = (FireEngine) car;
 * fe.drive();
 * car2 = fe;
 * car2.drive();
 * }
 * }
 * 
 * class Car {
 * String color;
 * int door;
 * 
 * void drive() {
 * System.out.println("drive, brr~");
 * }
 * 
 * void stop() {
 * System.out.println("stop!!");
 * }
 * }
 * 
 * class FireEngine extends Car {
 * void water() {
 * System.out.println("water!!!");
 * }
 * }
 */

/*
 * class exImport {
 * public static void main(String[] args) {
 * out.println(random());
 * out.println("Math.PI : " + PI);
 * }
 * }
 */

/*
 * class ImportTest {
 * public static void main(String[] args) {
 * Date today = new Date();
 * 
 * SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
 * SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
 * 
 * System.out.println("오늘 날짜는 " + date.format(today));
 * System.out.println("현재 시간은 " + time.format(today));
 * }
 * }
 */

/*
 * class PointTest {
 * public static void main(String[] args) {
 * Point3D p3 = new Point3D();
 * System.out.println("p3.x = " + p3.x);
 * System.out.println("p3.y = " + p3.y);
 * System.out.println("p3.z = " + p3.z);
 * }
 * }
 * 
 * class Point {
 * int x = 10;
 * int y = 20;
 * 
 * Point(int x, int y) {
 * this.x = x;
 * this.y = y;
 * }
 * }
 * 
 * class Point3D extends Point {
 * int z;
 * 
 * Point3D() {
 * this(100, 200, 300);
 * }
 * 
 * Point3D(int x, int y, int z) {
 * super(x, y);
 * this.z = z;
 * }
 * }
 */

/*
 * class SuperText {
 * public static void main(String[] args) {
 * Child c = new Child();
 * c.method();
 * }
 * }
 * 
 * class Parent {
 * int x = 10;
 * }
 * 
 * class Child extends Parent {
 * int x = 20;
 * 
 * void method() {
 * System.out.println("x = " + x);
 * System.out.println("this.x = " + this.x); // 자손클래스에서 선언된 멤버변수 20
 * System.out.println("super.x = " + super.x); // 상속이니까 10
 * }
 * }
 */

/*
 * class TV {
 * boolean power;
 * int channel;
 * 
 * void power() {
 * power = !power;
 * };
 * 
 * void channelUP() {
 * ++channel;
 * };
 * 
 * void channelDown() {
 * --channel;
 * };
 * }
 * 
 * class VCR {
 * boolean power;
 * int counter = 0;
 * 
 * void power() {
 * power = !power;
 * };
 * 
 * void play() {
 * };
 * 
 * void stop() {
 * };
 * 
 * void rew() {
 * };
 * 
 * void ff() {
 * };
 * }
 * 
 * class TVCR extends TV {
 * VCR vcr = new VCR();
 * 
 * void play() {
 * vcr.play();
 * }
 * 
 * void stop() {
 * vcr.stop();
 * }
 * }
 */

/*
 * class DrawShape {
 * public static void main(String[] args) {
 * Point[] p = {
 * new Point(100, 100),
 * new Point(140, 50),
 * new Point(200, 200)
 * };
 * Triangle t = new Triangle(p);
 * Circle c = new Circle(new Point(150, 150), 50);
 * 
 * t.draw();
 * c.draw();
 * }
 * 
 * }
 * 
 * class Shape {
 * String color = "black";
 * 
 * void draw() {
 * System.out.printf("[color = %s]\n", color);
 * }
 * }
 * 
 * class Point {
 * int x;
 * int y;
 * 
 * Point(int x, int y) {
 * this.x = x;
 * this.y = y;
 * }
 * 
 * Point() {
 * this(0, 0);
 * }
 * 
 * String getXY() {
 * return "(" + x + "," + y + ")";
 * }
 * }
 * 
 * class Circle extends Shape {
 * Point center; // 원의 원점좌표, 포함관계
 * int r;
 * 
 * Circle() {
 * this(new Point(0, 0), 100); // Circle(Point center, int r)를 호출
 * }
 * 
 * Circle(Point center, int r) {
 * this.center = center;
 * this.r = r;
 * }
 * 
 * void draw() {
 * System.out.printf("[center = (%d, %d), r = %d, color = %s]\n", center.x,
 * center.y, r, color);
 * }
 * }
 * 
 * class Triangle extends Shape {
 * Point[] p = new Point[3];
 * 
 * Triangle(Point[] p) {
 * this.p = p;
 * }
 * 
 * void draw() {
 * System.out.printf("[p1 = %s, p2 = %s, p3 = %s, color = %s] \n", p[0].getXY(),
 * p[1].getXY(), p[2].getXY(),
 * color);
 * }
 * }
 */

/*
 * class Tv {
 * boolean power;
 * int channel;
 * 
 * void power() {
 * power = !power;
 * }
 * 
 * void channelUp() {
 * ++channel;
 * }
 * 
 * void channelDown() {
 * --channel;
 * }
 * }
 * 
 * class CaptionTv extends Tv {
 * boolean caption;
 * 
 * void displayCaption(String text) {
 * if (caption) {
 * System.out.println(text);
 * }
 * }
 * }
 * 
 * public class Java_Object2 {
 * public static void main(String args[]) {
 * CaptionTv ctv = new CaptionTv();
 * ctv.channel = 10;
 * ctv.channelUp();
 * System.out.println(ctv.channel);
 * 
 * ctv.displayCaption("Hello world");
 * ctv.caption = true;
 * ctv.displayCaption("Hello");
 * 
 * }
 * }
 */