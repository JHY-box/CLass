//논리식을 조건식으로 사용하는 경우

let point = 81;
//let point = 60;

//AND(&&): 전체가 참이여야 결과가 참
if (point > 70 && point <= 80) {
    console.log("C학점 입니다.");
}

//OR(||): 하나라도 참이면 전체가 참
if(point <= 70 || point > 80) {
    console.log("C학점이 아닙니다.");
}