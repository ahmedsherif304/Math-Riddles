package com.example.ahmedsherif.mathriddles.Data;

import android.net.Uri;
import android.provider.BaseColumns;

public class contract implements BaseColumns {
    public final static String Shared_Preferences="MySharedPreferences";
    public final static String Gold="Gold";
    public final static int Gold_begin=10;
    public final static String Mode="Mode";
    public final static String DarkMode="DarkMode";
    public final static String WhiteMode="WhiteMode";
    public final static String Sound = "Sound";
    public final static String Last_Level = "Last_Level";

    public final static String Table_Name = "Riddles";
    public final static String Column_ID = "_id";
    public final static String Column_Opened = "opened";
    public final static String Column_Question_Dark = "question_d";
    public final static String Column_Question_White = "question_w";
    public final static String Column_Hint_Status = "hint_status";
    public final static String Column_Hint = "hint";
    public final static String Column_Answer = "answer";
    public final static String Column_Passed ="passed";

    public final static String Authority = "com.example.ahmedsherif.mathriddles";
    public final static Uri Table_URI =Uri.parse("content://"+Authority+"/"+ Table_Name);
    public final static Uri Row_URI =Uri.parse( "content://"+Authority+"/"+ Table_Name+"/");

    public final static String Intent_Row = "ROW";


}
