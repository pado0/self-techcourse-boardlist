package example.techcourse0613.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


// 단일 파일 전송 api
@RestController
public class FileController {

    @PostMapping("/file")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestParam MultipartFile file) throws Exception {
        //final String WEB_PATH = "/resources/image";
        final String ABSOLUTE_PATH = "/Users/hyo/Desktop/공부자료/techcourse0613/src/main/resources/image"; //request.getServletContext().getRealPath(WEB_PATH);

        String fileName = file.getOriginalFilename();
        File destinationFile = new File(ABSOLUTE_PATH + "/" + fileName);

        destinationFile.getParentFile().mkdir();
        file.transferTo(destinationFile);

        return "ok";

    }
}



