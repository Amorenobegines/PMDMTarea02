package com.example.moreno_begines_alicia_pmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moreno_begines_alicia_pmdm02.databinding.ItemCardviewBinding;
import java.util.ArrayList;

/**
 * Adaptador para el RecyclerView que muestra una lista de elementos. Hereda de {@link RecyclerView.Adapter}
 *
 * Este adaptador se encarga de crear y enlazar los ViewHolders para los elementos
 * {@link Item} en el RecyclerView. También maneja el evento de clic en los elementos
 * de la lista.
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    /**
     * Lista de elementos a mostrar.
     */
    private final ArrayList<Item> item;

    /**
     * Contexto de la aplicación.
     */
    private final Context context;

    /**
     * Constructor del adaptador.
     *
     * @param item Lista de elementos a mostrar.
     * @param context Contexto de la aplicación.
     */
    public ItemRecyclerViewAdapter(ArrayList<Item> item, Context context){
        this.item = item;
        this.context = context;
    }

    /**
     * Crea un nuevo ViewHolder.
     *
     * Este método se llama cuando el RecyclerView necesita un nuevo ViewHolder
     * para mostrar un elemento.
     *
     * @param parent El ViewGroup al que se añadirá el nuevo ViewHolder.
     * @param viewType El tipo de vista del nuevo ViewHolder.
     * @return El nuevo ViewHolder creado.
     */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardviewBinding binding = ItemCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ItemViewHolder(binding);
    }

    /**
     * Enlaza los datos de un elemento al ViewHolder.
     *
     * Este método se llama cuando el RecyclerView necesita actualizar la vista
     * de un elemento existente.
     *
     * @param holder El ViewHolder que se actualizará.
     * @param position La posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item currentItem = this.item.get(position);
        holder.bind(currentItem);
        //Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentItem, view));
    }

    /**
     * Obtiene el número total de elementos en la lista.
     *
     * @return El número total de elementos.
     */
    @Override
    public int getItemCount() {
        return item.size();
    }

    /**
     * Maneja el evento de clic en un elemento.
     *
     * Este método se llama cuando se hace clic en un elemento de la lista.
     * Llama a la función `itemClicked` de la actividad principal, pasando
     * el elemento que se ha pulsado.
     *
     * @param currentItem El elemento que se ha pulsado.
     * @param view La vista del elemento que se ha pulsado.
     */
    private void itemClicked(Item currentItem, View view) {
        // Llama a la función itemClicked de MainActivity, pasando la vista
        ((MainActivity) context).itemClicked(currentItem, view);
    }
}
