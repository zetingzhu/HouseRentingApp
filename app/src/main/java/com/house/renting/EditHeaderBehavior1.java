package com.house.renting;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EditHeaderBehavior1 extends CoordinatorLayout.Behavior<EditText> {
    private static final String TAG = EditHeaderBehavior1.class.getSimpleName();

    // 显示位置布局
    private int queryWidth = 0;
    private int mDependencyTop;// Coordinator布局剩余高度
    private int mDependencyMinHeight; // Coordinator最小高度
    private int mChildTop;// 查询框距离顶部高度
    private int mChildHeight;// 查询框高度
    private int mQueryParentHeight;// 查询父布局

    private float targetTop = 0; // 跟随移动设置目标高度
    private float translationY = 0; // 跟随移动设置目标高度


    private final float toolbarHeightInPixel;

    public EditHeaderBehavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
        toolbarHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.dimen_60dp);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, EditText child, View dependency) {
        return dependency instanceof TextView;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, EditText child, View dependency1) {
        AppBarLayout appBarLayout = (AppBarLayout) parent.getChildAt(0);
        if (appBarLayout != null) {
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) appBarLayout.getChildAt(0);
            if (collapsingToolbarLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) collapsingToolbarLayout.getChildAt(1);
                if (relativeLayout != null) {
//                    int mCount = relativeLayout.getChildCount();
                    View view = relativeLayout.getChildAt(2);
                    if (view.getId() == R.id.ll_query) {
                        queryWidth = view.getWidth();

                        // 最小高度
                        mDependencyMinHeight = relativeLayout.getHeight();
                        // 查询父布局
                        mQueryParentHeight = view.getHeight();
                        // Coordinator布局剩余高度
                        mDependencyTop = appBarLayout.getTop();
                        // 查询框距离顶部高度
                        mChildTop = child.getTop();
                        // 查询框高度
                        mChildHeight = child.getHeight();
                        // 最后距离边框高度
//                        double paddingParentTop = (mQueryParentHeight - mChildHeight) * 0.5;
                        // ((AppBarLayout) dependency).getTotalScrollRange() 指可滑动的范围
//                        int totalScrollRange = ((AppBarLayout) dependency).getTotalScrollRange();
//                            Log.d("------------------", "可滑动范围 ：" + totalScrollRange + "当前滑动值: "+ mDependencyTop);

                        targetTop = (float) ((Math.abs(mDependencyTop) * mChildTop) / (Math.abs(mDependencyTop) + mQueryParentHeight));
                        translationY = targetTop * -1 + 4;
                        child.setTranslationY(translationY);
                    }
                }
            }
        }
        return true;
    }
}