package ismael.itssat.appvectores.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SqlOpenHelper extends SQLiteOpenHelper {

    public static final String DBBAME = "appvectores.db";
    public static final int VERSIONDB = 1;
    //public static final String CURSOS_COLUMNA_FECHA = "fecha";

    public SqlOpenHelper(Context context) {
        super(context, DBBAME, null, VERSIONDB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username Text primary key not null, password Text,fecha Text)");
        db.execSQL("create table formulario(id_formulario INTEGER PRIMARY KEY AUTOINCREMENT, vectorEnTurno Text ,localidad Text, municipio Text, estado Text, ciclo Text, juris Text, cveJefBgda Text, cveJfeSec Text, estrategia Text, cveEle Text, larvicida Text, FOREIGN KEY(vectorEnTurno) References users(username) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists formulario");

    }

    public boolean insertData (String username, String password){
        SQLiteDatabase appVectoresDB = this.getWritableDatabase();//creamos la bbdd y la habilitamos para que se pueda escribir en ella
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = appVectoresDB.insert("users",null,contentValues);

        if (result ==-1){
            return false;
        }else{
            return true;
        }
    }//fin del metodo insertData


    public boolean checkUsername(String username){
        SQLiteDatabase appVecDB = this.getWritableDatabase();
        Cursor cursor = appVecDB.rawQuery("select *from users where username = ?",new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }{
            return false;
        }
    }//fin del metodo checkUsername

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase appVecDB = this.getWritableDatabase();
        Cursor cursor = appVecDB.rawQuery("select *from users where username = ? and password =? ",new String[]{username, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }

    }//fin del metodo checkUsernamePassword

    public void insertaDatosIni(Context context){

        String usuario11 = "1";
        String password11 = "FERIS12345";
        //String usuario2 = "2";
        //String password2 ="CELSO12345";

        SQLiteDatabase appVecDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", usuario11);
        contentValues.put("password", password11);
        //contentValues.put("username", usuario2);
        //contentValues.put("password", password2);
        contentValues.put("fecha", getDate());
        long result = appVecDB.insert("users",null,contentValues);
        if (result >0){
            Toast.makeText(context, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Base de datos arrancó con éxito ", Toast.LENGTH_SHORT).show();
        }

    }//fin del metodo insertaDatosIni

    private String getDate() {             // se vería así: miercoles 26/09/2018 05:30 p.m.
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy hh:mm  a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean insertaDatosFormularioInicioDia(String localidad, String municipio, String estado, String juris, String ciclo
    , String cveJfeBgda, String cveJfeSec, String estrategia, String cveElemento, String larvicida){

        SQLiteDatabase appVectoresDB = this.getWritableDatabase();//creamos la bbdd y la habilitamos para que se pueda escribir en ella
        ContentValues contentValuesInicioDia = new ContentValues();
        contentValuesInicioDia.put("localidad", localidad);
        contentValuesInicioDia.put("municipio", municipio);
        contentValuesInicioDia.put("estado", estado);
        contentValuesInicioDia.put("juris", juris);
        contentValuesInicioDia.put("ciclo", ciclo);
        contentValuesInicioDia.put("cveJefBgda", cveJfeBgda);
        contentValuesInicioDia.put("cveJfeSec",cveJfeSec);
        contentValuesInicioDia.put("estrategia",estrategia);
        contentValuesInicioDia.put("cveEle",cveElemento);
        contentValuesInicioDia.put("larvicida", larvicida);
        long resultInicio = appVectoresDB.insert("formulario", null, contentValuesInicioDia);

        if (resultInicio ==-1){
            return false;
        }else{
            return true;
        }


    }//fin del metodo insertaDatosFormularioInicioDia


}
