package com.example.android.miwok;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        criaNumeros();
    }

    private void criaNumeros() {
        //Cria o array de numeros ate 10
        String[] arrayNumbers = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        //Cria o arrayList que suportará adiçoes futuras
        ArrayList<String> arrayListNumbers = new ArrayList<>();
        //Adiciona o Array arrayNumbers dentro do ArrayList arrayListNumbers
        Collections.addAll(arrayListNumbers, arrayNumbers);
        //Cria log de verbose apenas para mostrar o funcionamento do array
        //for (String s:arrayListNumbers) { Log.v("\tArrayList index "+arrayListNumbers.indexOf(s),"\t\tValue: "+s);}

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        for (int i = 0; i < arrayListNumbers.size(); i++) {
            TextView wordView = new TextView(this);
            wordView.setText(arrayListNumbers.get(i));
            rootView.addView(wordView);
        }
    }

}
