package test.clbs.android.example.com.clbsandroidtest.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import test.clbs.android.example.com.clbsandroidtest.R;
import test.clbs.android.example.com.clbsandroidtest.databinding.FragmentOneLayoutBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    //Global Variable
    private View view;

    FragmentOneLayoutBinding fragmentOneLayoutBinding; //Data Binding Object

    private static EditText fragmentOneEditText;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragmentOneLayoutBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_one_layout, container, false);
        view = fragmentOneLayoutBinding.getRoot();

        initial();
        TextWatcher();

        return view;

    }

    //Initial Setup
    private void initial() {

        fragmentOneEditText = (EditText)view.findViewById(R.id.firstFragmentInputField);

    }

    private void TextWatcher() {

        final String[] firstFragmentInputField = new String[1];

        //longitudeInputField
        fragmentOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstFragmentInputField[0] = fragmentOneLayoutBinding.firstFragmentInputField.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!firstFragmentInputField[0].equals(fragmentOneLayoutBinding.firstFragmentInputField.getText().toString())){

                    FirstFragment.processFragmentOneEditText(fragmentOneLayoutBinding.firstFragmentInputField.getText().toString());
                }



                SecondFragment.processFragmentTwoEditText(fragmentOneLayoutBinding.firstFragmentInputField.getText().toString());
            }
        });

    }











    //Method to process data from another fragment
    public static void processFragmentOneEditText(String text) {

        fragmentOneEditText.setText(text);
    }
}
