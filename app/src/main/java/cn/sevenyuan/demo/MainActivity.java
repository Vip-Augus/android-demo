package cn.sevenyuan.demo;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.common.collect.Lists;

import java.util.List;

import cn.sevenyuan.demo.adapter.ChatAdapter;
import cn.sevenyuan.demo.adapter.MyDividerItemDecoration;
import cn.sevenyuan.demo.databinding.ActivityMainBinding;
import cn.sevenyuan.demo.model.SimpleMessage;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private EasyRefreshLayout mEasyRefreshLayout;
    private RecyclerView mRecyclerView;

    private ChatAdapter mChatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initView() {
        mEasyRefreshLayout = mBinding.easylayout;
        mRecyclerView = mBinding.recyclerview;
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mChatAdapter);
    }

    private void initData() {
        mChatAdapter = new ChatAdapter(R.layout.item_chat, getData());
    }

    private List<SimpleMessage> getData() {
        List<SimpleMessage> msgList = Lists.newArrayList();
        for (int i = 0; i < 30; i++) {
            SimpleMessage msg = new SimpleMessage();
            msg.setLeastMsg("现在是第" + i);
            msg.setUserName("名字" + i);
            msg.setTime("10:" + i);
            msg.setPortraitUrl("http://oo5aasoph.bkt.clouddn.com/%E6%9C%89%E9%A9%AC%E5%85%AC%E7%94%9F.jpg");
            msgList.add(msg);
        }
        return msgList;
    }

    private void initListener() {
        mEasyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //adapter.addData(list);

                        mEasyRefreshLayout.loadMoreComplete(new EasyRefreshLayout.Event() {
                            @Override
                            public void complete() {
//                                adapter.getData().addAll(list);
//                                adapter.notifyDataSetChanged();
                                mEasyRefreshLayout.refreshComplete();

                            }
                        }, 500);

                    }
                }, 2000);


            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEasyRefreshLayout.refreshComplete();
                        Toast.makeText(getApplicationContext(), "refresh success", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);

            }
        });

        mChatAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

