/**
 * 숫자로 변환하기 (Value)
 * 변환할 수 없으면 NaN(Not A Number)을 리턴
 */

//정수 변환
console.log(parseInt('015'));    // 따옴표를 제거하고 015는 15와 동일 
console.log(parseInt(3.14));     // 소수점 이하는 버림
console.log(parseInt('15,123')); // 소수점 이하는 버림
console.log(parseInt('15*3'));   // 콤마(,)는 단순 문자열이므로 콤마 이후는 버려진다.
console.log(parseInt('15e2'));   // 문자열 'e' 이후는 버려진다.
console.log(parseInt('15px'));   // 문자열 'px'는 버려진다.

//실수 변환
console.log(parseFloat(3.14));   // 3.14
console.log(parseFloat('3.14')); // 3.14

// 정수, 실수 자동 판별
console.log(Number('015'));   // 15
console.log(Number('3.14'));  // 3.14

// NaN을 반환하는 경우
console.log(parseFloat(true));  // NaN
console.log(parseFloat(false)); // NaN
console.log(parseFloat('FF2')); // NaN


