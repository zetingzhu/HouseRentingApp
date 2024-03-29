package com.house.renting;

/**
 * Created by zeting
 * Date 2019-08-26.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/1.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public static List<User> users = new ArrayList<User>() {
        {
            add(new User(R.drawable.qu_images, "刘备", "唯贤唯德，能服于人"));
            add(new User(R.drawable.qu_images, "诸葛亮", "淡泊以明志，宁静以致远"));
            add(new User(R.drawable.qu_images, "关羽", "安能与老兵同列"));
            add(new User(R.drawable.qu_images, "赵云", "子龙一身是胆"));
            add(new User(R.drawable.qu_images, "曹操", "宁教我负天下人，不教天下人负我"));
            add(new User(R.drawable.qu_images, "司马懿", "老而不死是为贼"));
            add(new User(R.drawable.qu_images, "司马昭", "司马昭之心路人皆知"));
            add(new User(R.drawable.qu_images, "孙权", "生子当如孙仲谋"));
            add(new User(R.drawable.qu_images, "周瑜", "既生瑜何生亮"));
            add(new User(R.drawable.qu_images, "吕蒙", "士别三日当刮目相待"));
        }
    };

    public static SparseArray<String> groups = new SparseArray<>();

    static {
        groups.put(0, "蜀国");
        groups.put(1, "魏国");
        groups.put(2, "吴国");
    }

    private Context context;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.user_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public List<?> getData() {
        return users;
    }
}