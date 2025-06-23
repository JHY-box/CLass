// 공통 자바 스크립트 파일

/**
 * 학과 삭제 함수
 */
function deleteDepartment(e) {
    e.preventDefault();

    if(!confirm(`${e.currentTarget.dataset.dname} 학과를 정말 삭제하시겠습니까?`)) {
        return;
    }

    // 클릭된 링크의 href 속성과 data-id 속성을 가져옴
    const url = e.currentTarget.getAttribute('href');
    const id = e.currentTarget.dataset.id;

    // form을 동적으로 생성하여 POST 요청으로 DELETE 요청을 보냄
    const form = document.createElement("form");
    form.style.display = "none";
    form.method = "POST";
    form.action = url;

    // DELETE 요청을 위해 _method 필드를 추가
    // (이 부분은 서버에서 DELETE 메서드를 지원하는 경우에 필요)
    // --> application.properties에 spring.mvc.hiddenmethod.filter.enabled=true 설정 필요
    // --> Spring Boot에서 @GetMapping으로 연결할 수 있게 된다.
    const input = document.createElement("input");
    input.type = "hidden";
    input.name = "_method"
    input.value = "DELETE";
    form.appendChild(input);

    // 학과 ID를 hidden 필드로 추가
    const idInput = document.createElement("input");
    idInput.type = "hidden";
    idInput.name = "id"
    idInput.value = id;
    form.appendChild(idInput);

    // <form> 태그를 body에 추가하고 전송
    document.body.appendChild(form);
    form.submit();
}

/**
 * 교수 삭제 함수
 */
function deleteProfessor(e) {
    e.preventDefault();

    if(!confirm(`${e.currentTarget.dataset.name} 교수를 정말 삭제하시겠습니까?`)) {
        return;
    }

    // 클릭된 링크의 href 속성과 data-id 속성을 가져옴
    const url = e.currentTarget.getAttribute('href');

    // form을 동적으로 생성하여 POST 요청으로 DELETE 요청을 보냄
    const form = document.createElement("form");
    form.style.display = "none";
    form.method = "POST";
    form.action = url;

    // DELETE 요청을 위해 _method 필드를 추가
    // (이 부분은 서버에서 DELETE 메서드를 지원하는 경우에 필요)
    // --> application.properties에 spring.mvc.hiddenmethod.filter.enabled=true 설정 필요
    // --> Spring Boot에서 @GetMapping으로 연결할 수 있게 된다.
    const input = document.createElement("input");
    input.type = "hidden";
    input.name = "_method"
    input.value = "DELETE";
    form.appendChild(input);

    // <form> 태그를 body에 추가하고 전송
    document.body.appendChild(form);
    form.submit();
}

/**
 * 파일 삭제 여부 체크에 따른 업로드 필드 활성화 처리
 * -data-disabled 라는 속성을 갖는 모든 요소에 대해 일괄 처리한다.
 */
document.querySelectorAll("*[data-disabled]").forEach((v, i) => {
    v.addEventListener("change", e => {
        e.preventDefault();

        const current = e.currentTarget;
        document.querySelector(current.dataset.disabled).disabled = !current.checked;
    });
});