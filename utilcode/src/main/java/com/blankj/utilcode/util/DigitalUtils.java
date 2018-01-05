package com.blankj.utilcode.util;

/**
 * <pre>
 *     author: wzgl
 *     blog  : http://blog.csdn.net/wzgl708937822
 *     time  : 2017/9/20
 *     desc  : 数字的处理
 * </pre>
 */

public class DigitalUtils {


    /**
     * 格式化数字，保留两位小数
     */
    public static String formatNumber(double number) {

        return String.format("%.2f", number);
    }

    /**
     * 格式化数字，自定义小数位数
     */
    public static String formatNumber(double number,String format) {

        return String.format(format, number);
    }
}
