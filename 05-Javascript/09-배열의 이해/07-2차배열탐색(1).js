// 2차 배열의 생성과 각 행에 접근하는 방법
// - 2차 배열의 탐색에서는 중첩 반복문이 필요하다.
// - 우선, 부모 반복문으로 배열을 행단위로 탐색한다.

/** 2차 배열의 탐색 */
const myArr = [[1, 2, 3,], [4, 5, 6]];

for (let i=0; i<myArr.length; i++) {
    console.group(i + "번째 행 -----------");
    console.log(myArr[i]);

    for (let j=0; j<myArr[i].length; j++) {
        console.log(myArr[i][j]);
    }

    console.groupEnd();
}