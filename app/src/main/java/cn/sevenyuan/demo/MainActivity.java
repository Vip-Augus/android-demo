package cn.sevenyuan.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

import cn.sevenyuan.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button testButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.remove_item:

                break;
            default:

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XLog.init(LogLevel.ALL);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("cn.sevenyuan.SecondActivity");
                intent.addCategory("android.intent.category.My_tag");
                intent.putExtra("debug", "wahaha");
                startActivity(intent);
            }
        });
    }

    private void initView() {
        testButton = binding.testButton;
    }
}
