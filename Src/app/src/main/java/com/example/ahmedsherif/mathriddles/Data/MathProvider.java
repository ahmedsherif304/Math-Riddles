package com.example.ahmedsherif.mathriddles.Data;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class MathProvider extends ContentProvider {
    private static final int Row = 3;
    private static final int Table = 5;
    private static final UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    DataBaseHelper db;
    SQLiteDatabase sql;
    int match;

    static {
        uriMatcher.addURI(contract.Authority,contract.Table_Name,Table);
        uriMatcher.addURI(contract.Authority,contract.Table_Name+"/*",Row);

    }

    @Override
    public boolean onCreate() {
        db=new DataBaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        match=uriMatcher.match(uri);
        sql=db.getReadableDatabase();
        switch (match) {
            case Table:
                Log.i("Ahmed","Table query");
                return sql.query(contract.Table_Name,projection,null,null,null,null,null);
            case Row:
                long id = ContentUris.parseId(uri);
                Log.i("Ahmed","Query " + id);
                selection = contract.Column_ID + "=?";
                selectionArgs= new String [] {String.valueOf(id)};
                return sql.query(contract.Table_Name,projection,selection,selectionArgs,null,null,null);
                default:
                    throw new IllegalArgumentException("Cannot query UNKNOWN URI "+uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        match=uriMatcher.match(uri);
        sql=db.getWritableDatabase();
        switch (match) {
            case Table:
                Log.i("Ahmed","insert Table");
                return ContentUris.withAppendedId(uri,sql.insert(contract.Table_Name,null,values));
                default:
                    throw new IllegalArgumentException("Cannot insert UNKNOWN URI "+uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        match=uriMatcher.match(uri);
        sql=db.getWritableDatabase();
        switch (match)
        {
            case Table:
                Log.i("Ahmed"," delete Table");
                int h=sql.delete(contract.Table_Name,null,null);
                db.Insert_OneTime(sql);
                return  h;
            default:
                throw new IllegalArgumentException("Cannot delete UNKNOWN URI "+uri);

        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        match=uriMatcher.match(uri);
        sql=db.getWritableDatabase();
        switch (match) {
            case Row:
                Long id =ContentUris.parseId(uri);
                Log.i("Ahmed","Update " +  String.valueOf(id));
                selection= contract.Column_ID+"=?";
                selectionArgs=new String[] {String.valueOf(id)};
                return sql.update(contract.Table_Name,values,selection,selectionArgs);

                default:
                    throw new IllegalArgumentException("Cannot Update UNKNOWN URI "+uri);

        }
    }
}
