/** JSON을 배열에 넣기 */
const student1 = { studno: 10101, grade: 1, name: "학생1" };
const student2 = { studno: 20202, grade: 2, name: "학생2" };

const classroom1 = [student1, student2];
console.log(classroom1);


/** 한번에 정의하기 */
const classroom2 = [
    { studno: 30303, grade: 3, name: "학생3" },
    { studno: 40404, grade: 4, name: "학생4" }
];
console.log(classroom2);
    


