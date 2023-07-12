package com.websarva.wings.android.menusample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView _lvMenu;
    private List<Map<String, Object>> _menuList;
    private static final String[] FROM ={"name", "price"};
    private static final int[] TO ={R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _lvMenu = findViewById(R.id.lvMenu);

        _menuList = createTeishokuList();
        //カレーメニューを追加
        //_menuList.addAll(createCurryList());

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);

        _lvMenu.setAdapter(adapter);
        _lvMenu.setOnItemClickListener(new ListItemClickListener());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list,menu);
        return true;

    }

    private List<Map<String, Object>> createCurryList(){
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスを効かせた国産ビーフ100％のカレーです");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスを効かせた国産ポーク100％のカレーです");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "チキンカレー");
        menu.put("price", 450);
        menu.put("desc", "特選スパイスを効かせた国産チキン100％のカレーです");
        menuList.add(menu);
        return menuList;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean returnVal = true;
        //選択されたメニュIDを取得
        int itemId = item.getItemId();

        if(itemId == R.id.menuListOptionTeishoku){
            _menuList = createTeishokuList();
        }
        else if(itemId == R.id.menuListOptionCurry){
            _menuList = createCurryList();
        }
        else {
            returnVal = super.onOptionsItemSelected(item);
        }

//        switch (itemId){
//            case R.id.menuListOptionTeishoku:
//                _menuList = createTeishokuList();
//                break;
//            case R.id.menuListOptionCurry:
//                _menuList = createCurryList();
//                break;
//            default:
//                returnVal = super.onOptionsItemSelected(item);
//                break;
//        }

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row,FROM , TO);
        _lvMenu.setAdapter(adapter);
        return returnVal;
    }

    private List<Map<String, Object>> createTeishokuList(){
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鶏の唐揚げにサラダ、ご飯とみそ汁がつきます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc","手捏ねハンバーグにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc","自家栽培のショウガを使用した生姜焼きにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc","A5和牛のステーキにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc","有機野菜を使用した野菜炒めにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc","三元豚のヒレとんかつにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ミンチカツ定食");
        menu.put("price", 850);
        menu.put("desc","うまみたっぷりのミンチカツにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc","解放育成した若鳥のもも肉のカツにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc","ほくほくジャガイモのコロッケにサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("desc","回鍋肉にサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 800);
        menu.put("desc","花椒が効いた麻婆豆腐にサラダ、ごはんとお味噌汁が付きます。");
        menuList.add(menu);
        return menuList;
    }



    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Map<String, Object> item = (Map<String, Object>)parent.getItemAtPosition(position);

            String menuName = (String)item.get("name");
            Integer menuPrice = (Integer)item.get("price");

            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice + "円");

            startActivity(intent);
        }
    }

}