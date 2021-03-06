package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import ismael.itssat.appvectores.basededatos.SqlOpenHelper;

public class Formulario extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btnFormularioCampo, btnRegistrar;
    private EditText txtLocalidad, txtMunicipio, txtEstado, txtJuris, txtCiclo,
    txtJfeBrig, txtJfeSec, txtEstrategia, txtCveElemento, txtLarvicida;


    private SqlOpenHelper myDBINICIO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //asignamos la variable
        drawerLayout= findViewById(R.id.drawer_layout);
        btnFormularioCampo = findViewById(R.id.xmlbtnformulariocampo);

        btnRegistrar = findViewById(R.id.xmlbtninidia);
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

        myDBINICIO = new SqlOpenHelper(this);




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



    //*******************************************************************************************************************
    //** VALIDACI??N DE CAMPOS DE TEXTO NO VAYAN VACIOS ****************************************************************++
    //*******************************************************************************************************************

    public void validaBtnRegistrar(View view){
        if(txtLocalidad.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if(txtMunicipio.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtEstado.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtJuris.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtCiclo.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtJfeBrig.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtJfeSec.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if(txtEstrategia.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if (txtCveElemento.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else if(txtLarvicida.getText().toString().equals("")){
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
        }else {
            Boolean validaFormularioInicioDia = myDBINICIO.insertaDatosFormularioInicioDia(txtLocalidad.getText().toString(),txtMunicipio.getText().toString()
            ,txtEstado.getText().toString(),txtJuris.getText().toString(),txtCiclo.getText().toString(),txtJfeBrig.getText().toString(),txtJfeSec.getText().toString()
            ,txtEstrategia.getText().toString(),txtCveElemento.getText().toString(), txtLarvicida.getText().toString());

            if (validaFormularioInicioDia==false){
                Toast.makeText(this, "Error al guardar los datos, reintente de nuevo", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Datos almacenado con ??xito", Toast.LENGTH_SHORT).show();
                btnRegistrar.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Ya puede comenzar el formulario", Toast.LENGTH_SHORT).show();
                btnFormularioCampo.setVisibility(View.VISIBLE);
            }

            //aqu?? ir?? el botono a la base de datos
        }
    }//fin del metodo validaBtnRegistrar



    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }
} //fin de la clase Formulario.java