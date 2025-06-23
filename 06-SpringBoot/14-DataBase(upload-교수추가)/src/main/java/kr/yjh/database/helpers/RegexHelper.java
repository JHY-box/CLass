package kr.yjh.database.helpers;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import kr.yjh.database.exceptions.StringFormatException;

@Component
public class RegexHelper {

    /**
     * 주어진 문자열이 공백이나 null 인지를 검사
     */
    public void isValue(String str, String message) throws StringFormatException {
        if (str == null || str.trim().equals("")) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 숫자 only에 대한 형식 검사
     */
    public void isNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 영문 only 형식 검사
     */
    public void isEng(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[a-zA-Z]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 한글 only 형식 검사
     */
    public void isKor(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 영문+숫자 형식 검사
     */
    public void isEngNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[a-zA-Z0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 한글+숫자 형식 검사
     */
    public void isKorNum(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 이메일 형식 검사
     */
    public void isEmail(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", str)) {
            throw new StringFormatException(message);
        }
    }


    /**
     * URL 형식 검사 n                                                       //////////////////////////////////////////////////////06.16
     */
    public void isUrl(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^(https?)://[a-zA-Z0-9\\-._~%]+(\\.[a-zA-Z0-9\\-._~%]+)+.*$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 핸드폰 번호 형식 검사 (하이픈 포함)
     */
    public void isCellPhone(String str, String message) throws StringFormatException {
        if (!Pattern.matches("^01(?:0|1|[6-9])-(\\d{3}|\\d{4})-\\d{4}$", str)) {
            throw new StringFormatException(message);
        }
    }

    /**
     * 핸드폰 번호 형식 검사 (하이픈 유무 모두)
     */
    public void isPhone(String str, String message) throws StringFormatException {
        boolean cellPhone = Pattern.matches("^01(?:0|1|[6-9])-(\\d{3}|\\d{4})-\\d{4}$", str);
        boolean telPhone = Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", str);

        if (!cellPhone && !telPhone) {
            throw new StringFormatException(message);
        }
    }
}
