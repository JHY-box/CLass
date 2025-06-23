// 반복문을 사용한 JSON 객체 탐색

const student = {
    studno: 10101,
    grade: 1,
    name: "학생1",
    phoneno: "010-1231-2342"
};

for (const key in student) {
    console.log(`${key}: ${student[key]}`);
}