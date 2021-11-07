package ismael.itssat.appvectores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class CorteDia extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corte_dia);
        drawerLayout = findViewById(R.id.drawer_layout);
    }//fin del oncreate

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
        Home.redirectActivity(this,Formulario.class);
    }

    public void ClickAboutUs(View view){
        recreate();
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