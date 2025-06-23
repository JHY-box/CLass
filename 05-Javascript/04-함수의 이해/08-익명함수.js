/** 1)함수를 변수에 대입하기 */
// sayHello라는 이름을 갖는 일반적인 함수의 사용과 호출
function sayHelloKor(msg) {
    console.log(`안녕하세요 ${msg}`);
}

sayHelloKor("자바스크립트!");

// 함수는 다른 변수에 대입 가능합.
// 함수는 정의되어 있는 내용을 변경할 필요가 없으므로 상수에 할당하는 것이 일반적이다.

const kor= sayHelloKor;

// 함수가 대입된 변수는 그 자체가 함수의 역할을 한다.
kor("Javascript");

/** 2) 익명함수 */
const sayHelloEng = function(msg) {
    console.log(`hello ${msg}`);
};