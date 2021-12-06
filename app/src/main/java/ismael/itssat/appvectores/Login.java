package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;

import ismael.itssat.appvectores.basededatos.SqlOpenHelper;

public class Login extends AppCompatActivity {

    private EditText textRFC, textPass;
    private Button btnLogin;
    private SqlOpenHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textRFC = findViewById(R.id.txtrfc);
        textPass = findViewById(R.id.txtpass);
        btnLogin = findViewById(R.id.btnlog);
        myDB = new SqlOpenHelper(this);

        myDB.insertaDatosIni(this);


    }//fin del metodo oncreate

    public void ingresardatos(View view){
        String caprfc, cappass;
        caprfc = textRFC.getText().toString();
        cappass = textPass.getText().toString();

        if(caprfc.equals("") && cappass.equals("")){
            Toast.makeText(this, "Debe ingresar su CLAVE y/o RFC", Toast.LENGTH_SHORT).show();
        }else{

            Boolean validaUser = myDB.checkUsernamePassword(caprfc,cappass);
            if (validaUser ==false){
                Toast.makeText(this, "Usuario y/o contraseña no existen", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }

        }

    }//fin del metodo ingresardatos

}//fin de la clase