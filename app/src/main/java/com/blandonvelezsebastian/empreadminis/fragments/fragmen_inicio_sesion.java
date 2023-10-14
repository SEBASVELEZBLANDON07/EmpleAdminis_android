package com.blandonvelezsebastian.empreadminis.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blandonvelezsebastian.empreadminis.MainActivity;
import com.blandonvelezsebastian.empreadminis.R;


import android.widget.Button;
import android.widget.Toast;

public class fragmen_inicio_sesion extends Fragment {

    public fragmen_inicio_sesion() {
        // Constructor vacío requerido.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.inicio_sesion,container,false);
        View view = inflater.inflate(R.layout.inicio_sesion,container,false);

        // Ocultar el menú en este fragmento
        setHasOptionsMenu(false);

        // Obtener una referencia al botón de inicio de sesión
        Button inicioSesionButton = view.findViewById(R.id.iniciar_secion);

        // Obtener una referencia al botón de inicio de sesión
        Button registroButton = view.findViewById(R.id.registro);

        inicioSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplazar el fragmento actual con mainfragment
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, new mainfragment())
                        .commit();

                // Mostrar el menú
                ((MainActivity) requireActivity()).mostrarMenu();

                // Mostrar un mensaje con Toast
                Toast.makeText(requireContext(), "inicio de sesion con exito", Toast.LENGTH_SHORT).show();
            }
        });

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplazar el fragmento actual con mainfragment
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, new fragmen_registro_empresa())
                        .commit();

                // Mostrar el menú
               // ((MainActivity) requireActivity()).mostrarMenu();
            }
        });


        return view;
    }
}
