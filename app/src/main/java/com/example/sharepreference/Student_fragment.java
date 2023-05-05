package com.example.sharepreference;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class Student_fragment extends Fragment {
    ImageView add;
    Button button;
    TextView id,name,classes;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_fragment, container, false);

     id=view.findViewById(R.id.id);
     name=view.findViewById(R.id.name);
     classes=view.findViewById(R.id.classes);
        add =view.findViewById(R.id.add_student);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "saving", Toast.LENGTH_SHORT).show();
                LayoutInflater linf = LayoutInflater.from(view.getContext());
                final View inflator = linf.inflate(R.layout.student_dialoge, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());

                alert.setTitle("Update");
                alert.setMessage("Update Data");
                alert.setView(inflator);

               final EditText et1 = (EditText) inflator.findViewById(R.id.student_id);
                final EditText et2 = (EditText) inflator.findViewById(R.id.student_name);
                final EditText et3 = (EditText) inflator.findViewById(R.id.student_class);



                   alert.setPositiveButton("add", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sharedPreferences = getContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                            PRIVATE MODE use for no anyone project access the data of this project
                            SharedPreferences.Editor myEdit = sharedPreferences.edit();

                            myEdit.putString("id", et1.getText().toString());
                            myEdit.putString("name", et2.getText().toString());
                            myEdit.putString("class", et3.getText().toString());

                            myEdit.apply();
                            dialog.dismiss();

                        }


                });
        alert.show();
    }
});  // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
       String k=sh.getString("id","");
        String s1 = sh.getString("name", "");
        String s2 = sh.getString("class", "");

        // Setting the fetched data in the EditTexts
       id.setText(k);
        name.setText(s1);
        classes.setText(s2);




        return view;
    }
}