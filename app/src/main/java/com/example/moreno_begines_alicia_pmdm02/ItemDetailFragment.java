package com.example.moreno_begines_alicia_pmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.moreno_begines_alicia_pmdm02.databinding.ItemDetailFragmentBinding;

/**
 * Fragmento que muestra los detalles de un elemento. Esta clase hereda de {@link Fragment}
 *
 * Este fragmento se encarga de mostrar la información detallada de un elemento
 * {@link Item} que se ha seleccionado en la lista. Recibe los datos del elemento
 * a través de argumentos y los muestra en la vista.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * Binding para acceder a los elementos de la vista del fragmento.
     */
    private ItemDetailFragmentBinding binding;

    /**
     * Crea la vista del fragmento.
     *
     * Infla el layout del fragmento y lo devuelve.
     *
     * @param inflater El LayoutInflater para inflar la vista.
     * @param container El ViewGroup que contiene la vista.
     * @param savedInstanceState El estado guardado del fragmento (si existe).
     * @return La vista del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = ItemDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se llama después de que se ha creado la vista del fragmento.
     *
     * Obtiene los datos del elemento a través de argumentos y los muestra en la vista.
     *
     * @param view La vista del fragmento.
     * @param savedInstanceState El estado guardado del fragmento (si existe).
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String hability = getArguments().getString("hability");

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.hability.setText(hability);
        }
    }

    /**
     * Se llama cuando el fragmento se inicia.
     * Cambia el título del ActionBar al título de "Detalles".
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.details);
        }
    }
}   // Fin class