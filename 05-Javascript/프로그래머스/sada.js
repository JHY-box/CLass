function solution(price) {
    
    let price = 120000;

    if (price > 100000) {
        return price * 0.05
    } else if (price > 300000) {
        return price * 0.1
    } else if (price > 500000) {
        return price * 0.2
    }
    return answer;
}