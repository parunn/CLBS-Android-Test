package test.clbs.android.example.com.clbsandroidtest.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import test.clbs.android.example.com.clbsandroidtest.R;
import test.clbs.android.example.com.clbsandroidtest.databinding.FragmentOneLayoutBinding;
import test.clbs.android.example.com.clbsandroidtest.databinding.FragmentTwoLayoutBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    //Global Variable
    private View view;
    FragmentTwoLayoutBinding fragmentTwoLayoutBinding; //Data Binding Object

    static String text;

    private static EditText fragmentTwoEditText;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragmentTwoLayoutBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_two_layout, container, false);
        view = fragmentTwoLayoutBinding.getRoot();

        initial();
        TextWatcher();

        return view;

    }

    //Initial Setup
    private void initial() {

        fragmentTwoEditText = (EditText)view.findViewById(R.id.secondFragmentInputField);

    }


    private void TextWatcher() {

        final String[] secondFragmentInputField = new String[1];

        //longitudeInputField
        fragmentTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                secondFragmentInputField[0] = fragmentTwoLayoutBinding.secondFragmentInputField.getText().toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!secondFragmentInputField[0].equals(fragmentTwoLayoutBinding.secondFragmentInputField.getText().toString())){

                        FirstFragment.processFragmentOneEditText(s.toString());
                    }
            }
        });

    }

    //Method to save data to other fragment
    public static void processFragmentTwoEditText(String text) {

        fragmentTwoEditText.setText(text);
    }
}
