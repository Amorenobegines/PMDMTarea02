package com.example.moreno_begines_alicia_pmdm02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

/**
 * Actividad que permite al usuario cambiar el idioma de la aplicación. Hereda de AppCompatActivity.
 *
 * Esta actividad presenta un Switch que el usuario puede usar para cambiar
 * entre dos idiomas (inglés y español). El estado del Switch se guarda en
 * SharedPreferences para que se mantenga entre sesiones.
 */
public class SwitchActivity extends AppCompatActivity {

    /**
     * Switch para cambiar el idioma.
     */
    private Switch languageSwitch;

    /**
     * Se llama cuando se crea la actividad.
     *
     * Inicializa la actividad, configura el Switch y maneja el evento de cambio
     * de idioma. También configura un botón para cancelar los cambios y volver
     * a la actividad principal.
     *
     * @param savedInstanceState El estado guardado de la actividad .
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch); // Asocia el XML del Switch

        // Referencia al Switch del layout
        languageSwitch = findViewById(R.id.languageSwitch);

        // Recuperar el estado del Switch desde SharedPreferences
        SharedPreferences prefs = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("switch_state", false); // false es el valor por defecto

        // Establecer el estado del Switch
        languageSwitch.setChecked(switchState);

        // Lógica de cambiar el idioma al activar el Switch
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardar el nuevo estado
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("switch_state", isChecked);
            editor.apply();

            // Cambiar idioma
            if (isChecked) {
                setLocale("es");
                Toast.makeText(SwitchActivity.this, R.string.men_cambio_idioma, Toast.LENGTH_SHORT).show();
            } else {
                setLocale("en");
                Toast.makeText(SwitchActivity.this, R.string.men_cambio_idioma, Toast.LENGTH_SHORT).show();
            }
        });

        // Botón de cancelar
        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(v -> {
            // Regresar a MainActivity sin cambios
            Intent intent = new Intent(SwitchActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Establece el idioma de la aplicación.
     *
     * Este método configura el idioma de la aplicación y reinicia la actividad
     * principal para que los cambios surtan efecto.
     *
     * @param idioma El código del idioma ( "es" para español, "en" para inglés).
     */
    private void setLocale(String idioma) {
        // Configurar el idioma de la aplicación
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);

        getBaseContext().createConfigurationContext(config);

        // Opción de refuerzo
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        // Reinicia la actividad principal para que los cambios surtan efecto
        Intent intent = new Intent(SwitchActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finaliza la actividad actual
    }
}   // Fin class
