package ru.mirea.kovalyov.mireaproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import ru.mirea.kovalyov.mireaproject.R;

public class SettingsFragment extends Fragment {

    private EditText editTextName;
    private EditText editTextUniversity;

    private SharedPreferences preferences;

    final String PARAMETER_ONE = "parameter_one";
    final String PARAMETER_TWO = "parameter_two";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextUniversity = view.findViewById(R.id.editTextUniversity);

        view.findViewById(R.id.buttonSavePrefs).setOnClickListener(this::onClickSave);

        preferences = getActivity().getPreferences(MODE_PRIVATE);

        return view;
    }

    public void onClickSave(View view) {

        try {
            String param1 = editTextName.getText().toString();
            String param2 = editTextUniversity.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();

            editor.putString(PARAMETER_ONE, param1);
            editor.putString(PARAMETER_TWO, param2);

            Toast.makeText(getActivity(), "Parameter save", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException exception) {
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
        }
    }
}