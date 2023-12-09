package com.file.apifile.fileSave;

import java.io.IOException;
import java.util.UUID;

public class CreateUUID {

    public  static String createUUID(String originalFileName) {

        // 확장자 추출
        int pos = originalFileName.lastIndexOf(".");
        String ext =  originalFileName.substring(pos + 1);

        // uuid+확장자 반환
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }
}
