package com.baidu.dto;

public class FileDTO {

    private String absolutePath;// 文件绝对路径
    private String subPath;// 文件的相对路径
    private String httpPath;// 文件的网络路径

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getSubPath() {
        return subPath;
    }

    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

}
