# Java Chapter 5. 배열
헷갈리는 부분, 중요한 부분 정리
## 배열(array)

- 배열은 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
  
<br><br>

## 배열의 선언과 생성
  
  선언방법 | 선언 예
  --- | ---
  타입[] 변수이름; | int[] score;<br>String[] name;
  타입 변수이름[]; | int score[]; <br> String name[];
  ---

  <br>

  - 배열의 생성
    - 타입 [] 변수이름; // 배열을 생성(배열을 다루기 위한 참조변수 선언)
    - 변수이름 = new 타입[길이]; //배열을 생성(실제 저장공간을 생성)
  
  - int[] score;<br> score = new int[5];
  - int[] score = new int[5];

<br>

### 배열의 길이와 인덱스
- score[3] = 100;<br> int value = score[3];

- 유효한 범위를 벗어난 값을 index로 사용하는 것은 배열을 다룰 때 가장 많이 하는 실수, 
- 실행시에 에러 (ArrayIndexOutOfBoundsException)가 발생

- 배열의 길이는 int범위의 양의 정수(0도 포함)이어야 한다

#### 배열이름.length
- int[] arr = new int[5]; //길이가 5인 int 배열
- int tmp = arr.length; //tmp에 5가 저장
- 값을 읽을 수만 있고 변경할 수 없다 (상수)

#### 배열의 길이 변경하는 방법 :
1. 더 큰 배열을 새로 생성한다
2. 기존 배열의 내용을 새로운 배열에 복사한다
<br><br>


## 배열의 초기화 
- int[] score = new int[] {50, 60, 70, 80, 90}; //배열의 생성과 초기화를 동시
- int[] score = {50, 60, 70, 80, 90}; //new int[] 생략가능
<br>

### 배열의 출력
- for문 사용없이 'Arrays.toString(배열이름)' 메소드사용
    - int [] iArr = {100, 95, 80, 70, 60};<br> System.out.println("Arrays.toString(iArr)); <br>뱌열 iArr의 모든 요소를 출력 [100, 95, 80, 70, 60]이 출력된다


- 예외적으로 char배열은 println메서드로 출력할 시 구분자 없이 그대로 출력
    - char[] chArr{'a', 'b', 'c', 'd'}; <br> System.out.println(chArr); //abcd가 출력된다

<br><br>

## 배열의 복사
- 배열을 복사하는 방법은 두 가지가 있다
  1. for문을 사용
  2. System.arraycopy();를 이용한 배열의 복사

- 배열의 복사는 for문보다 System.arraycopy()를 사용하는게 효율적이다
   - System.arraycopy(num, 0, newNum, 0, num.length);
   - new[0]에서 newNum[0]으로 num.length개의 데이터를 복사

<br><br>

## String 배열
- String[] str = new String[5] // 5개의 문자열을 담을 수 있는 배열 생성

- String 클래스만 "Kim"과 같이 큰따옴표만으로 간략히 표현하는것이 허용
    - String[] name = new String[3]; <br>name[0] = new String("Kim");
    
    - String[] name = new String[3]; <br> name[0] = "kim";

- 배열의 실제 객체가 아닌 객체의 주소가 저장
- 기본형 배열이 아닌 참조형 배열일 경우 배열에 저장되는 건 객체의 주소

<br><br>

## char배열과 String클래스

- String클래스는 char배열에 기능(메서드)를 추가한 것
- String객체는 읽을수만 있고 내용은 변경할 수 없다

<br>

__String 클래스의 주요 메서드__
메서드 | 설명
--- | ---
char charAt(int index) | 문자열에서 해당 위치에 있는 문자 반환
int length() | 문자열의 길이를 반환
String substring(intform, int to) | 문자열에서 해당 범위(from ~ to)에 있는 문자열을 반환한다 (to는 범위에 포함x)
boolean equlas(Object obj) | 문자열의 내용이 obj와 같은지 확인, 같으면 결과는 true, 다르면 false
char[]toCharArray() | 문자열을 문자배열 (char[])로 변환해서 반환한다

<br>

#### CharAt()
- String str = "ABCDE"; <br> char ch = str.charAt(3); // 문자열 str의 D를 저장
<br>

#### substring()
- String str = "012345"; <br> String tmp = str.substring(1,4); <br> System.out.println(tmp); // 123 출력
<br>

#### equals()
- String str = "abc"; <br>if(str.equals("abc")){...<br>} <br>

### toCharArray()
- char배열과 String클래스의 변환
- char[] chArr = {'A', 'B', 'C', 'D'}; <br>String str = new String(chArr); //char배열 -> String <br> char[] tmp = str.toCharArray(); //String -> char배열

<br><br>

## 다차원배열

- 2차원 배열을 선언하는 방법은 1차원 배열과 같다, 다만 괄호[]가 하나 더 들어갈 뿐이다

<br><br>
선언 방법 | 선언 예
--- | ---
타입[][] 변수이름 | int[][] score;
타입 변수이름[][] | int score [][];
타입[] 변수이름[] | int[] score[];
---

<br><br>

- score[0][0] = 100;<br>System.out.println(score[0][0]);
  
- int[][] arr = new int[][] { {1,2,3} {4,5,6}};<br>int[][] arr = { {1,2,3} , {4,5,6} }; //new int 생략

- int {  <br>{100, 100, 100}, <br> {70, 70, 70},<br>{80, 80, 80},<br>{20, 20, 20}<br>} <br>score.length => 4<br>score[0].length => 3

- for문을 이용하여 2차원 배열 초기화<br>for(int i = 0; i < score.length; i++)<br>_for(int j = 0; j < score[0].length; j++)<br>__score[i][j] = 0;

- 향상된 for문<br>for(int[] tmp : score){<br>for(int i : tmp){<br>sum +=i;<br>}<br>}

<br><br>

## 가변 배열
- 2차원 이상의 다차원 배열을 생성할 때 전체 배열 차수 중 마지막 차수의 길이를 지정하지 않음

- ex) int [][] score = new int [2][]; //두번째 차원길이 지정x<br>score[0] = new int[4];<br>score[1] = new int[2];

- 선언과 동시에 초기화도 길이별 지정 가능