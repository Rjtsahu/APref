package com.sahurjt.aprefdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahurjt.apref.APref;

public class MainActivity extends Activity {

    private EditText mName;
    private EditText mAge;
    private EditText mCity;
    private APref<PreferenceModel> mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.editName);
        mAge = findViewById(R.id.editAge);
        mCity = findViewById(R.id.editCity);

        mSettings = APref.getInstance(PreferenceModel.class);

        loadValues();

        final Button mSaveButton = findViewById(R.id.btnSave);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set new value to setting object
                mSettings.object.name = mName.getText().toString();
                mSettings.object.age = Integer.valueOf(mAge.getText().toString());
                mSettings.object.city = mCity.getText().toString();

                /// save settings
                mSettings.commit();
                Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
            }
        });

        Button mLoadButton = findViewById(R.id.btnLoad);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSettings != null) {
                    mSettings.reset( false);
                    loadValues();
                    Toast.makeText(getBaseContext(),"Data reloaded",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loadValues() {
        mName.setText(String.valueOf(mSettings.object.name));
        mAge.setText(String.valueOf(mSettings.object.age));
        mCity.setText(String.valueOf(mSettings.object.city));
    }

}
