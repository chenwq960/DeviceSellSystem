package com.baidu.form;

/**
 * 页面分页参数
 * 
 * @author songyz
 * @createTime 2020-01-17 17:57:44
 */
public class SearchParam {
    private int pageNum = 1;
    private int pageSize = 5;
    private String seachKey;// 搜索的关键词
    private String startTime;// 搜索的开始时间
    private String endTime;// 搜索的结束时间

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSeachKey() {
        return seachKey;
    }

    public void setSeachKey(String seachKey) {
        this.seachKey = seachKey;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
