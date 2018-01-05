package com.blankj.subutil.util;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：Administrator on 2017/8/14 08:50
 * 描述：自己写的一个从YUV420（I420）转RGB的应用程序
 */

public class YuvToBitmap {

    private static int R = 0;
    private static int G = 1;
    private static int B = 2;

    /**
     * 自己写的一个从YUV420（I420）转Bitmap的应用程序
     */
    public static Bitmap I420ToBitmap(byte[] src, int width, int height) {

        int numOfPixel = width * height;
        int positionOfV = numOfPixel;
        int positionOfU = numOfPixel / 4 + numOfPixel;
        int[] rgb = new int[numOfPixel * 3];
        int[] rgba = new int[numOfPixel];

        for (int i = 0; i < height; i++) {
            int startY = i * width;
            int step = (i / 2) * (width / 2);
            int startV = positionOfV + step;
            int startU = positionOfU + step;
            for (int j = 0; j < width; j++) {
                int Y = startY + j;
                int V = startV + j / 2;
                int U = startU + j / 2;
                int index = Y * 3;
                rgb[index + B] = (int) ((src[Y] & 0xff) + 1.4075 * ((src[U] & 0xff) - 128));
                rgb[index + G] = (int) ((src[Y] & 0xff) - 0.3455 * ((src[U] & 0xff) - 128) - 0.7169 * ((src[V] & 0xff) - 128));
                rgb[index + R] = (int) ((src[Y] & 0xff) + 1.779 * ((src[V] & 0xff) - 128));
                rgba[i * width + j] = 0xff000000 + (rgb[index + B] << 16) + (rgb[index + G] << 8) + rgb[index + R];
            }
        }

        return RGBToBitmap( rgba,width,height);
    }

    /**
     * 自己写的一个从YUV420（YV12）转Bitmap的应用程序
     */
    public static Bitmap YV12ToBitmap(byte[] src, int width, int height) {

        int numOfPixel = width * height;
        int positionOfV = numOfPixel;
        int positionOfU = numOfPixel / 4 + numOfPixel;
        int[] rgb = new int[numOfPixel * 3];
        int[] rgba = new int[numOfPixel];

        for (int i = 0; i < height; i++) {
            int startY = i * width;
            int step = (i / 2) * (width / 2);
            int startV = positionOfV + step;
            int startU = positionOfU + step;
            for (int j = 0; j < width; j++) {
                int Y = startY + j;
                int V = startV + j / 2;
                int U = startU + j / 2;
                int index = Y * 3;
                rgb[index + B] = (int) ((src[Y] & 0xff) + 1.4075 * ((src[V] & 0xff) - 128));
                rgb[index + G] = (int) ((src[Y] & 0xff) - 0.3455 * ((src[U] & 0xff) - 128) - 0.7169 * ((src[V] & 0xff) - 128));
                rgb[index + R] = (int) ((src[Y] & 0xff) + 1.779 * ((src[U] & 0xff) - 128));
                rgba[i * width + j] = 0xff000000 + (rgb[index + B] << 16) + (rgb[index + G] << 8) + rgb[index + R];
            }
        }

        return RGBToBitmap( rgba,width,height);
    }

    private static Bitmap RGBToBitmap(int[] rgba,int width,int height) {

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(rgba, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
