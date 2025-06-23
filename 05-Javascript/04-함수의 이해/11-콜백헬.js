function step1(data, callback) {
    const result = data + 1;
    console.log("1단계 결과:", result);
    callback(result);
}

function step2(data, callback) {
    const result = data * 2;
    console.log("2단계 결과:", result);
    callback( result);
}

function step3(data, callback) {
    const result = data - 3;
    console.log("3단계 결과:", result);
    callback( result);
}

step1(5, function (result1){
    step2(result1, function(result2){
        step3(result2, function (result4) {
            console.log("최종 결과", result4);
        });
    });
});