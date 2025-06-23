// For문의 기본 문법 구조 확인 

// x가 1부터 5이하인 동안 1씩 증가
for (let x = 1; x <= 5; x++) {
    console.log("x=" + x);
    console.log("x의 최종값: " + x);
}

// for문의 초기식 변수는 for문 밖에서 식별되지 않는다.   ---- while문은 최종값까지는 밖에서 식별
// 그러므로 아래와 같이 초기식의 변수를 for문 밖에서 사용하는 경우는 에러
// console.log("x의 최종값: " + x);