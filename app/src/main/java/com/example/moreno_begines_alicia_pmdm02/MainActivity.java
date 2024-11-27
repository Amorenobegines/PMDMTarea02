package com.example.moreno_begines_alicia_pmdm02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.moreno_begines_alicia_pmdm02.databinding.ActivityMainBinding;
import java.util.Locale;

/**
 * Actividad principal de la aplicación que hereda de {@link AppCompatActivity}.
 *
 * Esta actividad se encarga de mostrar la pantalla principal de la aplicación,
 * que contiene un Navigation Drawer y un NavHostFragment para la navegación
 * entre los diferentes fragmentos. También maneja el evento de clic en los
 * elementos de la lista y la navegación al fragmento de detalles.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Controlador de navegación para el NavHostFragment.
     */
    private NavController navController;
    /**
     * Se llama cuando se crea la actividad.
     *
     * Inicializa la actividad, configura el Navigation Drawer y el NavHostFragment,
     * y carga el idioma guardado en las preferencias.
     *
     * @param savedInstanceState El estado guardado de la actividad .
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargar el idioma guardado antes de establecer el contenido
        SharedPreferences prefs = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("switch_state", false);
        String idioma = switchState ? "es" : "en";
        locale(idioma);

        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    /**
     * Establece el idioma de la aplicación.
     *
     * @param idioma El código del idioma ("es" para español, "en" para inglés).
     */
    private void locale(String idioma) {
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Configuration configuracion = getResources().getConfiguration();
        configuracion.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuracion, getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * Crea el menú de opciones de la actividad.
     *
     * @param menu El menú de opciones.
     * @return true si se ha creado el menú, false en caso contrario.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja el evento de selección de un elemento del menú de opciones.
     *
     * @param item El elemento del menú que se ha seleccionado.
     * @return true si se ha manejado el evento, false en caso contrario.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_acerca_de) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.menu_acerca_de) // Título del Dialog
                    .setMessage(R.string.mensaje_acerca) // Mensaje
                    .setIcon(R.drawable.acerca_de)
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                        // Acción al hacer clic en "OK"
                        dialog.dismiss(); // Cerrar el diálogo
                    })
                    .show();
            return true;
        }
        if (item.getItemId() == R.id.nav_home) {
            navController.navigate(R.id.itemListFragment);
            return true;
        }
        if (item.getItemId() == R.id.action_language) {
            Intent intent = new Intent(this, SwitchActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Maneja el evento de clic en un elemento de la lista.
     *
     * Este método se llama cuando se hace clic en un elemento de la lista
     * en el fragmento {@link ItemListFragment}. Crea un Bundle con los datos
     * del elemento y navega al fragmento {@link ItemDetailFragment} para
     * mostrar los detalles.
     *
     * @param item El elemento que se ha pulsado.
     * @param view La vista del elemento que se ha pulsado.
     */
    public void itemClicked(Item item, View view) {
        // Crear un Bundle para pasar los datos al PersonajesDetailFragment
        Bundle bundle = new Bundle();

        // Convertir los recursos int a String antes de añadirlos al Bundle
        bundle.putString("name", item.getName());
        bundle.putString("hability", item.getHability());
        bundle.putInt("image", item.getImage()); // Pasa la imagen del personaje
        bundle.putString("description", item.getDescription());

        Toast.makeText(this, getString(R.string.mensaje_usu) + " " + item.getName(), Toast.LENGTH_SHORT).show();
        // Navegar al ItemDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.itemDetailFragment, bundle);
    }

    /**
     * Maneja el evento de navegación hacia arriba.
     *
     * @return true si se ha manejado el evento, false en caso contrario.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

}   // Fin class
