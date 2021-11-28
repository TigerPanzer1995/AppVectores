package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnFormularioCampo;
    private EditText txtLocalidad, txtMunicipio, txtEstado, txtJuris, txtCiclo,
    txtJfeBrig, txtJfeSec, txtEstrategia, txtCveElemento, txtLarvicida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //asignamos la variable
        drawerLayout= findViewById(R.id.drawer_layout);
        btnFormularioCampo = findViewById(R.id.xmlbtnformulariocampo);

        txtLocalidad = findViewById(R.id.xmltxtLocalidad);
        txtMunicipio = findViewById(R.id.xmltxtMunicipio);
        txtEstado = findViewById(R.id.xmltxtVeracruz);
        txtJuris = findViewById(R.id.xmltxtJurisdicion);
        txtCiclo = findViewById(R.id.xmltxtCiclo);
        txtJfeBrig = findViewById(R.id.xmltxtCveJefeBrigada);
        txtJfeSec = findViewById(R.id.xmltxtcveJefeSector);
        txtEstrategia = findViewById(R.id.xmltxtEstrategia);
        txtCveElemento = findViewById(R.id.xmltxtClaveElemento);
        txtLarvicida = findViewById(R.id.xmltxtLarvicida);
    }//fin del metodo oncreate

    public void ClickMenu(View view){
        Home.openDrawer(drawerLayout);
    }

    public void ClickLogo( View view){
        Home.closeDrawer(drawerLayout);
    }

    public void ClickHome( View view){
        Home.redirectActivity(this, Home.class);
    }

    public void  ClickDashboard( View view){
        recreate();
    }

    public void ClickAboutUs(View view){
        Home.redirectActivity(this,CorteDia.class);
    }

    public void ClickLogOut(View view){
        //cerramos la app
        Home.logout(this);
    }

    private void ClickFormularioCampo(Activity activity, Class aclass){
        Intent intent = new Intent(activity, aclass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void accionFormulari(View view){
        ClickFormularioCampo(this, FormularioCampo.class);
    }



    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }
} //fin de la clase Formulario.java