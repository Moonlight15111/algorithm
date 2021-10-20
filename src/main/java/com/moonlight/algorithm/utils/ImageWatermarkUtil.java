package com.moonlight.algorithm.utils;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 功能描述:
 *    给图片加上文字水印
 * @author Moonlight
 * @date 2021-10-20 11:16
 */
public final class ImageWatermarkUtil {

    private ImageWatermarkUtil() {}

    /**
     * 图片的透明度
     **/
    private static final float ALPHA = 0.5f;
    /**
     * 水印文字字体
     **/
    private static final Font FONT = new Font("宋体", Font.BOLD, 30);
    /**
     * 水印文字颜色
     **/
    private static final Color COLOR = Color.RED;

    /**
     * 加文字水印
     *
     * @param srcPath 原文件路径
     * @param content 文字内容
     *
     */
    public static void addText(String srcPath, String content, OutputStream outputStream) throws IOException {
        BufferedImage srcImage = ImageIO.read(new File(srcPath));
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(srcImage, 0, 0, width, height, null);
        g.setFont(FONT);
        g.setColor(COLOR);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(FONT);
        int textWidth = metrics.stringWidth(content);
        int textHeight = metrics.getHeight();
        //  旋转坐标轴
        g.translate(-width / 5, height / 4);
        g.rotate(-30 * Math.PI / 180);

        int x = (width - textWidth) / 2;
        int y = (height + textHeight) / 2;

        g.drawString(content, x, y);
        //  画矩形
        int padding = 10;
        g.drawRect(x - padding / 2, y - textHeight, textWidth + padding, textHeight + padding);
        g.dispose();

        ImageIO.write(bufferedImage, "png", outputStream);
    }

}
