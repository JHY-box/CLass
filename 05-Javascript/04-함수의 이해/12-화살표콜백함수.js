function processData(x, callback) {
    const result = x*2;
    callback(result);
}

processData(5, function(y){ 
    console.log("[익명함수] 결과는:", y + 3);
});

processData(5, (y) => console.log("[화살표 함수] 결과는: ", y + 5));