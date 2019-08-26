package com.house.renting;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zeting
 * Date 2019-08-26.
 */
public class MessageBehavior extends CoordinatorLayout.Behavior<TextView> {
    // 记录Toolbar的顶部位置
    private int start = 0;

    // 构造函数
    public MessageBehavior() {
    }

    public MessageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 判断dependency的类型
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    // 当被依赖的对象也就是被监听的对象，这里就是Toolbar改变时回调，设置title布局的translationY
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        if (start == 0) {
            start = (int) dependency.getY();
        }
        float ratio = dependency.getY() / start;
        child.setY(-child.getMeasuredHeight() * ratio);
        return true;
    }

}
