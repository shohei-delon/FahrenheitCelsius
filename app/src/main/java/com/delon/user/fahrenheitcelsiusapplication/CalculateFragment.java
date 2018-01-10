package com.delon.user.fahrenheitcelsiusapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculateFragment extends Fragment {

    private int counter = 0;

    private double FDegree;
    private double CDegree;

    private String editableText;

    private Button fcButton;
    private Button calculateButton;
    private EditText editText;
    private TextView resultTextView;

    public CalculateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calculate, container, false);

        fcButton = (Button)view.findViewById(R.id.choose_f_c_button);
        fcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter%2 ==1){
                    fcButton.setText(R.string.Celsius);
                }else{
                    fcButton.setText(R.string.fahrenheit);
                }
            }
        });

        editText = (EditText)view.findViewById(R.id.f_c_editText);
        resultTextView = (TextView) view.findViewById(R.id.result_textView);

        calculateButton = (Button)view.findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stringにeditTextの文字列を入れる
                editableText = editText.getText().toString();
                //文字列が空じゃなかったら
                if (!(editableText.matches(""))) {
                    //double型にeditTextの文字列を入れる
                    double editTextNumber;
                    editTextNumber = Float.parseFloat(editableText);

                    if (counter % 2 == 1) {
                        FDegree = editTextNumber * 9.0 / 5.0 + 32.0;
                        resultTextView.setText(String.format("%.1f%s", FDegree,"degrees Fahrenheit"));
                    } else if (counter % 2 == 0) {
                        CDegree = 5.0 / 9.0 * (editTextNumber - 32.0);
                        resultTextView.setText(String.format("%.1f%s", CDegree,"degrees Celsius"));
                    }
                }
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

}
