package com.example.ahmedsherif.mathriddles;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ahmedsherif.mathriddles.Data.contract;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Levels extends AppCompatActivity {

    Boolean Sound=true;
    int Last_Level,Gold;
    Intent i;
    Context context=this;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,HOME;
    ConstraintLayout constraintLayout;
    String Mode;
    TextView Coins;
    ArrayList<Button> a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        try {
            new AsyncTask().execute();
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error Main Levels "+e.getMessage());
        }
    }
    public void Home (View view)
    {
        ButtonSound ();
        startActivity(new Intent (context,Start.class));

    }
    public void Button1 (View view)
    {
        ButtonSound ();
        i = new Intent(this,Level.class);
        i.putExtra(contract.Intent_Row,1);
        startActivity(i);
    }
    public void Button2 (View view)
    {
        ButtonSound ();
        if (Clickable(2))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,2);
            startActivity(i);
        }

    }
    public void Button3 (View view)
    {
        ButtonSound ();
        if (Clickable(3))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,3);
            startActivity(i);
        }

    }
    public void Button4 (View view)
    {
        ButtonSound ();
        if (Clickable(4))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,4);
            startActivity(i);
        }

    }
    public void Button5 (View view)
    {
        ButtonSound ();
        if (Clickable(5))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,5);
            startActivity(i);
        }

    }
    public void Button6 (View view)
    {
        ButtonSound ();
        if (Clickable(6))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,6);
            startActivity(i);
        }

    }
    public void Button7 (View view)
    {
        ButtonSound ();
        if (Clickable(7))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,7);
            startActivity(i);
        }

    }
    public void Button8 (View view)
    {
        ButtonSound ();
        if (Clickable(8))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,8);
            startActivity(i);
        }
    }
    public void Button9 (View view)
    {

        ButtonSound ();
        if (Clickable(9))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,9);
            startActivity(i);
        }
    }
    public void Button10 (View view)
    {
        ButtonSound ();
        if (Clickable(10))
        {
            i =new Intent(this,Level.class);
            i.putExtra(contract.Intent_Row,10);
            startActivity(i);
        }
    }
    void ButtonSound ()
    {
        if (Sound) {
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
    boolean Clickable (int lvl)
    {
        if (lvl<=Last_Level)
            return true;
        return false;
    }
    private void getData ()
    {
        i=getIntent();
        Mode=getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getString(contract.Mode,contract.DarkMode);
        Gold=getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getInt(contract.Gold,contract.Gold_begin);
        Sound=getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getBoolean(contract.Sound,true);
        Last_Level=getSharedPreferences(contract.Shared_Preferences,MODE_PRIVATE).getInt(contract.Last_Level,1);
    }
    void Mode()
    {
        b0=findViewById(R.id.b1);
        b1=findViewById(R.id.b2);
        b2=findViewById(R.id.b3);
        b3=findViewById(R.id.b4);
        b4=findViewById(R.id.b5);
        b5=findViewById(R.id.b6);
        b6=findViewById(R.id.b7);
        b7=findViewById(R.id.b8);
        b8=findViewById(R.id.b9);
        b9=findViewById(R.id.b10);
        HOME=findViewById(R.id.Home);
        Coins=findViewById(R.id.Money);
        Coins.setText(String.valueOf(Gold));
        constraintLayout=findViewById(R.id.Levels);


        if (Mode.equals(contract.DarkMode))
        {
            b0.setBackgroundColor(getResources().getColor(R.color.White));
            b1.setBackgroundColor(getResources().getColor(R.color.White));
            b2.setBackgroundColor(getResources().getColor(R.color.White));
            b3.setBackgroundColor(getResources().getColor(R.color.White));
            b4.setBackgroundColor(getResources().getColor(R.color.White));
            b5.setBackgroundColor(getResources().getColor(R.color.White));
            b6.setBackgroundColor(getResources().getColor(R.color.White));
            b7.setBackgroundColor(getResources().getColor(R.color.White));
            b8.setBackgroundColor(getResources().getColor(R.color.White));
            b9.setBackgroundColor(getResources().getColor(R.color.White));
            HOME.setBackgroundResource(R.drawable.homedark);
            constraintLayout.setBackgroundResource(R.drawable.dark);



            b0.setTextColor(getResources().getColor(R.color.Black2));
            b1.setTextColor(getResources().getColor(R.color.Black2));
            b2.setTextColor(getResources().getColor(R.color.Black2));
            b3.setTextColor(getResources().getColor(R.color.Black2));
            b4.setTextColor(getResources().getColor(R.color.Black2));
            b5.setTextColor(getResources().getColor(R.color.Black2));
            b6.setTextColor(getResources().getColor(R.color.Black2));
            b7.setTextColor(getResources().getColor(R.color.Black2));
            b8.setTextColor(getResources().getColor(R.color.Black2));
            b9.setTextColor(getResources().getColor(R.color.Black2));
            Coins.setTextColor(getResources().getColor(R.color.White));



        }
        else
        {
            b0.setBackgroundColor(getResources().getColor(R.color.Black));
            b1.setBackgroundColor(getResources().getColor(R.color.Black));
            b2.setBackgroundColor(getResources().getColor(R.color.Black));
            b3.setBackgroundColor(getResources().getColor(R.color.Black));
            b4.setBackgroundColor(getResources().getColor(R.color.Black));
            b5.setBackgroundColor(getResources().getColor(R.color.Black));
            b6.setBackgroundColor(getResources().getColor(R.color.Black));
            b7.setBackgroundColor(getResources().getColor(R.color.Black));
            b8.setBackgroundColor(getResources().getColor(R.color.Black));
            b9.setBackgroundColor(getResources().getColor(R.color.Black));
            HOME.setBackgroundResource(R.drawable.homewhite);
            constraintLayout.setBackgroundResource(R.drawable.white);



            b0.setTextColor(getResources().getColor(R.color.Black2));
            b1.setTextColor(getResources().getColor(R.color.Black2));
            b2.setTextColor(getResources().getColor(R.color.Black2));
            b3.setTextColor(getResources().getColor(R.color.Black2));
            b4.setTextColor(getResources().getColor(R.color.Black2));
            b5.setTextColor(getResources().getColor(R.color.Black2));
            b6.setTextColor(getResources().getColor(R.color.Black2));
            b7.setTextColor(getResources().getColor(R.color.Black2));
            b8.setTextColor(getResources().getColor(R.color.Black2));
            b9.setTextColor(getResources().getColor(R.color.Black2));
            Coins.setTextColor(getResources().getColor(R.color.Black));

        }
        a=new ArrayList<>();
        a.add(b0);
        a.add(b1);
        a.add(b2);
        a.add(b3);
        a.add(b4);
        a.add(b5);
        a.add(b6);
        a.add(b7);
        a.add(b8);
        a.add(b8);
        a.add(b9);
        for (int i=0;i<Last_Level-1;i++)
            if (Mode.equals(contract.DarkMode))
                a.get(i).setBackgroundResource(R.drawable.correctwhite);
            else
                a.get(i).setBackgroundResource(R.drawable.correctdark);
        for (int i=0;i<Last_Level;i++)
            a.get(i).setClickable(true);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        i=new Intent(this,Start.class);
        startActivity(i);
    }
    private class AsyncTask extends android.os.AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
            getData();

            }
            catch (Exception e)
            {
                Log.i("Ahmed","Error Get Data Levels :"+e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void eVoid) {
            Mode();
        }
    }
}
