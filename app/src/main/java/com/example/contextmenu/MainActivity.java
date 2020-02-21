package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
   public String [] studentName={"Abdullah","Tusar","Noman","Ridoy","Roby","Ovi","Abdullah","Tusar","Noman","Ridoy","Roby","Ovi","Abdullah","Tusar","Noman","Ridoy","Roby","Ovi"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listViewId);
         arrayAdapter=new ArrayAdapter(MainActivity.this,R.layout.list_sample,R.id.textViewId,studentName);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=new MenuInflater(MainActivity.this);
        menuInflater.inflate(R.menu.menu,menu);
        menu.setHeaderTitle("Select The Action");
        menu.add("Cancle");
        menu.add(0,0,0,"Upload");
        menu.addSubMenu("Others");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,item.getTitle(), Toast.LENGTH_SHORT).show();

//        int id=item.getItemId();
//        switch (id){
//            case R.id.deleteItemId:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.updateItemId:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.noChangeItemId:
//                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//                break;
//                default:
//
//        }
        return true;
    }
}
