/** 1번 */
function solution(num1, num2) {
    return num1 + num2;
}

/** 2번 */
function solution(num1, num2) {
    return num1 - num2;
}

/** 3번 */
function solution(num1, num2) {
    return num1 * num2;
}

/** 4번 */
function solution(num1, num2) {
    let answer = parseInt(num1 / num2);
    return answer;
}

/** 5번 */
function solution(num1, num2) {
    
    return num1%num2;
}

/** 6번 */
function solution(age) {
    let a = 2022 - age + 1;
    return a;
}

/** 7번 */
function solution(num, n) {
    if(num%n==0)
        return 1;
    if(num%n!=0)
        return 0;
}

/** 8번 */

function solution(n, k) {
    let answer = 0;
    
    answer = (n * 12000) + (k *2000) - (parseInt(n/10) *2000)
    return answer;
  }


  /** 9번 */

  function solution(hp) {
    const 장군개미 = Math.floor( hp / 5 );
    const 병정개미 = Math.floor(( hp - ( 장군개미 * 5)) / 3 );
    const 일개미 = hp - (( 장군개미 * 5) + ( 병정개미 * 3 ));
    return 장군개미 + 병정개미 + 일개미;
}


  /** 9번 */

function solution(M, N) {
    let answer = M*N-1;
    return answer;
}

