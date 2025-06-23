/** 에러 객체를 활용한 예외처리 */
function foo(id, pw) {
    if (!id) {
        // 함수 안에서 에러를 강제로 발생시킬 경우, 이 함수를 호출하는 위치를 에러로 인식한다.
        throw new Error("아이디를 입력하세요.");
    }

    if (!pw) {
        // 함수 안에서 에러를 강제로 발생시킬 경우, 이 함수를 호출하는 위치를 에러로 인식한다.
        throw new Error("비밀번호를 입력하세요.");
    }

    return "로그인 되셨습니다."
}

// try블록 안의 코드는 최소화 하는것이 프로그램 효율에 좋다.
//그래서 k값은 정상적으로 리턴 받았다면 그 결과값을 활용하는 처리는 try블록 밖에서 하는것이 좋다.
//에러 점검이 끝난 후 try~catch 블록 밖에서 k값을 활용하려면
// 변수의 선언 위치가 try블록보다 상위에 위치해야한다. --> 변수의 스코프 규칙
let a = null;
let b = null;

try {
    a = foo("","1234");
} catch (err) {
    // 이블록으로 전달되는 err객체는 5라인에서 생성한 Error 클래스의 객체이다.
    console.log("에러이름: %s", err.name);
    console.log("에러내용: %s", err.message);
}

try {
    b = foo("hello","");
} catch (err) {
    // 이블록으로 전달되는 err객체는 5라인에서 생성한 Error 클래스의 객체이다.
    console.log("에러이름: %s", err.name);
    console.log("에러내용: %s", err.message);
}

console.log(a);
console.log(b);