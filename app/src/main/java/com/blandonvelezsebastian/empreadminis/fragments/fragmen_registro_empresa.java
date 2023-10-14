package com.blandonvelezsebastian.empreadminis.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blandonvelezsebastian.empreadminis.MainActivity;
import com.blandonvelezsebastian.empreadminis.R;

public class fragmen_registro_empresa extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registrar_perfil_em,container,false);

        // Ocultar el menú en este fragmento
        setHasOptionsMenu(false);

        // Obtener una referencia al botón de inicio de sesión
        Button crearperfilButton = view.findViewById(R.id.crear_perfil);
        // Obtener una referencia al botón de inicio de sesión
        Button iniciarsesionButton = view.findViewById(R.id.inicio_sesion_R);

        crearperfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplazar el fragmento actual con mainfragment
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, new fragmen_inicio_sesion())
                        .commit();

                // Mostrar el menú
               // ((MainActivity) requireActivity()).mostrarMenu();

                // Mostrar un mensaje con Toast
                Toast.makeText(requireContext(), "Has creado un perfil, inicia sesion", Toast.LENGTH_SHORT).show();
            }
        });

        iniciarsesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplazar el fragmento actual con mainfragment
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, new fragmen_inicio_sesion())
                        .commit();

                // Mostrar el menú
                //((MainActivity) requireActivity()).mostrarMenu();
            }
        });


        return view;
    }
}
