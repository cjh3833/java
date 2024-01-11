
/*
        Date : 2024.01.08
        Source : Hello java, Java_Chapter_2
        Author : 최재형
*/
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        char ch = 'A';
        int code = (int) ch;
        System.out.printf("%c = %d(%#X) %n", ch, code, code);

        char hch = '가';
        System.out.printf("%c = %d(%#X)%n", hch, (int) hch, (int) hch);

        System.out.println('\'');
        System.out.println("abc\t123\b456");
        System.out.println('\n');
        System.out.println("\"Hello\"");
        System.out.println("c:\\");

        /*
         * Scanner scanner = new Scanner(System.in); // Scanner 클래스의 객체를 생성
         * String input = scanner.nextLine(); // 입력받은 내용을 input에 저장
         * int num = Integer.parseInt(input); // 입력받은 내용을 int 타입의 값으로 변환
         * 
         * System.out.println("입력내용 : " + input);
         * System.out.printf("num = %d\n", num);
         */

        /*
         * int finger = 10;
         * char c = 'A';
         * float f3 = 3.14e3f;
         * System.out.printf("finger = [%5d]\n", finger);
         * System.out.printf("finger = [%-5d]\n", finger);
         * System.out.printf("finger = [%010d]\n", finger);
         * System.out.printf("c = %c, %d\n", c, (int) c);
         * System.out.printf("%f, %e, %g", f3, f3, f3);
         */
    }
}
