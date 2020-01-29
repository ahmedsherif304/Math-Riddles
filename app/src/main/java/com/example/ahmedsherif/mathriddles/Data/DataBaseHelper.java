package com.example.ahmedsherif.mathriddles.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ahmedsherif.mathriddles.R;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DataBase_Name="Math3.db";
    private static final String Create_Method =
            "CREATE TABLE " + contract.Table_Name + " ( "
            + contract.Column_ID + " INTEGER , " + contract.Column_Opened + " INTEGER , " +
            contract.Column_Passed + " INTEGER , " + contract.Column_Question_Dark + " INTEGER ,"
            + contract.Column_Question_White + " INTEGER , " +
            contract.Column_Hint_Status + " INTEGER , " + contract.Column_Hint + " TEXT , "+
            contract.Column_Answer + " INTEGER )";
    private static final String Drop_Table = "DROP TABLE IF EXISTS "+ contract.Table_Name;
    private static  int version = 1;

    public DataBaseHelper(Context context) {
        super(context, DataBase_Name, null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Method);
        Insert_OneTime(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Drop_Table);
        version=newVersion;
        onCreate(db);
    }
    protected void Insert_OneTime(SQLiteDatabase db) {

        //ist Row
        ContentValues contentValues = new ContentValues();
        contentValues.put(contract.Column_ID, 1);
        contentValues.put(contract.Column_Opened, 1);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level1dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level1white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "Powers of 2");
        contentValues.put(contract.Column_Answer, 16);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //2nd Row
        contentValues.put(contract.Column_ID, 2);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level2dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level2white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "75/3=25\n125/5=25");
        contentValues.put(contract.Column_Answer, 250);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //3rd Row
        contentValues.put(contract.Column_ID, 3);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_3_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_3_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "every shape has a value\nRectangle = 10 \n Triangle = 30 \n Circle = 70");
        contentValues.put(contract.Column_Answer, 80);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //4th Row
        contentValues.put(contract.Column_ID, 4);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_4_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_4_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "(3+3)(1+5)=36\n(1+1)(8+3)=22");
        contentValues.put(contract.Column_Answer, 24);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //5th Row
        contentValues.put(contract.Column_ID, 5);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_5_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_5_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "(15*12)/(15-12)=60\n(8*6)/(8-6)=24");
        contentValues.put(contract.Column_Answer, 20);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //6th Row
        contentValues.put(contract.Column_ID, 6);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_6_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_6_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "Every Character has a number from 1 to 26");
        contentValues.put(contract.Column_Answer, 42);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //7th Row
        contentValues.put(contract.Column_ID, 7);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_7_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_7_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "20-17=3\n25-20=5\n32-25=7");
        contentValues.put(contract.Column_Answer, 41);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //8th Row
        contentValues.put(contract.Column_ID, 8);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_8_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_8_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "(18+7)/5=5\n(3+9)/2=6");
        contentValues.put(contract.Column_Answer, 3);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //9th Row
        contentValues.put(contract.Column_ID, 9);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_9_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_9_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "All the numbers have a factor of '9'");
        contentValues.put(contract.Column_Answer, 9);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
        //10th Row
        contentValues.put(contract.Column_ID, 10);
        contentValues.put(contract.Column_Opened, 0);
        contentValues.put(contract.Column_Question_Dark, R.drawable.level_10_dark);
        contentValues.put(contract.Column_Question_White, R.drawable.level_10_white);
        contentValues.put(contract.Column_Hint_Status, 0);
        contentValues.put(contract.Column_Hint, "5!=120\n4!=24");
        contentValues.put(contract.Column_Answer, 6);
        contentValues.put(contract.Column_Passed, 0);
        db.insert(contract.Table_Name,null, contentValues);
    }
}
