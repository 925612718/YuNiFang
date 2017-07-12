package com.liu.administratorexample.yunifang;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.liu.administratorexample.yunifang.Fragment.ClassificationFragment;
import com.liu.administratorexample.yunifang.Fragment.HomeFragment;
import com.liu.administratorexample.yunifang.Fragment.MyFragment;
import com.liu.administratorexample.yunifang.Fragment.ShopCar_Fragment;

public class Home extends AppCompatActivity {

    private RadioButton homepager;
    private RadioButton fenlei;
    private RadioGroup home_rg;
    private TextView three_multicolour_text;
    private FrameLayout three_login_fargment;
    private HomeFragment homeFragment;
    private ClassificationFragment fication;
    private RadioButton shop_car;
    private RadioButton my;
    private ShopCar_Fragment car;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
//        设置一个默认的Fragment
        Setinitial();

        home_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
//                如果有了Fragment就先让他隐藏
                hind_show(transaction);
                if (checkedId == R.id.homepager) {
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                        transaction.add(R.id.three_login_fargment, homeFragment);
                    } else {
                        transaction.show(homeFragment);
                    }
                } else if (checkedId == R.id.fenlei) {
                    if (fication == null) {
                        fication = new ClassificationFragment();
                        transaction.add(R.id.three_login_fargment, fication);
                    } else {
                        transaction.show(fication);
                    }
                } else if (checkedId == R.id.shop_car) {
                    if (car == null) {
                        car = new ShopCar_Fragment();
                        transaction.add(R.id.three_login_fargment, car);
                    } else {
                        transaction.show(car);
                    }
                } else if (checkedId == R.id.my) {
                    if (myFragment == null) {
                        myFragment = new MyFragment();
                        transaction.add(R.id.three_login_fargment, myFragment);
                    } else {
                        transaction.show(myFragment);
                    }
                }
                transaction.commit();
            }

        });

    }

    private void initView() {
        homepager = (RadioButton) findViewById(R.id.homepager);
        fenlei = (RadioButton) findViewById(R.id.fenlei);
        my = (RadioButton) findViewById(R.id.my);
        home_rg = (RadioGroup) findViewById(R.id.home_rg);
        three_multicolour_text = (TextView) findViewById(R.id.three_multicolour_text);
        three_login_fargment = (FrameLayout) findViewById(R.id.three_login_fargment);
        shop_car = (RadioButton) findViewById(R.id.shop_car);
    }

    public void Setinitial() {
        homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.three_login_fargment, homeFragment);
        transaction.commit();
    }

    public void hind_show(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);

        }
        if (fication != null) {
            transaction.hide(fication);

        }
        if (car != null) {
            transaction.hide(car);

        }
        if (myFragment != null) {
            transaction.hide(myFragment);

        }
//        transaction.commit();

    }
}
