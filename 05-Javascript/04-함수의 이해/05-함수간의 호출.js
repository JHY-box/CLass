function f1(x1) {
    console.log(`f1(${x1}) = 2 x ${x1} + 1`);
    return 2 * x1 + 1;
}

function f2(x2) {
    console.log(`f2(${x2}) = f1(${x2}) * 2`);
    let y = f1(x2) * 2;
    return y;
}

let a = 10;
let b = f2(a);
console.log(`f2(${a}) = ${b}`);