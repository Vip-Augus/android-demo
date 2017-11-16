package cn.sevenyuan.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.sevenyuan.demo.R;
import cn.sevenyuan.demo.model.TestModel;

/**
 * Created by JingQiYe on 2017/11/16.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private List<TestModel> modelList;

    public TestAdapter(List<TestModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TestModel model = modelList.get(position);
        holder.textView.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.testTextView);
        }
    }
}
