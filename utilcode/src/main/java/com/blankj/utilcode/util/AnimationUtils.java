package com.blankj.utilcode.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import com.blankj.utilcode.R;

/**
 * <pre>
 *     author: wzgl
 *     blog  : http://blog.csdn.net/wzgl708937822
 *     time  : 2017/9/20
 *     desc  : 自定义动画
 * </pre>
 */

public class AnimationUtils {

    /**
     * 按钮类型的点击效果（透明度和缩放）
     */
    public static final void loadButtonDynamic(Context context, View view) {

        Animation animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.button);
        animation.setFillAfter(false);
        view.startAnimation(animation);
    }

}
