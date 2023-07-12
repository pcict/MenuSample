package com.websarva.wings.android.menusample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        //intentを受け取る
        Intent intent = getIntent();
        //送られてきた項目を取得
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");

        //画面部品の取得
        TextView tvMenu = findViewById(R.id.tvMenuName);
        TextView tvPrice = findViewById(R.id.tvMenuPrice);
        //画面部品に値を設定
        tvMenu.setText(menuName);
        tvPrice.setText(menuPrice);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
}