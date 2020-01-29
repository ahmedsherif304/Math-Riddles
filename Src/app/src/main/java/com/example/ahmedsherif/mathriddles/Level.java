package com.example.ahmedsherif.mathriddles;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Vibrator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedsherif.mathriddles.Data.contract;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Level extends AppCompatActivity {
    Intent i;
    int Level,Gold,Last_Level;
    boolean Sound=true;
    Cursor cursor;
    String hint,Mode,s,s2;
    int ImageDark,ImageWhite,hint_statue,Answer,Passed;
    TextView t,t1,Coins,Level_num;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,HOME,Submit,Remove;
    ImageView Q;
    Context context=this;
    ConstraintLayout constraintLayout;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        new AsyncTask().execute();

    }

    private void getData ()
    {
        try {
            Mode = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getString(contract.Mode, contract.DarkMode);
            Gold = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getInt(contract.Gold, contract.Gold_begin);
            Sound = getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getBoolean(contract.Sound, true);
            Last_Level=getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).getInt(contract.Last_Level, 1);
            i = getIntent();
            Level = i.getIntExtra(contract.Intent_Row, 1);
            cursor = getContentResolver().query(ContentUris.withAppendedId(contract.Row_URI, Level), null, null, null, null);
            cursor.moveToFirst();
            hint = cursor.getString(cursor.getColumnIndexOrThrow(contract.Column_Hint));
            ImageDark = cursor.getInt(cursor.getColumnIndexOrThrow(contract.Column_Question_Dark));
            ImageWhite = cursor.getInt(cursor.getColumnIndexOrThrow(contract.Column_Question_White));
            hint_statue = cursor.getInt(cursor.getColumnIndexOrThrow(contract.Column_Hint_Status));
            Answer = cursor.getInt(cursor.getColumnIndexOrThrow(contract.Column_Answer));
            Passed = cursor.getInt(cursor.getColumnIndexOrThrow(contract.Column_Passed));
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error Get Data Level:"+ e.getMessage());
        }
    }
    void Mode()
    {
        try {
            constraintLayout = findViewById(R.id.Level);
            t = findViewById(R.id.Result);
            t1 = findViewById(R.id.AnswerInput);
            Coins = findViewById(R.id.money);
            Coins.setText(String.valueOf(Gold));
            Submit = findViewById(R.id.Submit);
            Remove = findViewById(R.id.Remove);
            HOME = findViewById(R.id.home);
            b0 = findViewById(R.id.B0);
            b1 = findViewById(R.id.B1);
            b2 = findViewById(R.id.B2);
            b3 = findViewById(R.id.B3);
            b4 = findViewById(R.id.B4);
            b5 = findViewById(R.id.B5);
            b6 = findViewById(R.id.B6);
            b7 = findViewById(R.id.B7);
            b8 = findViewById(R.id.B8);
            b9 = findViewById(R.id.B9);
            Q = findViewById(R.id.Question);
            Level_num= findViewById(R.id.Level_Num);
            Level_num.setText("Level "+String.valueOf(Level));

            if (Mode.equals(contract.DarkMode)) {
                Q.setImageResource(ImageDark);
                b0.setBackgroundColor(getResources().getColor(R.color.White));
                b1.setBackgroundColor(getResources().getColor(R.color.White));
                t1.setBackgroundColor(getResources().getColor(R.color.White));
                b2.setBackgroundColor(getResources().getColor(R.color.White));
                b3.setBackgroundColor(getResources().getColor(R.color.White));
                b4.setBackgroundColor(getResources().getColor(R.color.White));
                b5.setBackgroundColor(getResources().getColor(R.color.White));
                b6.setBackgroundColor(getResources().getColor(R.color.White));
                b7.setBackgroundColor(getResources().getColor(R.color.White));
                b8.setBackgroundColor(getResources().getColor(R.color.White));
                b9.setBackgroundColor(getResources().getColor(R.color.White));
                HOME.setBackgroundResource(R.drawable.homedark);
                Submit.setBackgroundColor(getResources().getColor(R.color.Black2));
                Remove.setBackgroundColor(getResources().getColor(R.color.Black2));
                constraintLayout.setBackgroundResource(R.drawable.dark);
                t.setTextColor(getResources().getColor(R.color.White));


                b0.setTextColor(getResources().getColor(R.color.Black));
                b1.setTextColor(getResources().getColor(R.color.Black));
                t1.setTextColor(getResources().getColor(R.color.Black));
                b2.setTextColor(getResources().getColor(R.color.Black));
                b3.setTextColor(getResources().getColor(R.color.Black));
                b4.setTextColor(getResources().getColor(R.color.Black));
                b5.setTextColor(getResources().getColor(R.color.Black));
                b6.setTextColor(getResources().getColor(R.color.Black));
                b7.setTextColor(getResources().getColor(R.color.Black));
                b8.setTextColor(getResources().getColor(R.color.Black));
                b9.setTextColor(getResources().getColor(R.color.Black));
                Coins.setTextColor(getResources().getColor(R.color.White));
                Submit.setTextColor(getResources().getColor(R.color.White));
                Remove.setTextColor(getResources().getColor(R.color.White));


            } else {
                Q.setImageResource(ImageWhite);
                b0.setBackgroundColor(getResources().getColor(R.color.Black));
                b1.setBackgroundColor(getResources().getColor(R.color.Black));
                t1.setBackgroundColor(getResources().getColor(R.color.Black));
                b2.setBackgroundColor(getResources().getColor(R.color.Black));
                b3.setBackgroundColor(getResources().getColor(R.color.Black));
                b4.setBackgroundColor(getResources().getColor(R.color.Black));
                b5.setBackgroundColor(getResources().getColor(R.color.Black));
                b6.setBackgroundColor(getResources().getColor(R.color.Black));
                b7.setBackgroundColor(getResources().getColor(R.color.Black));
                b8.setBackgroundColor(getResources().getColor(R.color.Black));
                b9.setBackgroundColor(getResources().getColor(R.color.Black));
                HOME.setBackgroundResource(R.drawable.homewhite);
                Submit.setBackgroundColor(getResources().getColor(R.color.White));
                Remove.setBackgroundColor(getResources().getColor(R.color.White));
                constraintLayout.setBackgroundResource(R.drawable.white);
                t.setTextColor(getResources().getColor(R.color.Black));


                b0.setTextColor(getResources().getColor(R.color.White));
                b1.setTextColor(getResources().getColor(R.color.White));
                t1.setTextColor(getResources().getColor(R.color.White));
                b2.setTextColor(getResources().getColor(R.color.White));
                b3.setTextColor(getResources().getColor(R.color.White));
                b4.setTextColor(getResources().getColor(R.color.White));
                b5.setTextColor(getResources().getColor(R.color.White));
                b6.setTextColor(getResources().getColor(R.color.White));
                b7.setTextColor(getResources().getColor(R.color.White));
                b8.setTextColor(getResources().getColor(R.color.White));
                b9.setTextColor(getResources().getColor(R.color.White));
                Coins.setTextColor(getResources().getColor(R.color.Black));
                Submit.setTextColor(getResources().getColor(R.color.Black));
                Remove.setTextColor(getResources().getColor(R.color.Black));

            }
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error Mode Level:"+ e.getMessage());
        }

    }

    public void Hint (View view)
    {
        ButtonSound(1);
        try {
            if (hint_statue == 0) {
               BuilderCreate("Hint");
            } else {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Hint");
                builder2.setMessage(hint);
                builder2.create().show();
            }
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error Hint Level:"+ e.getMessage());
        }
    }
    public void Home (View view)
    {
        ButtonSound(1);
        startActivity(new Intent(context,Start.class));
    }
    public void Submit(View v) {
        try {
            ButtonSound(1);
            if (t1.getText().toString().equals(String.valueOf(Answer)))
                CorrectAnswer();
            else
                WrongAnswer();
        }
        catch (Exception e)
        {
            Log.i("Ahmed","Error Gold  Level:"+ e.getMessage());
        }
    }

    private void WrongAnswer() {
        Vibrate();
        ButtonSound(3);
        t.setText("WRONG ANSWER!!");
        t1.setText("");
    }

    private void CorrectAnswer() {
        ButtonSound(2);
        t.setText("Congratulations Correct Answer");
        t1.setText("");
        if (Passed==0)
        {
            Gold = Gold + 2;
            Passed=1;
            Coins.setText(String.valueOf(Gold));
        }
        Update("Pass");
    }
    void Update (String  m)
    {
        if (m.equals("Hint"))
        {
            getSharedPreferences(contract.Shared_Preferences,Context.MODE_PRIVATE).edit().putInt(contract.Gold,Gold).apply();
            ContentValues contentValues=new ContentValues();
            contentValues.put(contract.Column_Hint_Status,hint_statue);
            getContentResolver().update(ContentUris.withAppendedId(contract.Row_URI,Level),contentValues,null,null);

        }
        else if (m.equals("Pass") & Level!=10)
            {
                getSharedPreferences(contract.Shared_Preferences,Context.MODE_PRIVATE).edit().putInt(contract.Gold,Gold).apply();
                if(Level>=Last_Level)
                    getSharedPreferences(contract.Shared_Preferences, Context.MODE_PRIVATE).edit().putInt(contract.Last_Level, Level + 1).apply();
                ContentValues contentValues = new ContentValues();
                ContentValues contentValues2 = new ContentValues();
                contentValues.put(contract.Column_Opened, 1);
                contentValues2.put(contract.Column_Passed,Passed);
                getContentResolver().update(ContentUris.withAppendedId(contract.Row_URI,Level),contentValues2,null,null);
                getContentResolver().update(ContentUris.withAppendedId(contract.Row_URI, Level + 1), contentValues, null, null);
                BuilderCreate("Passed");
            }
        else {
            getSharedPreferences(contract.Shared_Preferences,Context.MODE_PRIVATE).edit().putInt(contract.Gold,Gold).apply();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(contract.Column_Passed,Passed);
            getContentResolver().update(ContentUris.withAppendedId(contract.Row_URI,Level),contentValues2,null,null);
            BuilderCreate("Finish");
        }
    }


    public void Remove(View v){

        ButtonSound(1);
        if (!t1.getText().toString().isEmpty()){
            int n=t1.getText().toString().length();
            CharSequence s3;
            s3=t1.getText().subSequence(0,n-1);
            String s4= (String) s3;
            t1.setText(s4);}
    }
    public void Click0(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b0.getText();
            t1.setText(s2);
        }
    }
    public void Click1(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b1.getText();
            t1.setText(s2);
        }
    }
    public void Click2(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b2.getText();
            t1.setText(s2);
        }
    }
    public void Click3(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b3.getText();
            t1.setText(s2);
        }
    }
    public void Click4(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b4.getText();
            t1.setText(s2);
        }
    }
    public void Click5(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b5.getText();
            t1.setText(s2);
        }
    }
    public void Click6(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b6.getText();
            t1.setText(s2);
        }
    }
    public void Click7(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b7.getText();
            t1.setText(s2);
        }
    }
    public void Click8(View v){

        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b8.getText();
            t1.setText(s2);
        }
    }
    public void Click9(View v){
        ButtonSound(1);
        if(t1.getText().toString().length()<14) {
            s = t1.getText().toString();
            s2 = s + b9.getText();
            t1.setText(s2);
        }
    }

    void ButtonSound (int h)
    {
        if (Sound) {
            Log.i("Ahmed","Play Sound");
            final MediaPlayer mediaPlayer;
            if (h == 1)
                mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);
            else if (h == 2)
                mediaPlayer = MediaPlayer.create(this, R.raw.correctanswer);
            else
                mediaPlayer = MediaPlayer.create(this, R.raw.wronganswer);
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
    void Vibrate ()
    {
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(400);
    }
    public void BuilderButtonHint(View view)
    {
        ButtonSound(1);
        if (Gold < 5)
            Toast.makeText(context, "Sorry you don't have enough Coins to get the hint", Toast.LENGTH_LONG).show();
        else {
            Gold = Gold - 5;
            hint_statue = 1;
            Coins.setText(String.valueOf(Gold));
            Update("Hint");
            try {
                if(alertDialog != null && alertDialog.isShowing()){
                    alertDialog.dismiss();
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                builder2.setTitle("Hint");
                builder2.setMessage(hint);
                builder2.create().show();
            }
            catch (Exception e)
            {
                Log.i("Ahmed","Error Hint Builder:"+ e.getMessage());
            }
        }

    }
    public void BuilderButtonPass (View view )
    {
        ButtonSound(1);
        i=new Intent(context,Level.class);
        i.putExtra(contract.Intent_Row,Level+1);
        startActivity(i);

    }
    public void BuilderButton2 (View view)
    {
        ButtonSound(1);
       startActivity(new Intent(context,Levels.class));
    }
    public void BuilderButtonDismiss(View view){
        if(alertDialog != null && alertDialog.isShowing()){
            ButtonSound(1);
            alertDialog.dismiss();
            alertDialog=null;
        }
    }

    void BuilderCreate (String m)
    {

        Log.i("Ahmed","BuilderCreateBegin");
        if (m.equals("Hint"))
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            LayoutInflater inflater =this.getLayoutInflater();
            View view2=inflater.inflate(R.layout.builder,null);
            builder.setView(view2);
            builder.create();
            alertDialog=builder.show();
        }
        else if (m.equals("Passed"))
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            LayoutInflater inflater =this.getLayoutInflater();
            View view2=inflater.inflate(R.layout.builder2,null);
            builder.setView(view2);
            builder.create().show();
        }
        else if (m.equals("Finish"))
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            LayoutInflater inflater =this.getLayoutInflater();
            View view2=inflater.inflate(R.layout.builder3,null);
            builder.setView(view2);
            builder.create();
            alertDialog=builder.show();
        }
        Log.i("Ahmed","BuilderCreateEnd");
    }

    @Override
    public void onBackPressed() {
        ButtonSound(1);
        super.onBackPressed();
        i=new Intent(this,Levels.class);
        startActivity(i);
    }

    @SuppressLint("StaticFieldLeak")
    private class AsyncTask extends android.os.AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            getData();
            return null;
        }


        @Override
        protected void onPostExecute(Void eVoid) {
            Mode();
        }
    }
}
