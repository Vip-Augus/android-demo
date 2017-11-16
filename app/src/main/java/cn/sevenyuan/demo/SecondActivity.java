package cn.sevenyuan.demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.common.collect.Lists;

import java.util.List;

import cn.sevenyuan.demo.adapter.TestAdapter;
import cn.sevenyuan.demo.databinding.ActivitySecondBinding;
import cn.sevenyuan.demo.model.TestModel;

public class SecondActivity extends AppCompatActivity {


    private ActivitySecondBinding binding;
    private Button testButton;
    private RecyclerView recyclerView;

    private List<TestModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        modelList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            TestModel model = new TestModel();
            model.setName("hah" + i);
            modelList.add(model);
        }
    }

    private void initView() {
        testButton = binding.testButton;
        recyclerView = binding.recycleView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        TestAdapter adapter = new TestAdapter(modelList);
        recyclerView.setAdapter(adapter);
    }

    private void initListener() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("debug");
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
