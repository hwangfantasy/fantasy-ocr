package com.fantasy.ocr.dto;

import java.io.Serializable;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
public class OcrResponseDTO implements Serializable{
    private static final long serialVersionUID = 7969183938904738448L;
    /**
     * 0000 成功，9999失败
     */
    private Integer code;

    /**
     * 成功，失败
     */
    private String msg;

    /**
     * 成功时返回有值
     */
    private String result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OcrResponseDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
