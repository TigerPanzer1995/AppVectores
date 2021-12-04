package ismael.itssat.appvectores.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlOpenHelper extends SQLiteOpenHelper {

    public static final String DBBAME = "appvectores.db";
    public static final int VERSIONDB = 1;

    public SqlOpenHelper(Context context) {
        super(context, DBBAME, null, VERSIONDB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
