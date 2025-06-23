update students set phone = '010-1234-5678' where id = '10101';

update students set status = '재학' where status = '휴학';

delete from students where grade = 1 and height < 160;  -- parent row

update departments set dname = '소프트웨어학과', loc = '공학관' where id = '102';

UPDATE department
SET name = '소프트웨어학과', loc = '공학관'
WHERE dept_id = 102;
delete from enrollments where enroll_date = DATE_FORMAT(enroll_date,'%Y-%m-%d') <= '2024-03-10'; -- null 값 허용 x , 참조무결성

SELECT
 s.name AS 학생이름,
 sub.name AS 과목명,
 d.dname AS 개설학과
FROM enrollments e
INNER JOIN students s ON e.student_id = s.id
INNER JOIN subjects sub ON e.subject_id = sub.id
INNER JOIN departments d ON sub.department_id = d.id;

