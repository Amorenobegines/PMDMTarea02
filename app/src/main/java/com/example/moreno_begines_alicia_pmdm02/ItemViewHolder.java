package com.example.moreno_begines_alicia_pmdm02;

import androidx.recyclerview.widget.RecyclerView;
import com.example.moreno_begines_alicia_pmdm02.databinding.ItemCardviewBinding;

/**
 * ViewHolder para un elemento de la lista en un RecyclerView. Hereda de {@link RecyclerView.ViewHolder}
 *
 * Esta clase se encarga de mostrar la información de un elemento {@link Item}
 * en una vista de tipo CardView dentro del RecyclerView.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    /**
     * Binding para acceder a los elementos de la vista del CardView.
     */
    private final ItemCardviewBinding binding;

    /**
     * Constructor del ItemViewHolder.
     * @param binding El binding para la vista del CardView.
     */
    public ItemViewHolder(ItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Enlaza los datos del elemento a la vista.
     *
     * Este método se encarga de actualizar los elementos de la vista con la
     * información del elemento {@link Item} proporcionado.
     *
     * @param item El elemento a mostrar en la vista.
     */
    public void bind(Item item) {
        binding.image.setImageResource(item.getImage()); // Carga la imagen desde el recurso
        binding.name.setText(item.getName()); // Carga el nombre desde el recurso
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}  // Fin class