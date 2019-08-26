package com.house.renting;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by zeting
 * Date 2019-08-26.
 */
public class DrawableBehavior extends CoordinatorLayout.Behavior<ImageView> {
    private int start = 0;
    private int startX = 0;
    private int startY = 0;
    private int endX = CommonUtils.dp2px(10);
    private int endY = CommonUtils.dp2px(10);
    private int endSize = CommonUtils.dp2px(30);
    private int startSize = 0;

    public DrawableBehavior() {
    }

    public DrawableBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        if (start == 0) {
            start = (int) dependency.getY();
            startX = (int) child.getX();
            startY = (int) child.getY();
            startSize = CommonUtils.dp2px(80);
        }
        float ratio = dependency.getY() / start;

        // 设置图片的位置
        child.setX(startX + (1 - ratio) * (endX - startX));
        child.setY(startY + (1 - ratio) * (endY - startY));

        // 设置图片的宽高
        child.getLayoutParams().width = (int) (startSize + (1 - ratio) * (endSize - startSize));
        child.getLayoutParams().height = (int) (startSize + (1 - ratio) * (endSize - startSize));
        child.requestLayout();
        return true;
    }
}