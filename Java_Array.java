import java.util.*;

public class Java_Array {
    public static void main(String[] args) {

        int[][] m1 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] m2 = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };

        final int ROW = m1.length;
        final int COL = m2[0].length;
        final int M2_ROW = m2.length;

        int[][] m3 = new int[ROW][COL];

        // 행렬의 곱 m1 * m2의 결과를 m3에 저장
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                for (int k = 0; k < M2_ROW; k++)
                    m3[i][j] += m1[i][k] * m2[k][j];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%d ", m3[i][j]);
            }
            System.out.println();
        }

        /*
         * // 예제 5-29 좌표에 x표하기
         * final int SIZE = 5;
         * int x = 0, y = 0;
         * char[][] board = new char[SIZE][SIZE];
         * byte[][] shipBoard = {
         * { 1, 0, 0, 0, 0 },
         * { 0, 1, 0, 0, 0 },
         * { 0, 0, 1, 0, 0 },
         * { 0, 0, 0, 1, 0 },
         * { 0, 0, 0, 0, 1 },
         * };
         * 
         * for (int i = 1; i < SIZE; i++) {
         * board[0][i] = board[i][0] = (char) (i + '0');
         * }
         * 
         * Scanner scanner = new Scanner(System.in);
         * 
         * while (true) {
         * System.out.println("좌표를 입력하세요. (종료는 00)>");
         * String input = scanner.nextLine();
         * 
         * if (input.length() == 2) {
         * x = input.charAt(0) - '0';
         * y = input.charAt(1) - '0';
         * 
         * if (x == 0 && y == 0)
         * break;
         * }
         * if (input.length() != 2 || x <= 0 || x >= SIZE || y <= 0 || y > SIZE) {
         * System.out.println("잘못된 입력입니다 다시 입력해주세요");
         * continue;
         * }
         * 
         * board[x][y] = shipBoard[x - 1][y - 1] == 1 ? 'O' : 'X';
         * 
         * for (int i = 0; i < SIZE; i++) {
         * System.out.println(board[i]);
         * }
         * System.out.println();
         * }
         */

        /*
         * int[][] score = {
         * { 100, 100, 100 },
         * { 20, 20, 20 },
         * { 30, 30, 30 },
         * { 40, 40, 40 },
         * { 50, 50, 50 }
         * };
         * 
         * int korTotal = 0, engTotal = 0, mathTotal = 0;
         * System.out.println("번호  국어  영어  수학  총점  평균");
         * System.out.println("================================");
         * 
         * for (int i = 0; i < score.length; i++) {
         * int sum = 0;
         * float avg = 0.0f;
         * 
         * korTotal += score[i][0];
         * engTotal += score[i][1];
         * mathTotal += score[i][2];
         * System.out.printf("%3d", i + 1);
         * 
         * for (int j = 0; j < score[i].length; j++) {
         * sum += score[i][j];
         * System.out.printf("%7d", score[i][j]);
         * }
         * 
         * avg = sum / (float) score[i].length;
         * System.out.printf("%5d %5.1f\n", sum, avg);
         * }
         */

        /*
         * int[][] score = {
         * { 100, 100, 100 },
         * { 20, 20, 20 },
         * { 30, 30, 30 },
         * { 40, 40, 40 }
         * };
         * int sum = 0;
         * 
         * for (int i = 0; i < score.length; i++) {
         * for (int j = 0; j < score[i].length; j++) {
         * System.out.printf("score[%d][%d] = %d\n", i, j, score[i][j]);
         * }
         * }
         * 
         * for (int[] tmp : score) {
         * for (int i : tmp) {
         * sum += i;
         * }
         * }
         * 
         * System.out.println("sum = " + sum);
         */

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