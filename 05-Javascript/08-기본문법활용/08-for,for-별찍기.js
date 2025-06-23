//첫째 줄에는 별 1개, 둘째 줄에는 별2개 N번째 줄에는 별 N개를 찍는 문제

for (let i=0; i<7; i++) {
    let str ="";

    for (let j=0; j<i+1; j++) {
        str +="*";
    }
    console.log(str);
}