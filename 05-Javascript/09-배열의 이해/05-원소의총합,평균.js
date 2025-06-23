// 총합 -> 반복문 시작 전 총 랍을 저장할 변수를 0으로 초기화 한다.
// 평균 -> 총합을 배열의 길이로 나눈다.

const data = [10, 20, 30, 40, 50];

let sum= 0;

for (let i = 0; i<data.length; i++) {
    sum += data[i];
}

console.log(`data의 종합: ${sum}`);
console.log(`data의 종합: ${sum / data.length}`);