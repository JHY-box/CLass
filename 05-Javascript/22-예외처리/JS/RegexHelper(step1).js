function getValueError(msg = '잘못된 요청 입니다.', selector = undefined) {
    const error = new Error(msg);
    error.element = document.querySelector(selector);
    return error;
}


/**
 * 정규표현식을 기반으로 입력값에 대한 유요성 검사를 수행하는 클래스.
 * HTML 문서에서 사용하기 위해 input selector에 대한 입력값을 검사한다.
 */
const regexHelper = {
    /**
     * 값의 존재 여부를 검사한다.
     * @param {string} selector   검사할 대상에 대한 <INPUT> 요소의 selector
     * @param {string} msg        값이 없을 경우 표시할 메시지 내용
     * 
     * Ex) regexHelper.value('#user_id','아이디를 입력하세요.');  
     */

    value: function(selector, msg) {
        const content = document.querySelector(selector).value;

        if (content === undefined || content === null || (typeof content === 'string' && content.trim().length === 0 )) {
            throw getValueError(msg, selector);
        }

        return true; // 이건 딱히 쓸 필요 없음
    }
}