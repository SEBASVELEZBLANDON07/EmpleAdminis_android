package com.blandonvelezsebastian.empreadminis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.Fragment;


import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


//import com.blandonvelezsebastian.empreadminis.databinding.ActivityMainBinding;
import com.blandonvelezsebastian.empreadminis.fragments.fragmen_inicio_sesion;
import com.blandonvelezsebastian.empreadminis.fragments.fragmen_pueba_animacion;
import com.blandonvelezsebastian.empreadminis.fragments.fragmentotrapantalla;
import com.blandonvelezsebastian.empreadminis.fragments.mainfragment;
import com.google.android.material.navigation.NavigationView;





public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public void mostrarMenu() {
        // Mostrar el menú
        navigationView.setVisibility(View.VISIBLE);
    }



    //variables para abrir desplegar
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //variables para cargar pantalla principal

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // abrir desplegar
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawermain);
        navigationView = findViewById(R.id.navegacion);




        //estableser seleccion al dar click en la navegacion
        navigationView.setNavigationItemSelectedListener(this);




        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerSlideAnimationEnabled(true);
        actionBarDrawerToggle.syncState();

        String sebas = null;

        // Ocultar el menú de navegación al inicio de la actividad
        navigationView.setVisibility(View.GONE);

        //cargar la prantalla principal inicio

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedor, new fragmen_inicio_sesion());
      //  fragmentTransaction.add(R.id.contenedor, new mainfragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //para serrar automanticamente el despliegue
        drawerLayout.closeDrawer(GravityCompat.START);

        //abrir dependiendo qué opción se selecciona
        Fragment newFragment = null;

        if (menuItem.getItemId() == R.id.inicio) {
            newFragment = new mainfragment();
        } else if (menuItem.getItemId() == R.id.otra_pantalla) {
            newFragment = new fragmentotrapantalla();
        } else if (menuItem.getItemId() == R.id.pruebas_dos) {
            newFragment = new fragmen_pueba_animacion();
        }

        if (newFragment != null) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, newFragment);
            fragmentTransaction.commit();
        }

/*
        //abrir dependiendo que opsion se seleciona
        if (menuItem.getItemId()== R.id.inicio){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, new mainfragment());
            fragmentTransaction.commit();
        }

        //cuando se presiona en el menu otra pantalla
        if (menuItem.getItemId()== R.id.otra_pantalla){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, new fragmentotrapantalla());
            fragmentTransaction.commit();
        }
/*
        //para cuando se presiona iniciar sesion
        if(menuItem.getItemId()==R.id.inicio_secion){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, new fragmen_inicio_sesion());
            fragmentTransaction.commit();
        }


        //para cuando se presiona iniciar sesion
        if(menuItem.getItemId()==R.id.pruebas_dos){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, new fragmen_pueba_animacion());
            fragmentTransaction.commit();
        }


 */

        return false;
    }






}