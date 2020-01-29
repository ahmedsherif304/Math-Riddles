package com.example.ahmedsherif.mathriddles;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.ahmedsherif.mathriddles.Data.contract;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Start extends AppCompatActivity {
    SharedPreferences preferences;
    boolean Sound = true;
    String Mode = contract.DarkMode;
    int Gold = contract.Gold_begin, Last_Level = 1;
    ConstraintLayout layout;
    Button b1, b2, b3, b4;
    Intent i;
    SharedPreferences.Editor editor;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        try {
            new AsyncTask().execute();
        } catch (Exception e) {
            Log.i("Ahmed","Error :"+ e.getMessage());
        }


    }

    void Shared_Preferences() {
        preferences = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE);
        Mode = preferences.getString(contract.Mode, contract.DarkMode);
        Sound = preferences.getBoolean(contract.Sound, true);
        Gold = preferences.getInt(contract.Gold, 10);
        Last_Level = preferences.getInt(contract.Last_Level, Last_Level);

    }

    void Mode() {
        layout = findViewById(R.id.Main);
        b1 = findViewById(R.id.Start);
        b2 = findViewById(R.id.Restart);
        b3 = findViewById(R.id.Setting);
        b4 = findViewById(R.id.Levels);

        if (Mode.equals(contract.DarkMode)) {
            layout.setBackgroundResource(R.drawable.startdark);
            b1.setBackgroundColor(getResources().getColor(R.color.Black));
            b2.setBackgroundColor(getResources().getColor(R.color.Black));
            b4.setBackgroundColor(getResources().getColor(R.color.Black));
            b1.setTextColor(getResources().getColor(R.color.White));
            b2.setTextColor(getResources().getColor(R.color.White));
            b4.setTextColor(getResources().getColor(R.color.White));
            b3.setBackgroundResource(R.drawable.settingsdark);
        } else {
            layout.setBackgroundResource(R.drawable.startwhite);
            b1.setBackgroundColor(getResources().getColor(R.color.White));
            b2.setBackgroundColor(getResources().getColor(R.color.White));
            b4.setBackgroundColor(getResources().getColor(R.color.White));
            b1.setTextColor(getResources().getColor(R.color.Black));
            b2.setTextColor(getResources().getColor(R.color.Black));
            b4.setTextColor(getResources().getColor(R.color.Black));
            b3.setBackgroundResource(R.drawable.settingswhite);
        }


    }

    public void Start(View view) {
        try {

            ButtonSound();
            //the current level
            i = new Intent(this, Level.class);
            i.putExtra(contract.Intent_Row, getSharedPreferences(contract.Last_Level, Context.MODE_PRIVATE).getInt(contract.Last_Level, Last_Level));
            startActivity(i);
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error :"+ e.getMessage());
        }


    }

    public void Levels(View view) {

        ButtonSound();
        i= new Intent(this,Levels.class);
        startActivity(i);
    }

    public void Restart(View view) {

        ButtonSound();
        preferences = Start.this.getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(contract.Mode, contract.DarkMode);
        editor.putBoolean(contract.Sound, true);
        editor.putInt(contract.Gold, contract.Gold_begin);
        editor.putInt(contract.Last_Level,1);
        editor.apply();
        getContentResolver().delete(contract.Table_URI,null,null);
        reCreate();

    }

    public void Settings(View view) {

        ButtonSound();
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        if (!Mode.equals(contract.DarkMode)) {
            popupMenu.getMenu().findItem(R.id.ModeItem).setIcon(R.color.White);
            popupMenu.getMenu().findItem(R.id.SoundItem).setIcon(R.color.White);
        } else {
            popupMenu.getMenu().findItem(R.id.ModeItem).setIcon(R.color.Black);
            popupMenu.getMenu().findItem(R.id.SoundItem).setIcon(R.color.Black);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ModeItem: {
                        ButtonSound();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(R.string.Mode_Message);
                        

                        builder.setPositiveButton(R.string.On, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).edit();
                                editor.putString(contract.Mode, contract.DarkMode);
                                editor.apply();
                                Mode();
                                reCreate();
                            }
                        });
                        builder.setNegativeButton(R.string.Off, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).edit();
                                editor.putString(contract.Mode, contract.WhiteMode);
                                editor.apply();
                                Mode();
                                reCreate();
                            }
                        });
                        builder.create().show();
                        return true;
                    }

                    case R.id.SoundItem: {
                        ButtonSound();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(R.string.Sound_Message);
                        builder.setPositiveButton(R.string.On, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).edit();
                                editor.putBoolean(contract.Sound, true);
                                Sound=true;
                                editor.apply();
                                Mode();
                                reCreate();
                            }
                        });
                        builder.setNegativeButton(R.string.Off, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editor = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).edit();
                                editor.putBoolean(contract.Sound, false);
                                Sound=false;
                                editor.apply();
                                Mode();
                                reCreate();
                            }
                        });
                        builder.create().show();
                        return true;
                    }

                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }


    void ButtonSound() {
        if (Sound) {
            Log.i("Ahmed","Play Sound");
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                }
            });
        }
    }


    void reCreate() {
        i = new Intent(this, Start.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are you Sure you want to Exit game ?");
        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ButtonSound();
                moveTaskToBack(true);
                finish();
            }
        });
        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ButtonSound();
            }
        });
        builder.create().show();

    }

    private class AsyncTask extends android.os.AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Shared_Preferences();
            }
            catch (Exception e)
            {
                Log.i("Ahmed","Error :"+ e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Mode();
        }
    }

}
