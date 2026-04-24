package com.pocket.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.graphics.Color;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout Principal (Fundo Preto Minecraft)
        RelativeLayout root = new RelativeLayout(this);
        root.setBackgroundColor(Color.parseColor("#1e1e1e"));

        // Seletor de Versões
        Spinner versionSpinner = new Spinner(this);
        String[] versions = {"Alpha 0.1.0", "Pocket Edition 0.14.0", "Bedrock 1.20", "Bedrock 1.21 (Atual)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, versions);
        versionSpinner.setAdapter(adapter);
        
        LinearLayout topMenu = new LinearLayout(this);
        topMenu.addView(versionSpinner);
        root.addView(topMenu);

        // Botão Jogar (Centralizado)
        Button btnPlay = new Button(this);
        btnPlay.setText("JOGAR");
        btnPlay.setBackgroundColor(Color.parseColor("#3c8527"));
        btnPlay.setTextColor(Color.WHITE);
        
        RelativeLayout.LayoutParams playParams = new RelativeLayout.LayoutParams(400, 150);
        playParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        root.addView(btnPlay, playParams);

        // Simulação de Controles (D-Pad)
        TextView dpad = new TextView(this);
        dpad.setText("  ▲  \n◀ ● ▶\n  ▼  ");
        dpad.setTextColor(Color.WHITE);
        dpad.setTextSize(30);
        
        RelativeLayout.LayoutParams dpadParams = new RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dpadParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dpadParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dpadParams.setMargins(50, 0, 0, 50);
        root.addView(dpad, dpadParams);

        btnPlay.setOnClickListener(v -> {
            String selected = versionSpinner.getSelectedItem().toString();
            Toast.makeText(this, "Iniciando " + selected + " via Native Wrapper...", Toast.LENGTH_LONG).show();
        });

        setContentView(root);
    }
                             }
