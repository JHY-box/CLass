/** 개발자가 직접 정의하는 에러 */

// 에러 객체를 생성
// 생성자 파라미터로 에러의 내용 전달
try {
    //throe 구문은 그 자체를 에러로 인식하기 때문에 try~catch 처리가 가능하다.
    throw err;
} catch (err) {
console.log("에러이름: %s", err.name);
console.log("에러내용: %s", err.message);
}

console.log("프로그램 종료");