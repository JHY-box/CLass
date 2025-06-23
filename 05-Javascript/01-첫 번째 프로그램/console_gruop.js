/**
 * console.group() and console.groupEnd() 실습
 * console.group()은  console.log()와 함께 사용하여 로그를 그룹화하는 데 사용됩니다.
 * console.group()은 그룹을 시작하고 console.groupEnd()는 그룹을 종료합니다.
 * 그룹화된 로그는 들여쓰기가 적용되어 가독성을 높입니다.
 */

//첫 번째 그룹
console.group("My Group1");
console.log("Hello Javescript!");
console.log("안녕, 자바스크립트!");
console.groupEnd();


//두 번째 그룹
console.group("My Group2");
console.log("Hello Javescript!");
console.log("안녕, 자바스크립트!");
console.groupEnd();
