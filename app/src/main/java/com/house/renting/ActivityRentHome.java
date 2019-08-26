package com.house.renting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ActivityRentHome extends AppCompatActivity {
    private static final String TAG = ActivityRentHome.class.getSimpleName();

    private RecyclerView recyclerView;
    CoordinatorLayout coordinator_parent ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_rent_home5 );
        initView();
    }

    private void initView() {

        coordinator_parent = findViewById(R.id. coordinator_parent ) ;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(this));

        coordinator_parent.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                Log.d(TAG , "布局层级是否改变 onChildViewAdded " + child.toString() ) ;
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                Log.d(TAG , "布局层级是否改变 onChildViewAdded " + child.toString()) ;
            }
        });

    }
}
