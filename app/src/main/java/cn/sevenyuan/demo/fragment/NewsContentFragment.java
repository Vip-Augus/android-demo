package cn.sevenyuan.demo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.sevenyuan.demo.R;
import cn.sevenyuan.demo.databinding.NewsContentFragBinding;
import cn.sevenyuan.demo.model.News;

/**
 * Created by JingQi on 2017/11/19.
 */

public class NewsContentFragment extends Fragment{

    private NewsContentFragBinding fragBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_content_frag, container, false);
        fragBinding = DataBindingUtil.getBinding(view);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        fragBinding.visibilityLayout.setVisibility(View.VISIBLE);
        News news = new News(newsTitle, newsContent);
        fragBinding.setNews(news);
    }
}