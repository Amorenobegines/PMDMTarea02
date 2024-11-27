package com.example.moreno_begines_alicia_pmdm02;

/**
 * Representa un elemento o ítem con una imagen, nombre, descripción y habilidad.
 *
 * Esta clase encapsula la información de un elemento que se puede mostrar en una lista o
 * en cualquier otra parte de la aplicación.
 */
public class Item {

    /**
     * ID del recurso de imagen del elemento.
     */
    private final int image;

    /**
     * Nombre del elemento.
     */
    private final String name;

    /**
     * Descripción del elemento.
     */
    private final String description;

    /**
     * Habilidad del elemento.
     */
    private final String hability;

    /**
     * Constructor de la clase Item.
     *
     * @param image ID del recurso de imagen del elemento.
     * @param name Nombre del elemento.
     * @param description Descripción del elemento.
     * @param hability Habilidad del elemento.
     */
    public Item(int image, String name, String description, String hability) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.hability = hability;
    }

    /**
     * Obtiene el ID del recurso de imagen del elemento.
     * @return El ID del recurso de imagen.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene el nombre del elemento.
     * @return El nombre del elemento.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del elemento.
     * @return La descripción del elemento.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene la habilidad del elemento.
     * @return La habilidad del elemento.
     */
    public String getHability() {
        return hability;
    }
}   // Fin class