package com.fantasy.ocr.util;

import net.sourceforge.tess4j.util.ImageHelper;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by hwangfantasy on 2017/7/26.
 */
public class ImageUtil {
    public static final String IMAGE_PATH = System.getProperty("user.dir") + File.separator + "img" + File.separator + "temp.jpg";

    /**
     * 图片增强处理
     *
     * @param file
     * @return
     */
    public static BufferedImage change(File file) {
        // 读取图片字节数组
        BufferedImage textImage = null;
        try {
            InputStream in = new FileInputStream(file);
            BufferedImage image = ImageIO.read(in);
            //textImage = ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight()));  //对图片进行处理
            textImage = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5);  //将图片扩大5倍
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textImage;
    }

    /**
     * 图片转化成base64字符串
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param filePath
     * @return
     */
    public static String getImageStr(String filePath) {
        String imgFile = filePath;//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    /**
     * base64字符串转化成图片
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr
     * @return
     */
    public static boolean generateImage(String imgStr) {
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成图片
            String imgFilePath = IMAGE_PATH;//新生成的图片
            FileUtils.writeByteArrayToFile(new File(imgFilePath),b);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
