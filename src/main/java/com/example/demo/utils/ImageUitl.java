package com.example.demo.utils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageUitl {

    public static void main(String[] args) throws IOException {
//        Thumbnails.of(new File("/Users/xiayuanyuan/Downloads/pic").listFiles())
//                .size(80, 60)
//                .outputFormat("jpg")
//                .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

     /*   // 指定大小缩放
        Thumbnails.of(new File("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg").getAbsoluteFile())
                .size(120,120)
                .outputFormat("jpg")
                .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

        // 指定大小缩放
        Thumbnails.of(new File("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg").getAbsoluteFile())
                .scale(1.1)
                .outputFormat("jpg")
                .toFile("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/rotat_scale_1.1.jpg");

        // 旋转90
        Thumbnails.of(new File("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg").getAbsoluteFile())
                .scale(1.1)
                .outputFormat("jpg")
                .rotate(90)
                .toFile("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/rotat_90.jpg");

        // 加水印
        Thumbnails.of("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg")
                .size(1280,1024)
                .watermark(Positions.BOTTOM_RIGHT,
                        ImageIO.read(new File("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark.jpg")),
                        0.5f)
                .outputQuality(0.8f)
                .toFile("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark_bottom_right.jpg");

        Thumbnails.of("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg")
                .size(1280,1024)
                .watermark(Positions.CENTER,
                        ImageIO.read(new File("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark.jpg")),
                        0.5f)
                .outputQuality(0.8f)
                .toFile("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark_centre_right.jpg");

        // 转换图像格式
        Thumbnails.of(new File("/Users/xiayuanyuan/Downloads/pic/greatwalls03.jpg").getAbsoluteFile())
                .size(1200,1080)
                .outputFormat("png")
                .toFile("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/change_format.png");*/


        // 输出到流(一个文件到另一个文件
        OutputStream outputStream = new FileOutputStream("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/output/out.jpg");
        Thumbnails.of(new File("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark_bottom_right.jpg"))
                .size(1024,1024)
                .toOutputStream(outputStream);


        // 输出到bufferImage
        BufferedImage bufferedImages = Thumbnails.of(new File("/Users/xiayuanyuan/devpath/demo/src/main/resources/static/watermark_centre_right.jpg"))
                .size(1024,1024)
                .asBufferedImage();
        ImageIO.write(bufferedImages,"jgp",
        new File("static/output/buff_out.jpg"));

    }
}
