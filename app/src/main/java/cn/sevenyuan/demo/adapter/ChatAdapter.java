package cn.sevenyuan.demo.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import cn.sevenyuan.demo.R;
import cn.sevenyuan.demo.model.SimpleMessage;

/**
 *
 * Created by JingQ on 2017/11/20.
 */

public class ChatAdapter extends BaseQuickAdapter<SimpleMessage, BaseViewHolder> {


    public ChatAdapter(int layoutResId, @Nullable List<SimpleMessage> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SimpleMessage item) {
        helper.setText(R.id.textUser, item.getUserName());
        helper.setText(R.id.textSimpleMsg, item.getLeastMsg());
        helper.setText(R.id.textTime, item.getTime());
        try {
            Glide.with(mContext).load(new URL(item.getPortraitUrl())).into((ImageView) helper.getView(R.id.imageUser));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
