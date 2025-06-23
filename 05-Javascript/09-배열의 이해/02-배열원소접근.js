/** [1] 인덱스 번호를 활용한 개별 원소 접근 */
let myArr1 = [1, 3.14, true, "hello"];
console.log("[0=%d, [1]=%d, [2]=%s, [3]=%s",
    myArr1[0], myArr1[1], myArr1[2], myArr1[3]);

/** [2] 존재하지 않는 원소에 대한 접근 */
let myArr2 = [100];
console.log(myArr2);

let item1 = myArr2[0]
console.log(item1);

let item2 = myArr2[1]
console.log(item2);

if (item2 !== undefined) {
    console.log("1번째 원소 존재함");
} else {
    console.log("1번째 원소 존재하지 않음");
}