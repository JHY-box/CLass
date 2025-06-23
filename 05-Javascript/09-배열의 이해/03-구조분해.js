// 배열의 원소 분리

let myArr = [100,200,300,400];
const [a,b,c,d] = myArr;
console.log("a=%d, b=%d, c=%d, d=%d", a,b,c,d);

let [x, y, ...rest] = myArr;
console.log(x);
console.log(y);
console.log(rest);