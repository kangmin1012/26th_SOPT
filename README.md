## **26th_SOPT**

> **1주차**

필수 1, 필수 2 구현 방법.

 - MainActivity : 로그인 화면 (필수 2 과제)
 - SignUpAcitivy : 회원가입 화면 (필수 2 과제)
 - ImageActivity : ConstraintLayout을 이용한 화면 (필수 1 과제)

> **흐름**

 - checking 변수를 이용한 회원가입 유무 설정
 - ActivityforResult()를 이용한 SignUpActivity로 이동
 - 요구 조건들을 만족한 후 finish()를 이용해 MainActivity로 이동
 - Intent로 받아온 값들을 MainActivity에 있는 이메일, 비밀번호 
버튼에 각자 세팅
 - checking 변수를 true로 바꿔줌으로서 로그인 버튼을 눌렀을 시 성공이 뜸
 - 성공과 동시에 ImageActivity로 이동
