// 특정 조건을 좀 더 상세하게 판단하기 위해 사용

const point = 78;

if (point >= 70) {
    console.log("PASS 입니다.");

    if (point > 90) {
        console.log("A");
    } else if (point > 80) {
        console.log("B");
    } else {
        console.log("C");
    }
} else {
    console.log("NonPass 입니다.");
}