package com.fantasy.ocr.service;

import com.fantasy.ocr.dto.OcrResponseDTO;
import com.fantasy.ocr.enums.ImageTypeEnum;
import com.fantasy.ocr.util.ImageUtil;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
@Service
public class OcrService {

    public static void main(String[] args) {
        OcrService ocrService = new OcrService();
        String content1 = ImageUtil.IMAGE_PATH;
        OcrResponseDTO responseDTO1 = ocrService.recognize(1,content1);
        System.out.println(responseDTO1.toString());

        String content2 = "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";
        OcrResponseDTO responseDTO2 = ocrService.recognize(2,content2);
        System.out.println(responseDTO2.toString());
    }
    /**
     * 识别图片
     * @param type
     * @param content
     * @return
     */
    public OcrResponseDTO recognize(Integer type, String content) {
        OcrResponseDTO responseDTO = new OcrResponseDTO();
        responseDTO.setCode(0000);
        responseDTO.setMsg("操作成功");
        try {
            if (ImageTypeEnum.FILEPATH.getCode().equals(type)) {
                String result = ocr(content);
                responseDTO.setResult(result);
            } else if (ImageTypeEnum.BASE64STR.getCode().equals(type)) {
                ImageUtil.generateImage(content);
                String result = ocr(ImageUtil.IMAGE_PATH);
                responseDTO.setResult(result);
            }
        } catch (Exception e) {
            responseDTO.setCode(9999);
            responseDTO.setMsg("识别失败");
        }

        return responseDTO;
    }

    /**
     * 识别图片
     * @param filePath
     * @return
     * @throws TesseractException
     */
    private String ocr(String filePath) throws TesseractException {

        File imageFile = new File(filePath);
        Tesseract instance = new Tesseract();

        instance.setLanguage("eng");//英文库识别数字比较准确
        String a = ClassLoader.getSystemClassLoader().getResource("tessdata").getPath();
        //Set the tessdata path
        instance.setDatapath(a.substring(1, a.length()));

        //将验证码图片的内容识别为字符串
        String result = instance.doOCR(imageFile);
        System.out.println(result);
        return result.replaceAll("[^0-9a-zA-Z]J*","");
    }
}
