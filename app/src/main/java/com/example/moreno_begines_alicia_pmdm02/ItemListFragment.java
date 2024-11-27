package com.example.moreno_begines_alicia_pmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.moreno_begines_alicia_pmdm02.databinding.ItemListFragmentBinding;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

/**
 * Fragmento que muestra una lista de elementos. Esta clase hereda de {@link Fragment}
 *
 * Este fragmento se encarga de mostrar una lista de elementos {@link Item}
 * en un RecyclerView. Los elementos se cargan desde una fuente de datos
 * (en este caso, se definen en el método {@link #initItem()}) y se muestran
 * utilizando un adaptador {@link ItemRecyclerViewAdapter}.
 */
public class ItemListFragment extends Fragment {

    /**
     * Binding para acceder a los elementos de la vista del fragmento.
     */
    private ItemListFragmentBinding binding;

    /**
     * Lista de elementos a mostrar.
     */
    private ArrayList<Item> item;

    /**
     * Adaptador para el RecyclerView.
     */
    private ItemRecyclerViewAdapter adapter;

    /**
     * Crea la vista del fragmento.
     *
     * Infla el layout del fragmento utilizando el binding y lo devuelve.
     *
     * @param inflater El LayoutInflater para inflar la vista.
     * @param container El ViewGroup que contiene la vista.
     * @param savedInstanceState El estado guardado del fragmento (si existe).
     * @return La vista del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = ItemListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se llama después de que se ha creado la vista del fragmento.
     *
     * Inicializa la lista de elementos, configura el RecyclerView y muestra
     * un Snackbar de bienvenida.
     *
     * @param view La vista del fragmento.
     * @param savedInstanceState El estado guardado del fragmento (si existe).
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        initItem(); // Cargar los personajes

        // Configurar el RecyclerView
        adapter = new ItemRecyclerViewAdapter(item, getActivity());
        binding.itemRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.itemRecyclerview.setAdapter(adapter);

        // Mostrar el Snackbar de bienvenida
        Snackbar.make(view, R.string.snackbar_men, Snackbar.LENGTH_SHORT).show();

    }

    /**
     * Inicializa la lista de elementos.
     *
     * Este método se encarga de cargar los elementos que se mostrarán en el RecyclerView.
     */
    private void initItem() {
        item = new ArrayList<Item>();

        item.add(new Item(R.drawable.mario, getString(R.string.mario_name), getString(R.string.mario_desc), getString(R.string.mario_hab)));
        item.add(new Item(R.drawable.luigi,  getString(R.string.luigi_name), getString(R.string.luigi_desc), getString(R.string.luigi_hab)));
        item.add(new Item(R.drawable.peach,  getString(R.string.peach_name), getString(R.string.peach_desc), getString(R.string.peach_hab)));
        item.add(new Item(R.drawable.toad,  getString(R.string.toad_name), getString(R.string.toad_desc), getString(R.string.toad_hab)));
        item.add(new Item(R.drawable.yoshi,  getString(R.string.yoshi_name), getString(R.string.yoshi_desc), getString(R.string.yoshi_hab)));
        item.add(new Item(R.drawable.daisy,  getString(R.string.daisy_name), getString(R.string.daisy_desc), getString(R.string.daisy_hab)));
        item.add(new Item(R.drawable.rosalina,  getString(R.string.rosalina), getString(R.string.rosalina_desc), getString(R.string.rosalina_hab)));
        item.add(new Item(R.drawable.bowser,  getString(R.string.bowser_name), getString(R.string.bowser_desc), getString(R.string.bowser_hab)));
        item.add(new Item(R.drawable.wario,  getString(R.string.wario_name), getString(R.string.wario_desc), getString(R.string.wario_hab)));
        item.add(new Item(R.drawable.waluigi,  getString(R.string.waluigi_name), getString(R.string.waluigi_desc), getString(R.string.waluigi_hab)));
        item.add(new Item(R.drawable.donkey,  getString(R.string.donkey_name), getString(R.string.donkey_desc), getString(R.string.donkey_hab)));
        item.add(new Item(R.drawable.boo,  getString(R.string.boo_name), getString(R.string.boo_desc), getString(R.string.boo_hab)));
        item.add(new Item(R.drawable.diddy,  getString(R.string.diddy_name), getString(R.string.diddy_desc), getString(R.string.diddy_hab)));
        item.add(new Item(R.drawable.goombas,  getString(R.string.goombas_name), getString(R.string.goombas_dresc), getString(R.string.goombas_hab)));
    }

    /**
     * Se llama cuando el fragmento se inicia.
     *
     * Cambia el título del ActionBar al título de "Lista".
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.list);
        }
    }
}