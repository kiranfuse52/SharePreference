package com.example.sharepreference;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.Image;
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


public class Family_Fragment extends Fragment {
ImageView add1;
TextView brother_name,father_name,mother_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_family_, container, false);

        brother_name=view.findViewById(R.id.brother_name);
        father_name=view.findViewById(R.id.father_name);
        mother_name=view.findViewById(R.id.mother_name);
        add1=view.findViewById(R.id.family);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "saving", Toast.LENGTH_SHORT).show();
                LayoutInflater linf = LayoutInflater.from(view.getContext());
                final View inflator = linf.inflate(R.layout.family_dialog, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());

                alert.setTitle("Update");
                alert.setMessage("Update Data");
                alert.setView(inflator);

                final EditText et4 = (EditText) inflator.findViewById(R.id.brother_name1);
                final EditText et5 = (EditText) inflator.findViewById(R.id.father_name1);
                final EditText et6 = (EditText) inflator.findViewById(R.id.mother_name1);



                alert.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("family", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = sharedPreferences.edit();

                        myEdit.putString("id", et4.getText().toString());
                        myEdit.putString("name", et5.getText().toString());
                        myEdit.putString("class", et6.getText().toString());

                        myEdit.apply();
                        dialog.dismiss();

                    }


                });
                alert.show();
            }
        });  // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String k=sh.getString("id","1");
        String s1 = sh.getString("name", "");
        String s2 = sh.getString("class", "");

        // Setting the fetched data in the EditTexts
        brother_name.setText(s1);
        father_name.setText(s2);
        mother_name.setText(k);

        return view;
    }
}