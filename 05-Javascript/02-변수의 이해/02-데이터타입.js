/** 데이터 타입 */
let str = "text";
let num = 100;
let bool = false;
let undef;
let nul = null;
let arr = [1, 2, 3];
let obj = { key : "value" };

console.group("데이터 타입");
console.log(`string: ${str}`);
console.log(`number: ${num}`);
console.log(`boolean: ${bool}`);
console.log(`undefined: ${undef}`);
console.log(`null: ${nul}`);
console.log(`array: ${arr}`);
console.log(`object: ${obj}`);
console.log();
console.groupEnd();

/** 2)typeof 연산자 */
console.group("typeof 연산자");
console.log("typeof str:",typeof str);
console.log("typeof num:",typeof num);
console.log("typeof bool:",typeof bool);
console.log("typeof undef:",typeof undef);
console.log("typeof nul:",typeof nul);
console.log("typeof arr:",typeof arr);
console.log("typeof obj:",typeof obj);
console.groupEnd();