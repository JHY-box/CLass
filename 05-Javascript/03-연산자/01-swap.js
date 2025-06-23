/** 변수 초기화 */
let a = 1;
let b = 2;
console.log(`a: ${a}, b: ${b}`); // a: 1, b: 2

/** 두 변수의 값 교환하기 */
let c = a; //a의 값을 c의 저장
a = b;     //a에 b의 값을 저장
b = c;     //c에 저장된 값을 b에 저장
console.log(`a: ${a}, b: ${b}`);  // a: 2, b: 1