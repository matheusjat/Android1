package br.com.reges.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    public List<Loja> list() {


        String sql = "SELECT * FROM " + TABLE + ";";
        List<Loja> list = new ArrayList<Loja>();

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Loja loja = new Loja();

            loja.setID(cursor.getInt(cursor.getColumnIndex("id")));
            loja.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            loja.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            loja.setSite(cursor.getString(cursor.getColumnIndex("site")));
            loja.setNota(cursor.getFloat(cursor.getColumnIndex("nota")));

            list.add(loja);

        }

        return list;
    }

    public void update(Loja loja){

        ContentValues cv = new ContentValues();

        cv.put("nome", loja.getNome());
        cv.put("site", loja.getSite());
        cv.put("email", loja.getEmail());
        cv.put("nota", loja.getNota());

        getReadableDatabase().update(TABLE,cv, "id=?",
                new String[]{String.valueOf(loja.getID())});

    }

    public void delete(Loja loja){

        getReadableDatabase().delete(TABLE, "id=?",
                new String[]{String.valueOf(loja.getID())});

    }



}
