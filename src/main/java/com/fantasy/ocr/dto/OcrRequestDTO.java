package com.fantasy.ocr.dto;

import com.fantasy.ocr.enums.ImageTypeEnum;

import java.io.Serializable;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
public class OcrRequestDTO implements Serializable{
    private static final long serialVersionUID = -3552856904774514171L;
    /**
     * 类型，1 路径，2 字符串
     * {@link ImageTypeEnum}
     */
    private Integer type;

    /**
     * type=1 时传图片路径，其他不传
     */
    private String filePath;

    /**
     * type=2 时传base64字符串，其他不传
     */
    private String fileStr;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileStr() {
        return fileStr;
    }

    public void setFileStr(String fileStr) {
        this.fileStr = fileStr;
    }

    @Override
    public String toString() {
        return "OcrRequestDTO{" +
                "type=" + type +
                ", filePath='" + filePath + '\'' +
                ", fileStr='" + fileStr + '\'' +
                '}';
    }
}
