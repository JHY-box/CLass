//2차 배열의 생성과 각 행에 접근하는 방법
// - for -of문을 사용할 경우 2차 배열의 각행이 변수에 복사된다.

/**2차 배열의 탐색 */
const myArr = [ [1, 2, 3], [4, 5, 6] ];

for (let row of myArr) {
    console.group(row);

    for (let col of row) {
        console.log(col);
    }

    console.groupEnd();
}