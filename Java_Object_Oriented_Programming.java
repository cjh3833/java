import java.util.*;

public class Java_Object_Oriented_Programming {

}

class Tv {
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDoen() {
        --channel;
    }
}

class Tvtest4 {
    public static void main(String args[]) {
        Tv[] tvArr = new Tv[3];

        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i + 10;
        }

        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel = %d\n", i, tvArr[i].channel);
        }
    }
}

/*
 * class TvTest3 {
 * public static void main(String args[]) {
 * Tv t1 = new Tv();
 * Tv t2 = new Tv();
 * 
 * System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
 * System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
 * 
 * t2 = t1; // t1이 저장하고 있는 값(주소)를 t2에 저장
 * 
 * t1.channel = 7;
 * System.out.println("t1의 channel 값은 7입니다");
 * 
 * System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
 * System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
 * }
 * }
 */

/*
 * class TvTest2 {
 * public static void main(String args[]) {
 * Tv t1 = new Tv();
 * Tv t2 = new Tv();
 * 
 * System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
 * System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
 * 
 * t1.channel = 7;
 * System.out.println("t1의 channel 값은 7입니다");
 * 
 * System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
 * System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
 * }
 * }
 */