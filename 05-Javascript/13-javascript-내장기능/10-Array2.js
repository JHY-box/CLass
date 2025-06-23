/**
 *  배열을 탐색하는 방법
 */

// 테스트로 읽을 배열
const arr1 = [10, 20, 30, 40, 50];

// 고전적 방법 - 반복문을 활용하여 배열의 요소 탐색하기
for (let i = 0; i < arr1.length; i++) {
    if (i == 3) {
        console.log(' ~~~~ 반복문 끝!!!');
        break;
    }
    console.log('선택된 값 ==> %d', i, arr1[i]);
}
console.log('=================');

/**
 * forEach 메서드를 활용하여 배열의 모든 원소 탐색.
 * - 콜백함수에게 배열의 값과 인덱스를 전달한다.
 * - 콜백함수는 원소의 수 만큼 순차적으로 실행한다.
 */

const arr2 = [10, 20, 30, 40, 50];

arr2.forEach((v, i) => {
    if (i == 3) {
        console.log(' ~~~~ 반복문끝!!!');
        // break는 for,while문에서만 사용 가능하기 때문에 함수 안에서는 사용할 수 없다
        // break;
        // forEach의 콜백함수에서 반복을 중단하고자 return을 사용할 경우 현재 동작중인 콜백만 종료될 뿐 전체 반복에는 영향이 없다.
        return;
    }
    console.log('%d번째 원소 ==> %d', i, v);
});
console.log('----------------');

/**
 * 탐색을 중단하는 기능을 제공하는 some함수
 * => some 함수는 콜백함수가 true를 리턴하는 순간 순환은 중단된다.
 */

const arr3 = [10, 20, 30, 40, 50];

arr3.some((v, i) => {
    if (i == 3) {
        console.log(' ~~~ 반복문끝!!!');
        return true;
    }
    console.log('선택된 값 ==> %d', i, v);
});
console.log('----------------');

/**------------------------------------------------------------------------------------------------------
 * 4. 배열의 원소를 가공하여 새로운 배열 만들기
 */
/**
 * map함수에 전달된 콜백이 리턴하는 값들을 하나의 배열로 묶어서 hello에 저장
 * hello는 반드시 원본 배열과 같은 길이를 갖는 배열이다.
 * 리턴하지 않은 index에 대한 원소는 undefined 가 된다.
 */
const arr4 = [10, 20, 30, 40, 50];
const hello = arr4.map((v, i) => {
    return v * 10;
});
console.log(hello);

/**
 * 5. 배열 각 요소는 2배값으로 처리한 경우 '{}'와 ';', "return" 키워드 생략 가능하고 이처럼 코딩도 표준 가능한
 */
const arr5 = [10, 20, 30, 40, 50];
const world = arr5.map((v, i) => v * 10);
console.log(world);

/**
 * 6. 배열 검색
 */

const arr6 = [5, 12, 8, 131, 44];

// 조건 만족하는 원소는 첫번째 값만 반환된다. 존재하면 undefined 반환된다.
// 찾자 찾을때는 처음부터 끝까지 탐색한다.
const found1 = arr6.find((v) => {
    // 조건 만족하면 true를 반환, 만족 못하면 undefined.
    if (v > 10) {
        return true;
    }
});
console.log('found1:', found1);

// vs 우리가 원하는 조건을 충족하지 않게 조건이 true/false 리턴
// true를 리턴하는 순간 조건 만족로 종료된다. (break와 동일한 기능)
const found2 = arr6.find((v) => {
    if (v > 2) {
        // true 리턴되면 탐색 중단 => found1과 차이없다.
        return true;
    } else {
        // false? 리턴되면 다음 항목 가는 처리한다.
        return false;
    }
});
console.log('found2:', found2);

/**
 * 7. 배열에서 특정 조건을 충족한 원소를 추출하기
 */

// 1) 고전적인 방법
const arr8 = [5, 12, 8, 131, 44];
const d1 = [];

for (let i = 0; i < arr8.length; i++) {
    if (arr8[i] % 2 == 0) {
        d1.push(arr8[i]);
    }
}
console.log(d1);

// 2) foreach를 사용하는 방법
const arr9 = [5, 12, 8, 131, 44];
const d2 = [];

arr9.forEach((v, i) => {
    if (v % 2 == 0) {
        d2.push(v);
    }
});
console.log(d2);

// 3) filter()를 사용하는 방법
const arr10 = [5, 12, 8, 131, 44];
const d3 = arr10.filter(function(v, i) {
    if (v % 2 == 0) {
        // true가 리턴되는 경우 => d3 배열에 요소로 저장된다.
        // true 리턴되므로 배열의 다른 원소도 마찬가지 결과값 준조건이 충족되지 않다.
        return true;
    } else {
        // false가 리턴되는 경우 => 안됨 제외된다.
        return false;
    }
});
console.log(d3);

const arr11 = [5, 12, 8, 131, 44];
const d4 = arr11.filter((v, i) => v % 2 == 0);
console.log(d4);

/**
 * 8. 정렬 수행
 */

const arr12 = [2, 1, 15];
// sort는 기본적으로 문자열 방식 기준으로 정렬한다.
arr12.sort(); // sort()함수는 결과값 반환 안하고 원래 결과 정렬되기 때문에 결과 정렬값이 적용된다.
console.log(arr12);

// 숫자형 정렬 위해서는 함수조건을 파라미터로 전달한다.
arr12.sort(function(a, b) {
    // 함수형 정렬 => 오름차순 비교한다.
    console.log('비교중... =>', a, b);
    if (a > b) {
        return 1;
    } else {
        return -1;
    }
});
console.log(arr12);

// 배열 뒤집기
const arr13 = [1, 2, 3, 4, 5];
arr13.reverse();
console.log(arr13);

/**
 * 9. 배열 값 누적 수행
 * 값을 넘길 때 마다 최초의 callback함수의 실행 값을 누적하기 아니면 원값값을 만든 후
 */

const arr14 = [1, 2, 3, 4, 5];

// accumulator 누적값 처리방식
// reduce의 결과는 최종 결과 값만 있으므로 acc의 초기값 설정할 수도 있다.
// 처음에 첫번째 원소가 acc에 들어가고 두번째는 cur에 들어가고 하는 하나의 사례임.
const result13 = arr14.reduce((acc, cur, i) => {
    console.log('acc=%d, cur=%d, i=%d', acc, cur, i);
    return acc + cur;
});
console.log('result13=%d', result13);

/**
 * 10. 특정 용량 구하기
 */

const covid19 = [
    {date: '0125', active: 426},
    {date: '0126', active: 488},
    {date: '0127', active: 555},
    {date: '0128', active: 683},
    {date: '0129', active: 804},
    {date: '0130', active: 892},
    {date: '0131', active: 985},
    {date: '0201', active: 1100},
    {date: '0202', active: 1193}
];

// acc는 누적합 값이기 때문에 초기값을 설정하고 현재의 상태인 currentValue를 받아야 한다.
// return값은 항상 acc값이 된다. (초기값: 0, cur => acc + cur.active, 0);
const total = covid19.reduce((acc, cur) => acc + cur.active, 0);
console.log('합계: %d, 평균: %d', total, parseInt(total/covid19.length));
