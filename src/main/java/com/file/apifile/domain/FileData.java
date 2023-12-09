package com.file.apifile.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_data")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "upload_name")
    private String uploadName;

    private String type;

    private String filePath;

    @Column(name = "save_name")
    private String saveName;
}
