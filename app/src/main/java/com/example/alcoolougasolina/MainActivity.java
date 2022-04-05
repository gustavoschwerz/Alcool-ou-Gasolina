package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextAlcool, editTextGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAlcool      = findViewById(R.id.textAlcool);
        editTextGasolina    = findViewById(R.id.textGasolina);
        textResultado       = findViewById(R.id.textResultado);

    }


    public void calcular(View view) {

        // recuperar valores digitados
        String precoAlcool = editTextAlcool.getText().toString();
        String precoGasolina = editTextGasolina.getText().toString();

        // validar campos digitados
        Boolean resultado = validarCampos(precoAlcool, precoGasolina);

        if (resultado) {

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double ideal = valorAlcool / valorGasolina;
            textResultado.setText(ideal.toString());


            if (ideal < 0.7) {
                textResultado.setText("Use Álcool!");
            } else {
                textResultado.setText("Use Gasolina!");
            }
        }

        else{
            textResultado.setText("Digite o preço dos dois");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("") || pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;

    }



}