package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormularioCampo extends AppCompatActivity {

    private EditText tvdom,tvcvesector, cvemanzana, tvCL,tvSL, tvNo,
            tvnoTratados, tvcontrolado, tvElim, tvTratados,
            tvRevisados, tvDepPos, tvLarvUt, tvVolAaT, tvNumHab;  //variables que capturan los datos ingresados

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
}