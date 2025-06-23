package kr.hyungyu.department.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileHelper {

    public void write(String filePath, byte[] data) throws Exception{
        OutputStream os = null;
        
        try {
            os = new FileOutputStream(filePath); // 자바 프로그램에서 파일을 "열어서" 데이터를 "써주는" 파이프(관) (쓰기모드로 연다)
            // 프로그램에서 파일로 데이터를 보냄 (out - 프로그램 기준), Stream은 데이터를 한 바이트씩 차례대로 흘려보내는 통로(파이프) 개념
            os.write(data); // 파이프를 통해 쓰기 작업 수행
            //  이때 이미 존재하는 파일이면 덮어쓰고, 없으면 자동으로 생성됨.
        } catch (FileNotFoundException e) { // 파일을 못찾았을때 발생하는 에러
            log.error("파일을 찾을 수 없습니다.", e);
            throw e;
        } catch (IOException e) { // 파일 입출력시 하드가 부족하거나 해서 발생하는 에러
            log.error("파일을 쓸 수 없습니다.", e);
            throw e;
        } catch (Exception e) {  // 예상치 못한 에러가 발생할 수 있으므로  항상 catch 마지막은 Exception을 써준다.
            log.error("파일 입출력 오류가 발생했습니다.", e);
            throw e;
        } finally {
            if (os!= null) { // 스트림이 성공적으로 열렸을 경우에만 닫을 수 있다.
                try {
                    os.close();  
                } catch (IOException e) {
                    log.error("파일을 닫는 중 오류가 발생하였습니다.", e);
                }
            }
        }
    }
    public byte[] read(String filePath) throws Exception {
        byte [] buffer = null; // 읽어올 내용이 저장될 임시공간
        InputStream is = null; // 꽂을 파이프 정의 

        try {
            is = new FileInputStream(filePath); // 프로그램 기준의 명명이니까 변수로는 파이프가 이어질 대상을 지정 -> 순간 파이프의 크기도 할당
            buffer = new byte[is.available()]; // 파이프(흐름)의 크기를 불러옴.
            is.read(buffer); // 관 꽂았으니까 이제 읽고 buffer에다가 담음.
        } catch (FileNotFoundException e) {
            log.error("파일을 찾을 수 없습니다.", e);
            throw e; // 사용자 메세지 커스텀하도록하기 위해
        } catch (IOException e) {
            log.error("파일을 쓸 수 없습니다.", e);
            throw e;
        } catch (Exception e) {
            log.error("파일 입출력 중 오류가 발생하였습니다.", e);
            throw e;
        } finally {
            if (is != null){ // 통로가 잘 열렸으면 닫아야지
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("파일을 닫는 중 오류가 발생했습니다.", e);
                }
            }
        }

        return buffer;
    }

    /**
     * 
     * @param filePath - 파일경로
     * @param content - 저장할 문자열
     * @throws Exception - 파일 입출력 예외
     */
    public void writeString(String filePath, String content) throws Exception {
        try{
            this.write(filePath, content.getBytes("utf-8"));
        }catch (UnsupportedEncodingException e) {
            log.error("지원하지 않는 인코딩입니다.", e);
            throw e;
        }
    }
    /**
     * 
     * @param filePath - 파일경로
     * @return - 파일에 저장된 문자열
     * @throws Exception - 파일 입출력 예외
     */
    public String readString(String filePath) throws Exception {
        String content = null;

        try {
            byte[] data = read(filePath);
            content = new String(data, "utf-8");
        } catch (Exception e){
            log.error("지원하지 않는 인코딩입니다.", e);
            throw e;
        }

        return content;
    }



}
