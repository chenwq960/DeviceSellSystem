package com.baidu.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.dto.FileDTO;

@Component("localFileService")
public class LocalFileServiceImpl implements IFileService {

    private static Logger logger = LoggerFactory.getLogger(LocalFileServiceImpl.class);
    @Value("${file.workpath}")
    private String fileWorkpath;// 文件真实路径
    @Value("${file.host}")
    private String fileHost;// 文件访问路径

    @Override
    public String getHost() {
        return fileHost;
    }

    @Override
    public String getWorkPath() {
        return fileWorkpath;
    }

    @Override
    public FileDTO saveFile(InputStream inputStream, String suffix) {
        FileDTO fileDTO = new FileDTO();
        // 生成文件名称
        String subPath = UUID.randomUUID().toString() + suffix;

        fileDTO.setAbsolutePath(fileWorkpath + subPath);
        fileDTO.setSubPath(subPath);
        fileDTO.setHttpPath(fileHost + subPath);
        logger.info(fileDTO.getHttpPath());

        try (BufferedInputStream bis = new BufferedInputStream(inputStream);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileDTO.getAbsolutePath()))) {
            new File(fileDTO.getAbsolutePath()).createNewFile();
            IOUtils.copy(bis, bos);
            return fileDTO;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
