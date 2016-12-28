package com.doctor.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.accounts)
    com.doctor.demo.view.EditTextWithDel etAccount;
    @BindView(R.id.password)
    com.doctor.demo.view.EditTextWithDel etPassWord;

    @BindView(R.id.login)
    Button btnLogin;
    @BindView(R.id.zhaohuipass)
    TextView zhaohuipass;
    @BindView(R.id.btn_register)
    TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void startActivity(Intent intent,boolean isNeedLogin){
        super.startActivity(intent);
    }
    }

