package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mediaPlayer.start();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Libera recursos apos a finalizacao do audio
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        // Verifica se esta reproduzindo um audio
        if (mediaPlayer != null) {
            // Libera os recursos do mediaPlayer
            mediaPlayer.release();
            // Configura o media player em null pois nao esta mais reproduzindo audio
            mediaPlayer = null;
            //Abandona o recurso de audio
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);
        return criaNumeros(rootView);
    }

    private View criaNumeros(View rootView) {
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

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two", "Otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Three", "Tolookos",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Four", "Oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Five", "Massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Six", "Temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Seven", "Kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Eight", "Kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Nine", "Wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));
        words.add(new Word("Ten", "Na'aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Adiciona um listener na listview "list" que chama o metodo showIdToast()
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showIdToast(view);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getAudioResourceId());
                    mediaPlayer.start();
                /*
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        Toast.makeText(NumbersActivity.this,"Song start",Toast.LENGTH_LONG).show();
                    }
                });*/
                    //Verifica se ja terminou de rodar o audio
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            //Toast.makeText(NumbersActivity.this,"Song end",Toast.LENGTH_LONG).show();
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void showIdToast(View view) {
        TextView textView = view.findViewById(R.id.default_text_view);
        String textToShow = "Playing audio\nDefault value: " + textView.getText().toString() + "\nIn Miwok language: " + ((TextView) view.findViewById(R.id.miwok_text_view)).getText().toString().trim();
        //Toast.makeText(getContext(), textToShow, Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(),textToShow,Toast.LENGTH_LONG).show();
    }
}
