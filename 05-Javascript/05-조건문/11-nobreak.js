// switch 문은 break를 만날 때 까지 실행된다.
// break가 없다면 조건에 맞는 case이후의 도든 case를 실행한다.

const 영어 = "B";

switch (영어) {
    case 'A':
        console.log("A학점 입니다.");
    case 'B':
        console.log("B학점 입니다.");
    case 'C':
        console.log("C학점 입니다.");
    default:
        console.log("C학점 미만 입니다.");
}