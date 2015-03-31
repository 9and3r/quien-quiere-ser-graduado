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

        // Nivel 1
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cómo se declara una variable en ADA?','a: Integer:=0;','Integer a = 0;','int a:=0;','Integer a:=0;',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cómo es 12 en binario?','1100','1110','1101','1010',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Los humanos tenemos electrones?','Sí','No','Sólo las plantas','No. Tenemos protones',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Es (p^(p -> q) -> q)  una tautologia?','Sí','No','No siempre','Sólo si p=F',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es el límite de: lim (sin(x)-x)/x^3 cuando x -> 0?','-1/6','0','1/2','2/5',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es la integral de x/(x+1)^3 entre 0 e infinito?','1/2','1/3','2','1/4',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Beitiaren izena zein da?','Joseba','Ander','Beitia','Jose',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Beitiaren izena zein da?','Joseba','Ander','Beitia','Jose',1)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getQuestion(int maila){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("Select * from Pregunta where bloke = "+ maila +";",null);
    }

}
