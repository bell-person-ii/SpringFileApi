package com.file.apifile.repository;

import com.file.apifile.domain.FileData;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class FileDataRepository {

    private final EntityManager em;

    public void save(FileData fileData){
        em.persist(fileData);
    }

    public FileData findOneByUploadName(String name){

        List<FileData> fileDataList
                = em.createQuery("select fd from FileData  fd where fd.uploadName =: name")
                .setParameter("name",name)
                .getResultList();

        int size = fileDataList.size();

        if(size > 1 || size ==0){
            throw new RuntimeException("잘못된 이름입니다.");
        }

        return fileDataList.get(0);
    }

}
