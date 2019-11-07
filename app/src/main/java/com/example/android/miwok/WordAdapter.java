package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Verifica se uma View esta sendo reutilizada ou se nao cria uma nova View
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        //Recebe a posicao do objeto na lista
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaulTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaulTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageResource = listItemView.findViewById(R.id.default_image);
        if(currentWord.hasImage()){
            imageResource.setImageResource(currentWord.getImageResourceId());
            imageResource.setVisibility(View.VISIBLE);
        }else{
            imageResource.setVisibility(View.GONE);
        }

        /*
        miwokTextView.setTag(""+ViewCompat.generateViewId() + "Item position: "+getItem(position));
        miwokTextView.setId(ViewCompat.generateViewId());
        */

        //Retorna o objeto para ser adicionado na ListView
        return listItemView;
    }
}
