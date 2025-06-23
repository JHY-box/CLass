//배열의 원소를 탐색 하는 두 가지 방법

/** 1) 기본 반복문 */
const items = [7, 4, 5, 1, 6];

console.group("기본 반복문");
for (let i=0; i<items.length; i++) {
    console.log(items[i]);
}

console.groupEnd();

/** 2) For Of 반복문 */
const data = [4, 5, 2, 1, 3];

console.group("for~of문");
for (const item of data) {
    console.log(item);
}
console.groupEnd();