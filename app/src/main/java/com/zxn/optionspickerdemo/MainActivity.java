package com.zxn.optionspickerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zxn.optionspicker.builder.OptionsPickerBuilder;
import com.zxn.optionspicker.listener.OnOptionsSelectChangeListener;
import com.zxn.optionspicker.listener.OnOptionsSelectListener;
import com.zxn.optionspicker.view.OptionsPickerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private OptionsPickerView pvOptions, pvCustomOptions, pvNoLinkOptions;

    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getNoLinkData();

        initNoLinkOptionsPicker();

        initOptionsPicker();
    }

    private void initOptionsPicker() {

        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

                String str = "food:" + food.get(options1);

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        }).build();
        pvOptions.setPicker(food);
        pvOptions.setSelectOptions(0);
    }

    @OnClick({R.id.btn_no_linkage, R.id.btn_options})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_no_linkage:
                pvNoLinkOptions.show();
                break;
            case R.id.btn_options:
                pvOptions.show();
                break;
        }
    }

    private void initNoLinkOptionsPicker() {// 不联动的多级选项
        pvNoLinkOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

                String str = "food:" + food.get(options1)
                        + "\nclothes:" + clothes.get(options2)
                        + "\ncomputer:" + computer.get(options3);

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        })
                .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
                    @Override
                    public void onOptionsSelectChanged(int options1, int options2, int options3) {
                        String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                })
                // .setSelectOptions(0, 1, 1)
                .build();
        pvNoLinkOptions.setNPicker(food, clothes, computer);
        pvNoLinkOptions.setSelectOptions(0, 1, 1);
    }

    private void getNoLinkData() {
        food.add("KFC");
        food.add("MacDonald");
        food.add("Pizza hut");

        clothes.add("Nike");
        clothes.add("Adidas");
        clothes.add("Armani");

        computer.add("ASUS");
        computer.add("Lenovo");
        computer.add("Apple");
        computer.add("HP");
    }
}
