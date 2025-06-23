// 두 개의 파라미터를 갖는 함수 정의
function foo(x,y) {
    //파라미터가 생략될 수 있으므로
    //견고한 코드라고 볼 수 없다.
    //let z = x + y;

    let z = 0;
    if (x != undefined) { z += x; }
    if (y != undefined) { z += y; }
    console.log(`x= ${x}, y= ${y}, z= ${z}`);
}

foo (100, 200);  // x-> 100, y-> 200
foo(500);        //x-> 100, y->undefined
foo();           // x-> undefined, y-> undefined