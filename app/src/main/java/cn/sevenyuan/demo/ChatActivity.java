package cn.sevenyuan.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by JingQ on 2017/11/21.
 */

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getUser();
    }

    private void getUser() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("user");
        String userName= (String) bundle.get("userName");
        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

    }
}
