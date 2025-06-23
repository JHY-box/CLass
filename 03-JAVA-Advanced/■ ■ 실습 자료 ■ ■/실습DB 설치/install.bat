@echo off
cls

SET DBNAME=myschool
SET USERNAME=root
SET TARGET_FILE=%DBNAME%-dump.sql

echo [1/2] %DBNAME% �����ͺ��̽��� ��ġ�մϴ� : %TARGET_FILE%
echo --------------------------------

IF exist sql\%TARGET_FILE% (
    echo %DBNAME% ��ġ�� ���� %USERNAME% ������ ��й�ȣ�� �Է��ϼ���.
	mariadb -u%USERNAME% -p < sql\%TARGET_FILE%
    echo %DBNAME% �����ͺ��̽� ��ġ�� �Ϸ�Ǿ����ϴ�.
) ELSE (
	echo ��������� ã�� �� �����ϴ�.
)

echo.

SET DBNAME=programmers
SET USERNAME=root
SET TARGET_FILE=%DBNAME%-dump.sql

echo [2/2] %DBNAME% �����ͺ��̽��� ��ġ �մϴ� : %TARGET_FILE%
echo --------------------------------

IF exist sql\%TARGET_FILE% (
    echo %DBNAME% ��ġ�� ���� %USERNAME% ������ ��й�ȣ�� �Է��ϼ���.
	mariadb -u%USERNAME% -p < sql\%TARGET_FILE%
    echo %DBNAME% �����ͺ��̽� ��ġ�� �Ϸ�Ǿ����ϴ�.
) ELSE (
	echo ��������� ã�� �� �����ϴ�.
)

echo.
pause