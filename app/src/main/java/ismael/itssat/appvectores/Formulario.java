package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Formulario extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //asignamos la variable
        drawerLayout= findViewById(R.id.drawer_layout);
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

    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }
}