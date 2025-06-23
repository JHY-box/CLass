function bar(x=1, y=2) {
    let z = x+y;
    console.log(`x=${x}, y=${y}, z=${z}`);
}

bar(100, 200);   //x-> 100, y-> 200
bar(500);        //x-> 500, y-> 2
bar();           //x-> 1, y-> 2