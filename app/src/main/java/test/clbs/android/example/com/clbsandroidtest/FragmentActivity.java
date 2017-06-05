package test.clbs.android.example.com.clbsandroidtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import test.clbs.android.example.com.clbsandroidtest.databinding.FragmentMainLayoutBinding;
import test.clbs.android.example.com.clbsandroidtest.fragment.FirstFragment;
import test.clbs.android.example.com.clbsandroidtest.fragment.SecondFragment;


/**
 * Created by parunpichaiwong on 5/28/2017 AD.
 */

public class FragmentActivity extends AppCompatActivity {

    //Global Variable
    FragmentMainLayoutBinding fragmentMainLayoutBinding; //Data Binding Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding Mapping
        this.fragmentMainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.fragment_main_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();

        //First Fragment
        FirstFragment firstFragment = new FirstFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.firstConstraintLayout, firstFragment, firstFragment.getTag())
        .commit();

        //Second Fragment
        SecondFragment secondFragment = new SecondFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.secondConstraintLayout, secondFragment, secondFragment.getTag())
                .commit();
    }
}
