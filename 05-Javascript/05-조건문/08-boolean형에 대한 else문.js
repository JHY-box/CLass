//boolean값이 조건으로 사용되는 경우

let isKorean = true;
//let isKorean = false;

//논리값을 조건으로 사용할 경우
// --> "만약 이 변수가 참이라면?"의 의미
if (isKorean) {
    console.log("한국사람 입니다...(1)");
} else {
    console.log("한국사람이 아닙니다...(2)");
}

//논리값의 부정형을 조건으로 사용할 경우
// --> "만약 이변수가 거짓이라면?"의 의미
if(!isKorean) {
    console.log("한국사람이 아닙니다...(3)");
} else {
    console.log("한국사람 입니다...(4)");
}