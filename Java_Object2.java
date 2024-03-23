import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.*;
import static java.lang.System.*;

// /* 예제9-22 */
// class MathEx3 {
// public static void main(String args[]) {
// int x1 = 1, y1 = 1; // (1,1)
// int x2 = 2, y2 = 2; // (2,2)
//
// double c = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2)); // sqrt 제곱근
// double a = c * sin(PI / 4);
// double b = c * cos(PI / 4);
//
// out.printf("a = %f%n", a);
// out.printf("b = %f%n", b);
// out.printf("c = %f%n", c);
// out.printf("angle%f rad%n", atan2(a, b));
// out.printf("angle=%f degree%n%n", atan2(a, b) * 180 / PI);
// }
// }

/* 예제 9-21 */
// class MathEx2 {
// public static void main(String args[]) {
// int i = Integer.MIN_VALUE;
//
// out.println("i = " + i);
// out.println("-i = " + (-i));
//
// try {
// out.printf("negateExact(%d) = %d%n", 10, negateExact(10));
// out.printf("negateExact(%d) = %d%n", -10, negateExact(-10));
// out.printf("negateExact(%d) = %d%n", i, negateExact(i));
// } catch (ArithmeticException e) {
// // i를 long타입으로 형변환 다음에 negateExact(long a)를 호출
// out.printf("negateExact(%d) = %d%n", (long) i, negateExact((long) i));
// }
// }
// }

/* 예제 9-20 */
// class MathEx1 {
// public static void main(String args[]) {

// // ceil : 올림, floor : 버림, round : 소수첫째자리에서 반올림
// // rint : 값과 가장 가까운 정수형값을 double로 반환
// double val = 90.7552;
// out.println("round : " + round(val));
// val *= 100;
// out.println("round : " + round(val));
// out.println("round " + val + " /100 : " + round(val / 100));
// out.println("round " + val + " /100.0 : " + round(val / 100.0));
// out.println();
// out.printf("ceil(%3.1f) = %3.1f%n", 1.1, ceil(1.1));
// out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.5));
// out.printf("round(%3.1f)=%d%n", 1.1, round(1.1));
// out.printf("round(%3.1f)=%d%n", 1.5, round(1.5));
// out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5));
// out.printf("round(%3.1f)=%d%n", -1.5, round(-1.5));
// out.printf("rint(%3.1f)=%f%n", -1.5, rint(-1.5));
// out.printf("ceil(%3.1f)=%f%n", -1.5, ceil(-1.5));
// out.printf("floor(%3.1f)=%f%n", -1.5, floor(-1.5));
// }
// }

/* 예제 */
// class ChainedExceptionEx {
// public static void main(String[] args) {
// try {
// install();
// } catch (InstallException e) {
// e.printStackTrace();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }

// static void install() throws InstallException {
// try {
// startInstall();
// copyFiles();
// } catch (SpaceException se) {
// InstallException ie = new InstallException("설치중 예외 발생");
// ie.initCause(se);
// } catch (MemoryException me) {
// InstallException ie = new InstallException("설치 중 예외발생");
// ie.initCause(me);
// throw ie;
// } finally {
// deleteTempFiles();
// }
// }

// static void startInstall() throws SpaceException, MemoryException {
// if (!enoughSpace()) {
// throw new SpaceException("설치할 공간이 부족합니다");
// }

// if (!enoughMemory()) {
// throw new MemoryException("메모리가 부족합니다");
// // throw new RuntimeException(new MemoryException("메모리가 부족합니다"));
// }
// }

// static void copyFiles() {
// }

// static void deleteTempFiles() {
// }

// static boolean enoughSpace() {
// // 설치에 필요한 공간있는지 확인하는 코드
// return false;
// }

// static boolean enoughMemory() {
// // 설치하는데 필요한 메모리 공간이 있는지 확인하는 코드
// return true;
// }
// }

// class InstallException extends Exception {
// InstallException(String msg) {
// super(msg);
// }
// }

// class SpaceException extends Exception {
// SpaceException(String msg) {
// super(msg);
// }
// }

// class MemoryException extends Exception {
// MemoryException(String msg) {
// super(msg);
// }
// }

/*
 * class Exception17 {
 * public static void main(String[] args) {
 * try {
 * method1();
 * } catch (Exception e) {
 * System.out.println("main메서드에서 예외가 처리되었습니다");
 * }
 * }
 * 
 * static void method1() throws Exception {
 * try {
 * throw new Exception();
 * } catch (Exception e) {
 * System.out.println("method1메서드에서 예외가 처리되었습니다");
 * throw e;
 * }
 * }
 * }
 */

/*
 * class TryWithResourceEx { // 자바 버전 1.7부터 사용가능한 try-with-resource문
 * public static void main(String args[]) {
 * try (CloseableResource cr = new CloseableResource()) {
 * cr.exceptionWork(false); // 예외가 발생하지않는다
 * } catch (WorkException e) {
 * e.printStackTrace();
 * } catch (CloseException e) {
 * e.printStackTrace();
 * }
 * System.out.println();
 * 
 * try (CloseableResource cr = new CloseableResource()) {
 * cr.exceptionWork(true);
 * } catch (WorkException e) {
 * e.printStackTrace();
 * } catch (CloseException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 * 
 * class CloseableResource implements AutoCloseable {
 * public void exceptionWork(boolean exception) throws WorkException {
 * System.out.println("exceptionWork(" + exception + ") 가 호출됨");
 * 
 * if (exception)
 * throw new WorkException("WorkException발생");
 * }
 * 
 * public void close() throws CloseException {
 * System.out.println("close()가 호출됨");
 * throw new CloseException("CloseException발생");
 * }
 * }
 * 
 * class WorkException extends Exception {
 * WorkException(String msg) {
 * super(msg);
 * }
 * }
 * 
 * class CloseException extends Exception {
 * CloseException(String msg) {
 * super(msg);
 * }
 * }
 */

/*
 * class InnerEx7 {
 * public static void mai(String[] args) {
 * Button b = new Button("Start");
 * b.addActionListener(new EventHandler());
 * 
 * }
 * }
 * 
 * class EventHandler implements ActionListener {
 * public void actionPerformed(ActionEvent e) {
 * System.out.println("ActionEvent occurred!!!");
 * }
 * }
 */

/*
 * class InnerEx6 {
 * Object iv = new Object() {
 * void method() {
 * }
 * };
 * 
 * static Object cv = new Object() {
 * void method() {
 * }
 * };
 * 
 * void myMethod() {
 * Object lv = new Object() {
 * void method() {
 * }
 * };
 * }
 * }
 * 
 * class Main123 {
 * public static void main(String[] args) {
 * 
 * }
 * }
 */

/*
 * class Outer {
 * class InstanceInner {
 * int iv = 100;
 * }
 * 
 * static class StaticInner {
 * int iv = 200;
 * static int cv = 300;
 * }
 * 
 * void myMethod() {
 * class LocalInner {
 * int iv = 400;
 * }
 * }
 * }
 * 
 * class InnerEx4 {
 * public static void main(String[] args) {
 * // 인스턴스 클래스의 인스턴스를 생성하려면 외부 클래스의 인스턴스를 먼저 생성해야한다
 * Outer oc = new Outer();
 * Outer.InstanceInner ii = oc.new InstanceInner();
 * 
 * System.out.println("ii.iv : " + ii.iv);
 * System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
 * 
 * // 스태틱내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다
 * Outer.StaticInner si = new Outer.StaticInner();
 * System.out.println("si.iv : " + si.iv);
 * }
 * }
 */

/*
 * class InnerEx3 {
 * private int outerIv = 0;
 * static int outerCv = 0;
 * 
 * class InstanceInner {
 * int iiv = outerIv; // 외부클래스의 private 멤버도 접근가능
 * int iiv2 = outerCv;
 * }
 * 
 * static class StaticIneer {
 * // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할수없다
 * // int siv = outerIv;
 * static int scv = outerCv;
 * }
 * 
 * void myMethod() {
 * int lv = 0;
 * final int LV = 0;
 * 
 * class LocalInner {
 * int liv = outerIv;
 * int liv2 = outerCv;
 * 
 * // int liv3 = lv;
 * int liv4 = LV;
 * }
 * }
 * }
 */

/*
 * class InnerEx2 {
 * class InstanceInner {
 * }
 * 
 * static class StaticInner {
 * }
 * 
 * // 인스턴스멤버 간에는 서로 직접 접근이 가능
 * InstanceInner iv = new InstanceInner();
 * 
 * // static멤버 간에는 서로 직접 접근 가능
 * static StaticInner cv = new StaticInner();
 * 
 * static void staticMethod() {
 * // static멤버는 인스턴스멤버에 직접 접근할 수 없다
 * // InstanceInner obj1 = new InstanceInner();
 * StaticInner obj2 = new StaticInner();
 * 
 * InnerEx2 outer = new InnerEx2();
 * InstanceInner obj1 = outer.new InstanceInner();
 * }
 * 
 * void instanceMethod() {
 * // 인스턴스메서드에서는 인스턴스 멤버와 static멤버 모두 접근이가능
 * InstanceInner obj1 = new InstanceInner();
 * StaticInner obj2 = new StaticInner();
 * // 메서드 내에 지역적으로 선언된 내부클래스는 외부에서 접근할 수 없다
 * // LocalInner lv = new LocalInner();
 * }
 * 
 * void myMethod() {
 * class LocalInner {
 * }
 * LocalInner lv = new LocalInner();
 * }
 * }
 */

/*
 * class RepairableTest {
 * public static void main(String[] args) {
 * Tank tank = new Tank();
 * Dropship dropship = new Dropship();
 * Marine marine = new Marine();
 * SCV scv = new SCV();
 * scv.repair(tank);
 * scv.repair(dropship);
 * }
 * }
 * 
 * interface Repairable {
 * 
 * }
 * 
 * class Unit {
 * int hitPoint;
 * final int MAX_HP;
 * 
 * Unit(int hp) {
 * MAX_HP = hp;
 * }
 * }
 * 
 * class GroundUnit extends Unit {
 * GroundUnit(int hp) {
 * super(hp);
 * }
 * }
 * 
 * class AirUnit extends Unit {
 * AirUnit(int hp) {
 * super(hp);
 * }
 * }
 * 
 * class Tank extends GroundUnit implements Repairable {
 * Tank() {
 * super(150);
 * hitPoint = MAX_HP;
 * }
 * 
 * public String toString() {
 * return "Tank";
 * }
 * }
 * 
 * class Dropship extends AirUnit implements Repairable {
 * Dropship() {
 * super(125);
 * hitPoint = MAX_HP;
 * }
 * 
 * public String toString() {
 * return "Dropship";
 * }
 * }
 * 
 * class Marine extends GroundUnit {
 * Marine() {
 * super(40);
 * hitPoint = MAX_HP;
 * }
 * }
 * 
 * class SCV extends GroundUnit implements Repairable {
 * SCV() {
 * super(60);
 * hitPoint = MAX_HP;
 * }
 * 
 * void repair(Repairable r) {
 * if (r instanceof Unit) {
 * Unit u = (Unit) r;
 * while (u.hitPoint != u.MAX_HP) {
 * u.hitPoint++;
 * }
 * System.out.println(u.toString() + "의 수리가 끝났습니다");
 * }
 * }
 * }
 */

/*
 * interface Parseable {
 * // 구문 분석작업을 수행한다
 * public abstract void parse(String fileName);
 * }
 * 
 * class ParserManager {
 * // 리턴타입이 Parseable인터페이스이다
 * public static Parseable getParser(String type) {
 * if (type.equals("XML"))
 * return new XMLParser();
 * else {
 * Parseable p = new HTMLParser();
 * return p;
 * }
 * }
 * }
 * 
 * class XMLParser implements Parseable {
 * public void parse(String fileName) {
 * System.out.println(fileName + " XML parsing completed");
 * }
 * }
 * 
 * class HTMLParser implements Parseable {
 * public void parse(String fileName) {
 * System.out.println(fileName + " HTML parsing completed");
 * }
 * }
 * 
 * class ParserTest {
 * public static void main(String[] args) {
 * Parseable parser = ParserManager.getParser("XML");
 * parser.parse("document.XML");
 * parser = ParserManager.getParser("HTML");
 * parser.parse("document2.html");
 * Parseable parser1 = new XMLParser();
 * parser1.parse("ds");
 * }
 * }
 */

/*
 * class FighterTest {
 * public static void main(String[] args) {
 * Fighter f = new Fighter();
 * if (f instanceof Unit)
 * System.out.println("Unit클래스의 자손");
 * if (f instanceof Fightable)
 * System.out.println("Fightable클래스의 자손");
 * if (f instanceof Movable)
 * System.out.println("Movable클래스의 자손");
 * if (f instanceof Attackable)
 * System.out.println("Attackable클래스의 자손");
 * if (f instanceof Object)
 * System.out.println("Object클래스의 자손");
 * }
 * }
 * 
 * class Fighter extends Unit implements Fightable {
 * public void move(int x, int y) {
 * 
 * }
 * 
 * public void attack(Unit u) {
 * 
 * }
 * }
 * 
 * class Unit {
 * int currentHP;
 * int x;
 * int y;
 * }
 * 
 * interface Fightable extends Movable, Attackable {
 * 
 * }
 * 
 * interface Movable {
 * void move(int x, int y);
 * }
 * 
 * interface Attackable {
 * void attack(Unit u);
 * }
 */

/*
 * class Product {
 * int price;
 * int bonusPoint;
 * 
 * Product(int price) {
 * this.price = price;
 * bonusPoint = (int) (price / 10.0);
 * }
 * }
 * 
 * class Tv extends Product {
 * Tv() {
 * super(100);
 * }
 * 
 * public String toString() {
 * return "TV";
 * }
 * }
 * 
 * class Computer extends Product {
 * Computer() {
 * super(200);
 * }
 * 
 * public String toString() {
 * return "Computer";
 * }
 * }
 * 
 * class Buyer {
 * int money = 1000;
 * int bonusPoint = 0;
 * 
 * void buy(Product p) {
 * if (money < p.price) {
 * System.out.println("잔액 부족");
 * return;
 * }
 * 
 * money -= p.price;
 * bonusPoint += p.bonusPoint;
 * System.out.println("물건을 구입하였습니다 : " + p);
 * }
 * }
 * 
 * class PolyArgumentTest {
 * public static void main(String[] args) {
 * Buyer b = new Buyer();
 * b.buy(new Tv());
 * b.buy(new Computer());
 * 
 * System.out.println("현재 남은 돈은 : " + b.money + "입니다");
 * System.out.println("현재 보너스 점수는 : " + b.bonusPoint + "입니다");
 * 
 * }
 * }
 */

/*
 * class BindingTest {
 * public static void main(String[] args) {
 * Parent p = new Parent();
 * Child c = new Child();
 * ChildChild cc = new ChildChild();
 * 
 * System.out.println("p.x = " + p.x);
 * System.out.println("c.x = " + c.x);
 * p.method();
 * c.method();
 * cc.method();
 * }
 * }
 * 
 * class Parent {
 * int x = 100;
 * 
 * void method() {
 * System.out.println("Parent method");
 * }
 * }
 * 
 * class Child extends Parent {
 * int x = 200;
 * 
 * void method() {
 * System.out.println("Child method");
 * }
 * }
 * 
 * class ChildChild extends Parent {
 * }
 */

/*
 * class InstanceofTest {
 * public static void main(String[] args) {
 * FireEngine fe = new FireEngine();
 * 
 * if (fe instanceof FireEngine) {
 * System.out.println("This is a FireEngine instance");
 * }
 * 
 * if (fe instanceof Car) {
 * System.out.println("This is a Car instance");
 * }
 * 
 * if (fe instanceof Object) {
 * System.out.println("This is an Object instance");
 * }
 * }
 * }
 * 
 * class Car {
 * 
 * }
 * 
 * class FireEngine extends Car {
 * 
 * }
 */

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