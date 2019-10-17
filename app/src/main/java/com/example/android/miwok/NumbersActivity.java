package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        criaNumeros();
    }

    private void criaNumeros() {
        /*Cria o array de numeros ate 10
        String[] arrayNumbers = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        //Cria o arrayList que suportará adiçoes futuras
        ArrayList<String> arrayListNumbers = new ArrayList<>();
        //Adiciona o Array arrayNumbers dentro do ArrayList arrayListNumbers
        Collections.addAll(arrayListNumbers, arrayNumbers);
        //Cria log de verbose apenas para mostrar o funcionamento do array
        //for (String s:arrayListNumbers) { Log.v("\tArrayList index "+arrayListNumbers.indexOf(s),"\t\tValue: "+s);}

        //Criando o ArrayAdapter
        /*ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayListNumbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);*/

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Lutti"));
        words.add(new Word("Two", "Otiiko"));
        words.add(new Word("Three", "Tolookos"));
        words.add(new Word("Four", "Oyyisa"));
        words.add(new Word("Five", "Massokka"));
        words.add(new Word("Six", "Temmokka"));
        words.add(new Word("Seven", "Kenekaku"));
        words.add(new Word("Eight", "Kawinta"));
        words.add(new Word("Nine", "Wo'e"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));
        words.add(new Word("Ten", "Na'aacha"));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    public void showIdToast(View view) {
        String textToShow = "Textview pressed: " + view.getId() + "\nThe Text is: " + ((TextView) findViewById(view.getId())).getText();
        Toast.makeText(this, textToShow, Toast.LENGTH_LONG).show();
    }
}
