// 의도적으로 break절을 조절하는 경우
// 여러 case가 같은 코드를 실행하도록 구성할 수 있다.

const 수학 = "A";
// const 수학 = "B";
// const 수학 = "C";

switch (수학) {
    case 'A':
    case 'B':
    case 'C':
        console.log("이 과목을 Pass 했습니다.");
        break;
    default:
        console.log("이 과목을 Pass하지 못했습니다.");
        break;
}