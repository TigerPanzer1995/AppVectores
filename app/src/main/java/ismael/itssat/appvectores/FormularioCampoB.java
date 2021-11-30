package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class FormularioCampoB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_campo_b);
    }
    public void volverFlecha2 (View view){
        onBackPressed();
    }
}