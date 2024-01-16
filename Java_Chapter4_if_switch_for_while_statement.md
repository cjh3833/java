# Java Chapter 4. 조건문과 반복문
헷갈리는 것, 중요한 것 위주 정리

## if문
- 자바에서는 조건식의 결과는 반드시 true 또는 false 여야한다

<br><br>

## switch문 제약조건
 - switch문의 조건식 결과는 정수 또는 문자열이어야 한다
 - case문의 값은 정수 상수만 가능하며 중복되지않아야한다

<br><br>

## for문 증감식
 - for(int i = 1; i< 10; i++) //1부터 10까지 1씩 증가
 - for(int i = 10; i>= 1; i--) //10부터 1까지 1씩 감소
 - for(int i = 1; i<= 10; i+=2) //1부터 10까지 2씩 증가
 - for(int i = 1; i<= 10; i*=3) //1부터 10까지 3배 증가

<br><br>

## 향상된 for문

for(int i = 0; i< arr.length; i++){ <br>
System.out.println("arr[i]");<br>
}

for(int tmp : arr) { <br>
System.out.println(tmp); <br>
}

<br><br>

## while문
- while((sum += ++i) <= 100)

<br><br>

## do-while문
- do{<br>//조건식의 연산결과가 참일때 수행될 문장들을 적는다<br>} while(조건식); <- 끝에 ; 잊지않도록 주의

- while문과 반대로 블럭을 먼저 수행한 후에 조건식을 평가, do-while문은 최소한 한번은 수행할 것을 보장