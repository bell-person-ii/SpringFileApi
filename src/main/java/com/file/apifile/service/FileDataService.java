package com.file.apifile.service;

import com.file.apifile.domain.FileData;
import com.file.apifile.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FileDataService {

    private final String FOLDER_PATH = "C:/fileload/";

    private final FileDataRepository fileDataRepository;

    public FileData findOneByName(String name){
        return fileDataRepository.findOneByName(name);
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException{
        log.info("upload file: {}",file.getOriginalFilename());
        String filePath = FOLDER_PATH + file.getOriginalFilename(); //uuid가 적용안되어 있음 추후 개선 예정
        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build();

        fileDataRepository.save(fileData);

        file.transferTo(new File(filePath)); // 파일 디렉토리에 저장

        if(fileData != null){
            return "file upload success filePath: " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException{ // 디렉토리에서 파일 읽어오는 함수
        FileData fileData = fileDataRepository.findOneByName(fileName);

        String filePath = fileData.getFilePath();

        log.info("download fileData: {}",fileData);
        log.info("download filePath {}",filePath);

        return Files.readAllBytes(new File(filePath).toPath());
    }



}
