/** 변수 선언과 할당 (분리) */
console.group("변수 선언과 할당 (분리)");
let myName;
myName="Alice"
console.log("myName", myName);
console.groupEnd();

/** 2)변수 선언과 할당 (일괄 처리) */
console.group("변수 선언과 할당 (일괄 처리)");
let myAge= 25;
console.log("myAge : %d", myAge);
console.groupEnd();
