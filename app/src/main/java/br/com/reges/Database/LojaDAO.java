package br.com.reges.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.reges.modelo.Loja;

/**
 * Created by matheus on 10/10/2016.
 */
public class LojaDAO extends SQLiteOpenHelper {


    private static final String DBNAME = "LojasDB";
    private static final int version = 1;
    private static final String TABLE = "Lojas";

    public LojaDAO(Context context) {
        super(context, DBNAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE + " ("
                + "id INTEGER PRIMARY KEY, "
                + "nome TEXT UNIQUE NOT NULL, "
                + "email TEXT, "
                + "site TEXT, "
                + "nota DECIMAL"
                + ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABLE;
        db.execSQL(sql);
        onCreate(db);

    }

    public void Insert(Loja loja) {

        ContentValues cv = new ContentValues();

        cv.put("nome", loja.getNome());
        cv.put("site", loja.getSite());
        cv.put("email", loja.getEmail());
        cv.put("nota", loja.getNota());

        getReadableDatabase().insert(TABLE, null, cv);

    }

}
