package com.example.activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get);

        // Aplicar el padding necesario para ajustar la visualización con el sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, windowInsets) -> {
            Insets insetsSystemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(insetsSystemBars.left, insetsSystemBars.top, insetsSystemBars.right, insetsSystemBars.bottom);
            return windowInsets;  // El return debe estar al final y no debe haber código después dentro del bloque
        });

        // Referencias a los elementos del layout
        ImageView receivedImage = findViewById(R.id.receivedImage);
        TextView receivedText = findViewById(R.id.receivedText);
        Button buttonBack = findViewById(R.id.buttonBack);

        // Obtener los datos del Intent
        Intent intent = getIntent();
        String userText = intent.getStringExtra("userText");
        int imageResource = intent.getIntExtra("imageResource", 0);

        // Mostrar los datos en el layout
        receivedText.setText(userText);
        receivedImage.setImageResource(imageResource);

        // Configurar el botón "Regresar" para volver al MainActivity
        buttonBack.setOnClickListener(view -> {
            finish();  // Finaliza el GetActivity y vuelve al MainActivity
        });
    }
}