package com.example.netwoevents.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.netwoevents.R;


public class NewEventFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = (EditText) getView().findViewById(R.id.edit_text_new_event);
        Button btnSave = (Button) getView().findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String newEvent = editText.getText().toString();
                Bundle bundle = new Bundle();
                if(newEvent.isEmpty())
                {
                    Toast.makeText(getContext(), "Ввведите название", Toast.LENGTH_SHORT).show();
                }
                else {
                    bundle.putString("bundleKey", newEvent);
                    Navigation.findNavController(view).navigate
                            (R.id.action_newEventFragment_to_eventRecyclerFragment, bundle);
                }
            }
        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_event, container, false);
    }

}