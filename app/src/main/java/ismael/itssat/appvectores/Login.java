package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;

public class Login extends AppCompatActivity {

    private static EditText textRFC, textPass;
    private static Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textRFC = findViewById(R.id.txtrfc);
        textPass = findViewById(R.id.txtpass);
        btnLogin = findViewById(R.id.btnlog);




    }//fin del metodo oncreate

    public void ingresardatos(View view){
        String caprfc, cappass;
        caprfc = textRFC.getText().toString();
        cappass = textPass.getText().toString();

        if(caprfc.equals("") && cappass.equals("")){
            Toast.makeText(this, "Debe ingresar su CLAVE y/o RFC", Toast.LENGTH_SHORT).show();
        }else if(caprfc.equals("1") && cappass.equals("1")){
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "CLAVE y/o RFC incoreectos", Toast.LENGTH_SHORT).show();
        }

    }
}//fin de la clase