import java.io.*;

class ExceptionEx15 {
    public static void main(String[] args) {
        // command line에서 입력받은 값을 이름으로 가지는 파일을 생성한다
        File f = createFile(args[0]);
        System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다");
    }

    static File createFile(String fileName) {
        try {
            if (fileName == null || fileName.equals(""))
                ;
            throw new Exception("파일 이름이 유효하지 않습니다");
        } catch (Exception e) {
            fileName = "제목없음.txt";
        } finally {
            File f = new File(fileName);
            createNewFile(f);
            return f;
        }
    }

    static void createNewFile(File f) {
        try {
            f.createNewFile();
        } catch (Exception e) {
        }
    }

}

/*
 * class ExceptionEx12 {
 * public static void main(String[] args) throws Exception {
 * method1();
 * }
 * 
 * static void method1() throws Exception {
 * method2();
 * }
 * 
 * static void method2() throws Exception {
 * throw new Exception("에러발생");
 * }
 * }
 */

/*
 * class Exception10 {
 * public static void main(String[] args) {
 * throw new RuntimeException();
 * }
 * }
 */

/*
 * class Exception9 {
 * public static void main(String[] args) {
 * try {
 * Exception e = new Exception("고의로 발생시킴");
 * throw e; // 예외 발생시킴
 * // throw new Exception("고의로 발생시킴"); //위 2줄을 1줄로 줄여서 쓸 수 있다
 * } catch (Exception e) {
 * System.out.println("에러 메세지 : " + e.getMessage());
 * e.printStackTrace();
 * }
 * System.out.println("프로그램 정상종료 됐음");
 * }
 * }
 */

/*
 * class ExceptionEx8 {
 * public static void main(String[] args) {
 * System.out.println(0);
 * System.out.println(1);
 * try {
 * System.out.println(2);
 * System.out.println(0 / 0); // 여기서 에러처리되고 그 뒤 4는 실행안된다
 * System.out.println(4);
 * } catch (ArithmeticException ae) {
 * ae.printStackTrace();
 * System.out.println("예외메세지 : " + ae.getMessage());
 * }
 * System.out.println(6);
 * }
 * }
 */

/*
 * class ExceptionEx7 {
 * public static void main(String[] args) {
 * System.out.println(0);
 * System.out.println(1);
 * try {
 * System.out.println(2);
 * System.out.println(0 / 0); // 여기서 에러처리되고 그 뒤 4는 실행안된다
 * System.out.println(4);
 * } catch (ArithmeticException ae) {
 * if (ae instanceof ArithmeticException)
 * System.out.println("true");
 * System.out.println("ArithmeticException");
 * } catch (Exception e) {
 * System.out.println("Exception");
 * }
 * System.out.println(6);
 * }
 * }
 */

/*
 * class ExceptionEx6 {
 * public static void main(String[] args) {
 * System.out.println(0);
 * System.out.println(1);
 * try {
 * System.out.println(2);
 * System.out.println(0 / 0); // 여기서 에러처리되고 그 뒤 4는 실행안된다
 * System.out.println(4);
 * } catch (Exception e) { // Arithmetic 대신 Exception써도 가능 대신 어떤 종류의 예외라도 이걸로 처린
 * System.out.println(5);
 * }
 * System.out.println(6);
 * }
 * }
 */

/*
 * class ExceptionEx5 {
 * public static void main(String[] args) {
 * System.out.println(0);
 * System.out.println(1);
 * try {
 * System.out.println(2);
 * System.out.println(0 / 0); // 여기서 에러처리되고 그 뒤 4는 실행안된다
 * System.out.println(4);
 * } catch (ArithmeticException e) {
 * System.out.println(5);
 * }
 * System.out.println(6);
 * }
 * }
 */

/*
 * class ExceptionEx3 {
 * public static void main(String[] args) {
 * int number = 100;
 * int result = 0;
 * 
 * for (int i = 0; i < 10; i++) {
 * try {
 * result = number / (int) (Math.random() * 10);
 * System.out.println(result);
 * } catch (ArithmeticException e) {
 * System.out.println("0");
 * }
 * }
 * }
 * }
 */

/*
 * class ExceptionEx2 {
 * public static void main(String[] args) {
 * int number = 100;
 * int result = 0;
 * 
 * for (int i = 0; i < 10; i++) {
 * result = number / (int) (Math.random() * 10); // 7번째 라인
 * System.out.println(result);
 * }
 * }
 * }
 */

/*
 * class ExceptionEx1 {
 * public static void main(String[] args) {
 * try {
 * try {
 * } catch (Exception e1) {
 * }
 * } catch (Exception e) {
 * try {
 * } catch (Exception e2) {
 * }
 * } // try_catch의 끝
 * 
 * try {
 * 
 * } catch (Exception e) {
 * 
 * } // try_catch의 끝
 * }
 * }
 */