package com.fantasy.ocr.enums;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
public enum ImageTypeEnum {
    FILEPATH(1, "图片路径"),
    BASE64STR(2, "base64字符串");

    private Integer code;
    private String desc;

    ImageTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
