// 반복문의 흐름 제어 실습

for (let i=0; true; i++) {  // 조건식이 true 이므로 무한루프가 됨
    if (i % 2 == 0) {
        continue;  // <- 증감식으로 강제이동
    }

    if (i > 10) {
        break;
    }
    console.log("Hello World ::: %d", i);
}
////////////////////////////////////////////////////////
//////// continue , break 작동 원리만 볼것 /////////////
/////////////// 설명하기 위한 코드임 //////////////////
/////////////////////////////////////////////////////