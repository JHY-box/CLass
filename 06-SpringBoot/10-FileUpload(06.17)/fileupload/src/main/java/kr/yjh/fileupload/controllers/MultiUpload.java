package kr.yjh.fileupload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.yjh.fileupload.helpers.FileHelper;
import kr.yjh.fileupload.helpers.WebHelper;
import kr.yjh.fileupload.models.UploadItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MultiUpload {

    @Autowired
    private WebHelper webHelper;

    @Autowired
    private FileHelper fileHelper;

    @GetMapping("/multi/upload")
    public String uploadSingle() {
        return "multi/upload";
    }

    @PostMapping("/multi/upload_ok")
    public String postMethodName(Model model,
        @RequestParam(value="photo", required=false) MultipartFile[] photo) {

        List<UploadItem> uploadItemList = null;

        try {
            uploadItemList = fileHelper.saveMultipartFile(photo);
        } catch (Exception e) {
            webHelper.serverError(e);
            return null;
        }

        // 업로드 정보를 View로 전달한다.
        model.addAttribute("uploadItemList", uploadItemList);

        // 뷰 호출
        return "multi/upload_ok";
    }
}