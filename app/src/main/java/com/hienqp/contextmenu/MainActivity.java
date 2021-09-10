package com.hienqp.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout mainScreen;
    Button buttonChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = (ConstraintLayout) findViewById(R.id.layout_main_screen);
        buttonChangeColor = (Button) findViewById(R.id.button_change_color);

        // đăng ký View cho Context Menu
        registerForContextMenu(buttonChangeColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // gán layout đã xây dựng cho Context Menu thông qua
        getMenuInflater().inflate(R.menu.menu_context_demo, menu);

        menu.setHeaderTitle("Chọn Màu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_do: mainScreen.setBackgroundColor(Color.RED);
                break;
            case R.id.item_vang: mainScreen.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.item_xanh: mainScreen.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}