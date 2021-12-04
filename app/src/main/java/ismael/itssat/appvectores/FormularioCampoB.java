package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormularioCampoB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_campo_b);
    }
    public void volverFlecha2 (View view){
        //onBackPressed();

    }

    public  void backActividaddos(View view) {
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
                Intent intent = new Intent(FormularioCampoB.this, Home.class);
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