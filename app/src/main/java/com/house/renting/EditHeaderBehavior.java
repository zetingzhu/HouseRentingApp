package com.house.renting;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditHeaderBehavior extends CoordinatorLayout.Behavior<EditText> {

    /**
     * 处于中心时候原始X轴
     */
    private int mOriginalHeaderX = 0;
    /**
     * 处于中心时候原始Y轴
     */
    private int mOriginalHeaderY = 0;


    public EditHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, EditText child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, EditText child, View dependency) {
//        Log.d("------------------" , "dependency.getWidth():"+ dependency.getWidth() + "= dependency.getHeight():" + dependency.getHeight());
//        Log.d("------------------" , "parent.getWidth():"+ parent.getWidth() + "= parent.getHeight():" + parent.getHeight());
        Log.d("------------------" , "parent.getWidth():"+ parent.getWidth() + "= dependency.getHeight():" + dependency.getHeight() + "= dependency.getHeight():" + dependency.getTop());
        Log.d("------------------" , "dependency.getY():"+ dependency.getY()  );
        // 计算X轴坐标
        if (mOriginalHeaderX == 0) {
            this.mOriginalHeaderX = dependency.getWidth() / 2 - child.getWidth() / 2;
        }
        // 计算Y轴坐标
        if (mOriginalHeaderY == 0) {
            mOriginalHeaderY = dependency.getHeight() - child.getHeight();
        }
        //X轴百分比
        float mPercentX = dependency.getY() / mOriginalHeaderX;
        if (mPercentX >= 1) {
            mPercentX = 1;
        }
        //Y轴百分比
        float mPercentY = dependency.getY() / mOriginalHeaderY;
        if (mPercentY >= 1) {
            mPercentY = 1;
        }

        float x = mOriginalHeaderX - mOriginalHeaderX * mPercentX;
        if (x <= child.getWidth()) {
            x = child.getWidth();
        }
        // TODO 头像的放大和缩小没做

        child.setX(x);
        child.setY(mOriginalHeaderY - mOriginalHeaderY * mPercentY);
        return true;
    }
}