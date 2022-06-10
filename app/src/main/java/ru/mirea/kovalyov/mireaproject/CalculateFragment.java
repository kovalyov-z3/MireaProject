package ru.mirea.kovalyov.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.kovalyov.mireaproject.R;

public class CalculateFragment extends Fragment {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        view.findViewById(R.id.calculateButton).setOnClickListener(this::onClickCalculate);
        editText = view.findViewById(R.id.editTextCalculate);
        editText1 = view.findViewById(R.id.editTextCalculateSymbol);
        editText2 = view.findViewById(R.id.editTextCalculate1);
        textView = view.findViewById(R.id.textViewResult);
        return view;
    }

    public void onClickCalculate(View view) {
        String input = editText.getText().toString();
        String input2 = editText2.getText().toString();
        String input1 = editText1.getText().toString();
        double result = 0;

        try {
            double x = Double.parseDouble(input);
            double y = Double.parseDouble(input2);
            switch (input1) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    result = x / y;
                    break;
            }

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }
}