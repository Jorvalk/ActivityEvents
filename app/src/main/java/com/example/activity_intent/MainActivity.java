package com.example.activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Aplicar el padding necesario para ajustar la visualización con el sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, windowInsets) -> {
            Insets systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return windowInsets;  // Asegúrate de que el return esté aquí y no haya código después
        });

        // Referencias a los elementos del layout
        ImageView imageView = findViewById(R.id.imageView);
        EditText editText = findViewById(R.id.editText);
        Button buttonSend = findViewById(R.id.buttonSend);

        // Configurar el listener del botón
        buttonSend.setOnClickListener(view -> {
            // Obtener el texto ingresado por el usuario
            String userInput = editText.getText().toString();

            // Si la imagen es un recurso local, obtenemos su ID
            int imageResource = R.drawable.bonfire; // Reemplaza con tu imagen

            // Crear el Intent para pasar al segundo Activity
            Intent intent = new Intent(MainActivity.this, GetActivity.class);
            intent.putExtra("userText", userInput); // Enviar el texto ingresado
            intent.putExtra("imageResource", imageResource); // Enviar el ID de la imagen

            // Iniciar el segundo Activity
            startActivity(intent);
        });
    }
}