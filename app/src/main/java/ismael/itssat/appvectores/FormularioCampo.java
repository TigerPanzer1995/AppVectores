package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FormularioCampo extends AppCompatActivity {

    private EditText tvdom,tvcvesector, cvemanzana, tvCL,tvSL, tvNo,
            tvnoTratados, tvcontrolado, tvElim, tvTratados,
            tvRevisados, tvDepPos, tvLarvUt, tvVolAaT, tvNumHab;  //variables que capturan los datos ingresados

    private Spinner spinnerStatus ;

    private TextView tvContadorFormulario ; //guarda el número de formulario



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_campo);

        //contador inicalidado en 1
        tvContadorFormulario = findViewById(R.id.xmlContadorFC);

        tvdom = findViewById(R.id.xmlediDomFC);
        tvcvesector = findViewById(R.id.xmlediCveSectorFC);
        cvemanzana = findViewById(R.id.xmledicveManzFC);
        tvCL = findViewById(R.id.xmltxtC_L);
        tvSL = findViewById(R.id.xmltxtS_L);
        tvNo = findViewById(R.id.xmltxtNOFC);
        tvnoTratados = findViewById(R.id.xmltxtNotrtFC);
        tvcontrolado = findViewById(R.id.xmltxtCtrlFC);
        tvElim = findViewById(R.id.xmltxtElimFC);
        tvTratados = findViewById(R.id.xmltvtratadosfc);
        tvRevisados = findViewById(R.id.xmltxtReviisados);
        tvDepPos = findViewById(R.id.xmltxtdepposFC);
        tvLarvUt = findViewById(R.id.xmltxtLarvuFC);
        tvVolAaT = findViewById(R.id.xmltxtvatFC);
        tvNumHab = findViewById(R.id.xmltvnumhab);


        spinnerStatus = findViewById(R.id.spinnerStatusXML);

        String [] opcionesEspacios = {"Espacio público","Lote baldio"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,opcionesEspacios);
        spinnerStatus.setAdapter(adapter);


    }


    public void volverFlecha (View view){
        onBackPressed();
    }
    public void limpiarformulariocampo (View view){
        tvdom.setText("");
        tvcvesector.setText("");
        cvemanzana.setText("");
        tvCL.setText("");
        tvSL.setText("");
        tvNo.setText("");
        tvnoTratados.setText("");
        tvcontrolado.setText("");
        tvElim.setText("");
        tvTratados.setText("");
        tvRevisados.setText("");
        tvDepPos.setText("");
        tvLarvUt.setText("");
        tvVolAaT.setText("");
        tvNumHab.setText("");
    }
    public void contForm (View view){
        Intent intent = new Intent(this,FormularioCampoB.class);
        startActivity(intent);
        finish();
    }

    public  void backActividad(View view) {
        //construimos el alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //colocamos el título del cuadro
        builder.setTitle("Regresar al inicio");
        //enviamos mensaje
        builder.setMessage("¿Está seguro que desea regresar al inicio?, no se guardaran cambios");
        //respuesta positiva
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //iniciamos la secuencia de cambio de la activity
                Intent intent = new Intent(FormularioCampo.this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //disminuimos el cuadro de dialogo
                dialog.dismiss();
            }
        });

        builder.show();


        }//fin del metodo back...

    }

