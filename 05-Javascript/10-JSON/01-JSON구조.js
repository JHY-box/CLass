// JSON 객체의 생성과 속성값 출력하기

/** 변수들의 그룹으로서의 JSON 정의 */
const student = {
    studno: 10101,
    grade: 1,
    name: "학생1",
    phoneno: "010-1231-2342"
};

/** 1) 각 테이터 출력하기 */
// 데이터에 접근하는 기본적인 방법은 객체이름.하위정보이름
// --> 90% 이상의 경우에서 이 방식이 사용됨.
console.group("출력 type1");
console.log("학번: " + student.studno);
console.log("학년: " + student.grade);
console.log("이름: " + student.name);
console.log("연락처: " + student.phoneno);
console.groupEnd();
    

//// JSON 객체의 생성과 속성값 출력하기

// json의 key이름을 문자열로 사용
console.group("출력 type2");
console.log("학번: " + student["studno"]);
console.log("학년: " + student["grade"]);
console.log("이름: " + student["name"]);

//접근하고자 하는 하위 변수의 이름을 동적으로 설정하는 경우
const keyName1 = "name";
console.log("이름: " + student[keyName1]);

const keyName2 = "phoneno"
console.log("연락처: " + student[keyName2]);
console.groupEnd();
