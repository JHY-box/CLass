// Switch문의 기본 구문 형식

const 국어 = "B";

// 조건에 맞는 `case` 블록부터 `break` 키워드를 만날때 까지 실행한다.
switch (국어) {
    case 'A':
        console.log("A학점 입니다.");
        break;
        
    case 'B':
        console.log("B학점 입니다.");
        break;
    
    case 'C':
        console.log("C학점 입니다.");
        break;
    default:
        console.log("C학점 미만 입니다.");
        break;
}