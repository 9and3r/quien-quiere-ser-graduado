package com.aorbegozo005.quienquieresergraduado;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ander on 2015/03/16.
 */
public class DatuBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DATUBASE_GRADUATED";
    private static final int DATABASE_VERSION = 1;

    public DatuBase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE \"main\".\"Pregunta\" (\"galdera\" VARCHAR PRIMARY KEY  NOT NULL , \"erantzuna_zuzena\" VARCHAR, \"erantzuna_1\" VARCHAR, \"erantzuna_2\" VARCHAR, \"erantzuna_3\" VARCHAR, \"bloke\" INTEGER)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Beitiaren izena zein da?','Joseba','Ander','Beitia','Jose',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getQuestion(int maila){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("Select * from Pregunta where bloke = "+ maila +";",null);
    }

}
