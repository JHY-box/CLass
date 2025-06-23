// 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, N번째 줄에는 별 1개를 찍는 문제

for (let i=0; i<7; i++) {
    let str ="";

    for (let j=0; j<7-i; j++) {
        str += "*";
    }
    console.log(str);
}