package com.baidu.service;

import java.io.InputStream;

import com.baidu.dto.FileDTO;

public interface IFileService {

    public String getHost();

    public FileDTO saveFile(InputStream inputStream, String suffix);

}
