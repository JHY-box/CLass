/*

let a = [10,20];
let b = a;

console.log(a);
console.log(b);

a[0]++;
a[1]++;

console.log(a);
console.log(b);

*/

/////↓↓ B에 영향이 안게도록하기 ↓↓/////

let a = [10,20];
let b = new Array(a.length);

console.log(a);
console.log(b);

b[0] = a[0];
b[1] = a[1];

a[0]++;
a[1]++;

console.log(a);
console.log(b);

//갑복사 깊복사