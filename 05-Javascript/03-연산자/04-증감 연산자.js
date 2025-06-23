let x = 1;

let a = 100 + ++x;  //앞북 : a=102, x=2
console.log("a=%d, x=%d", a, x);

let b = 100 + x++;  //뒷북 : a=102, x=3
console.log("b=%d, x=%d", b, x);

let c = 100 - --x;  //앞북 : a=98, x=2
console.log("c=%d, x=%d", c, x);

let d = 100 - x--;  //뒷북 : a=98, x=1
console.log("d=%d, x=%d", d, x);