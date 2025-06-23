// 공통 자바 스크립트 파일
// --> /resources/static/assets/js/script.js

/**
 * 학과 삭제 함수
 */
function deleteDepartment(e) {
    e.preventDefault(); // 기본 동작 방지

    if (!confirm(`${e.currentTarget.dataset.dname} 학과를 정말 삭제하시겠습니까?`)) {
        return; // 사용자가 취소를 선택하면 함수 종료
    }

    // 클릭된 링크의 href 속성과 date-id 속성을 가져옴
    const url = e.currentTarget.getAttribute('href');
    const id = e.currentTarget.dataset.id;

    // form을 동적으로 생성하여 POST 요철으로 DELETE 요청을 보냄
    const form = document.createElement('form');
    form.style.display = 'none'; // 폼을 화면에 보이지 않게 설정
    form.method = 'POST'; // POST 방식으로 설정
    form.action = url; // 요청을 보낼 URL 설정

    // Delete 요청을 위해 _method 필드를 추가
    // (이 부분은 서버에서 DELETE 메서드를 지원하는 경우에 필요)
    // --> application.properties에 spring.mvc.hiddenmethod.filter.enabled=true 설정 필요
    // --> Spring Boot에서 @GettingMapping으로 연결할 수 있게 된다.
    const input = document.createElement('input');
    input.type = 'hidden';
    input.name = '_method'; // 필드 이름 설정
    input.value = 'DELETE'; // DELETE 메서드로 설정
    form.appendChild(input); // 폼에 input 필드 추가

    // 학과 ID를 hidden 필드로 추가
    const idInput = document.createElement('input');
    idInput.type = 'hidden';
    idInput.name = 'id'; // 필드 이름 설정
    idInput.value = id; // 학과 ID 설정
    form.appendChild(idInput); // 폼에 ID 필드 추가

    // <form> 태그를 body에 추가하고 전송
    document.body.appendChild(form);
    form.submit(); // 폼 제출
}