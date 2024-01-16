import java.util.*;

public class Java_Array {
    public static void main(String[] args) {

        /*
         * int[] code = { -4, -1, 3, 6, 11 };
         * int[] arr = new int[10];
         * for (int i = 0; i < arr.length; i++) {
         * int tmp = (int) (Math.random() * code.length);
         * arr[i] = code[tmp];
         * }
         * System.out.println(Arrays.toString(arr));
         */

        /*
         * int[] ball = new int[45];
         * 
         * for (int i = 0; i < ball.length; i++)
         * ball[i] = i;
         * 
         * int temp = 0;
         * int j = 0;
         * 
         * for (int i = 0; i < 6; i++) {
         * j = (int) (Math.random() * 45);
         * temp = ball[i];
         * ball[i] = ball[j];
         * ball[j] = temp;
         * }
         * 
         * for (int i = 0; i < 6; i++) {
         * System.out.printf("ball[%d] = %d\n", i, ball[i]);
         * }
         */

        /*
         * int[] numArr = new int[10];
         * 
         * for (int i = 0; i < numArr.length; i++) {
         * numArr[i] = i;
         * System.out.println(numArr[i]);
         * }
         * System.out.println();
         * 
         * for (int i = 0; i < numArr.length; i++) {
         * int n = (int) (Math.random() * 10);
         * int tmp = numArr[0];
         * numArr[0] = numArr[n];
         * numArr[n] = tmp;
         * }
         * 
         * for (int i = 0; i < numArr.length; i++) {
         * System.out.println(numArr[i]);
         * }
         */

        /*
         * // 5-6
         * int[] score = { 79, 88, 91, 33, 100, 55, 95 };
         * 
         * int max = score[0];
         * int min = score[0];
         * for (int i = 0; i < score.length; i++) {
         * if (score[i] > max)
         * max = score[i];
         * else if (score[i] < min)
         * min = score[i];
         * }
         * 
         * System.out.println("최대값 : " + max);
         * System.out.println("최소값 : " + min);
         */

        /*
         * // 5-5
         * int sum = 0;
         * float avg = 0f;
         * 
         * int[] score = { 100, 88, 100, 100, 90 };
         * 
         * for (int i = 0; i < score.length; i++)
         * sum += score[i];
         * 
         * avg = sum / (float) score.length;
         * 
         * System.out.println("총점 : " + sum);
         * System.out.println("평균 : " + avg);
         */

        /*
         * char[] abc = { 'A', 'B', 'C', 'D' };
         * char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
         * System.out.println(abc);
         * System.out.println(num);
         * 
         * char[] result = new char[abc.length + num.length];
         * System.arraycopy(abc, 0, result, 0, abc.length);
         * System.arraycopy(num, 0, result, abc.length, num.length);
         * System.out.println(result);
         * 
         * System.arraycopy(abc, 0, num, 0, abc.length);
         * System.out.println(num);
         * 
         * System.arraycopy(abc, 0, num, 6, 3);
         * System.out.println(num);
         */

    }
}
