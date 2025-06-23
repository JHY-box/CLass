const students = {
    name: ["철수", "민수", "호영"],
    age: [16, 17, 19],
    height: [172.4, 168.2, 170.5]
};

for (let i=0; i<students.name.length; i++) {
    console.log(`이름: ${students.name[i]}, 나이: ${students.age[i]},
                   키: ${students.height[i]}`);
}