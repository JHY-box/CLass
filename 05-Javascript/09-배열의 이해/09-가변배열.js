// 각 행마다 열의 수가 다른 배열 형태로 표현한 상품 목록

const items = [
    ['티셔츠', 'M', '빨강', 15000],
    ['청바지', 32, '진청', 45000, '리바이스'],
    ['운동화', 270, '검정', 60000, '나이키',  '가죽']
];

for (let i=0; i<items.length; i++) {
    console.group(`${i}번째 상품`);

    for (let j=0; j<items[i].length; j++) {
        console.log(items[i][j]);
    }

    console.groupEnd();
}