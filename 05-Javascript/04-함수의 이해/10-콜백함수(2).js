
// 기준이 되는, 통로, 출력하는
function processNumber(x, y, callback) {
    console.log(callback(x, y));
}

// +
processNumber (5, 3, function(x, y) {
    return x + y;
});


// -
processNumber (5, 3, function(x, y) {
    return x - y;
});


// *
processNumber (5, 3, function(x, y) {
    return x * y;
});