/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //First way to call another activity
        TextView callFamilyActivity = (TextView) findViewById(R.id.family);
        callFamilyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent);
            }
        });
    }

    //Second way to call a new activity
    public void openNumbersList(View view) {
        Intent intent = new Intent(this,NumbersActivity.class);
        startActivity(intent);
    }

    //Third way to call a new activity
    public void openColorsOrPhrases(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.colors:
                intent = new Intent(this,ColorsActivity.class);
                startActivity(intent);
                break;
            case R.id.phrases:
                intent = new Intent(this,PhrasesActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this,"Error",Toast.LENGTH_LONG);
        }
    }

}
