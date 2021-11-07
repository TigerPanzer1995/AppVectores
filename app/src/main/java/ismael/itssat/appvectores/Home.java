package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    //inicializamos las variables
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //asignamos las variables del view
        drawerLayout = findViewById(R.id.drawer_layout);
    }//fin del metodo oncreate

    public void ClickMenu(View view){
        //abrimos el drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //abrimos drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //cerramos el logo
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //cerramos drawer layout
        //evaluamos el estado del drawer
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //cuando el drawer está abierto
            //cerramos el drawer

            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }//fin de metodo closeDrawer

    public void ClickHome(View view){
        //carga de nuevo el activity
        recreate();

    }

    public void ClickDashboard(View view){
        //rederricionamos el activity seleccionado
        redirectActivity(this,Formulario.class);
    }

    public void ClickAboutUs(View view){
        redirectActivity(this,CorteDia.class);
    }
    public void ClickLogOut(View view){
        //cerramos la app
        logout(this);
    }

    public static void logout(Activity activity) {
        //inicializamos un cuadro de dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //colocamos el titulo
        builder.setTitle("Logout");
        //enviamos mensaje
        builder.setMessage("¿Estás seguro de salir de la aplicación?");
        //respuesta positiva
        builder.setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finalizamos el activity
                activity.finishAffinity();
                //salimos de la app
                System.exit(0);

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

    }//fin del metodo logout

    public static void redirectActivity(Activity activity, Class aClass) {
        //inicializamos el intent
        Intent intent = new Intent(activity,aClass);
        //enviamos el flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //empezamos el activity
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}//fin de la clase Home