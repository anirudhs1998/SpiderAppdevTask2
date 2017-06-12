package com.example.anirudhs.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = (Button)findViewById(R.id.button2);
        Button myButton = (Button)findViewById(R.id.myButton);
        final EditText enterItem = (EditText)findViewById(R.id.enterItem);
        final ListView myList = (ListView)findViewById(R.id.myList);
        final ArrayList<String> listItems = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);



        myList.setAdapter(adapter);
        myButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        if(enterItem.getText().toString().equals("")) {
                            final Toast toast = Toast.makeText(MainActivity.this, "No Item entered", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        else
                            listItems.add(enterItem.getText().toString());
                            enterItem.setText("");

                    }
                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(enterItem.getText().toString().equals("")){
                            final Toast toast = Toast.makeText(MainActivity.this, "Not a valid position", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        int p = Integer.parseInt(enterItem.getText().toString());
                        if(p>=1 && p<=listItems.size()){
                        if(listItems.get(p-1).isEmpty()) {
                            Toast.makeText(MainActivity.this, "No item at this position", Toast.LENGTH_SHORT).show();
                        }
                            else
                            listItems.remove(p-1);
                            enterItem.setText("");
                            adapter.notifyDataSetChanged();
                        }
                            else
                            Toast.makeText(MainActivity.this, "No item at this position", Toast.LENGTH_SHORT).show();

                    }
                }
        );


        myList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(MainActivity.this,Activity2.class);
                        String Items = String.valueOf(parent.getItemAtPosition(position));
                        i.putExtra("itemname",Items);
                        startActivity(i);
                    }
                }
        );
    }
}
