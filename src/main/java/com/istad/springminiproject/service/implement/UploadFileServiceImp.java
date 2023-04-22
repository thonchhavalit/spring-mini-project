package com.istad.springminiproject.service.implement;

import com.istad.springminiproject.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
@Service
public class UploadFileServiceImp implements UploadFileService {
    Path fileLocationStorage;
    UploadFileServiceImp(){
        fileLocationStorage= Paths.get("src/main/resources/images");
    }
    @Override
    public String fileUpload(MultipartFile file) throws IOException {
        String fillName=file.getOriginalFilename();

       if(fillName!=null){
           if(fillName.contains("..")){
               System.out.println("Name is incorrect!!");
               return null;
           }

           String[] filePart=fillName.split("\\.");
           fillName= UUID.randomUUID()+"."+filePart[1];
           Path fileResolve=fileLocationStorage.resolve(fillName);
           Files.copy(file.getInputStream(),fileResolve, StandardCopyOption.REPLACE_EXISTING);
           return fillName;
       }

        return null;
    }
}
