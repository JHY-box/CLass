//** 1) 다른 JSON 객체를 value로 포함하는 경우 */
// 단일 형태의 JSON
const centerPoint = {
    x: 5,  //x좌표
    y: 10  //y좌료
};

// 다른 JSON을 포함하는 JSON
const circle1 = {
    center: centerPoint,  //중심의 좌표
    radius: 5.10 // 반지름
};

console.group("circle1");
console.log("원의 중점: (%d, %d)", circle1.center.x, circle1.center.y);
console.log("원의 반지름: %d", circle1.radius);
console.groupEnd();

/** 2) 계층적으로 정의된 경우 */
const circle2 = {
    center: {
        x: 5, //x좌표
        y: 10 //y좌표
    },
    radius: 5.10 //반지름
};

console.group("circle2");
console.log("원의 중점: (%d, %d)", circle2.center.x, circle2.center.y);
console.log("원의 반지름: %d", circle2.radius);
console.groupEnd();