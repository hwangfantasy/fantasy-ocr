package com.fantasy.ocr.controller;

import com.fantasy.ocr.dto.OcrRequestDTO;
import com.fantasy.ocr.dto.OcrResponseDTO;
import com.fantasy.ocr.enums.ImageTypeEnum;
import com.fantasy.ocr.service.OcrService;
import com.fantasy.ocr.util.ImageUtil;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
@Controller
public class OcrController {
    @Autowired
    private OcrService ocrService;

    @RequestMapping(value = "recognize", method = {RequestMethod.POST})
    @ResponseBody
    public Object saveUser(@RequestBody OcrRequestDTO requestDTO) {
        OcrResponseDTO responseDTO = null;
        if (ImageTypeEnum.FILEPATH.getCode().equals(requestDTO.getType())) {
            responseDTO = ocrService.recognize(requestDTO.getType(),requestDTO.getFilePath());
        } else if (ImageTypeEnum.BASE64STR.getCode().equals(requestDTO.getType())) {
            responseDTO = ocrService.recognize(requestDTO.getType(),requestDTO.getFileStr());
        } else {
            responseDTO.setCode(9999);
            responseDTO.setMsg("错误类型");
        }
        return responseDTO;
    }
}
