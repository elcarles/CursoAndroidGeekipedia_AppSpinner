package com.example.carlos.cursoandroidgeekipedia_appspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_valor1 ,et_valor2 ;
    private TextView tv_resultado;
    private Spinner spinner1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_valor1 = findViewById(R.id.et_valor1);
        et_valor2 = findViewById(R.id.et_valor2);
        tv_resultado = findViewById(R.id.tv_resultado);
        spinner1 = findViewById(R.id.spinner);

        String [] opciones = {"sumar", "restar", "multiplicar", "dividir"};

        ArrayAdapter <String> aa = new ArrayAdapter<String>(this, R.layout.spinner_item_geekipedia, opciones);
        spinner1.setAdapter(aa);

    }

    public void calcular(View view) {

        String valor1_s = et_valor1.getText().toString();
        String valor2_s = et_valor2.getText().toString();


        int valor1_int = Integer.parseInt(valor1_s);
        int valor2_int = Integer.parseInt(valor2_s);
        int res = 0;

        String seleccion = spinner1.getSelectedItem().toString();
        //hacer las operaciones.

        if (seleccion.equals("sumar")) {
            res = valor1_int + valor2_int;
            String resultado = String.valueOf(res);
            tv_resultado.setText(resultado);
        } else if (seleccion.equals("restar")) {
            res = valor1_int - valor2_int;
            String resultado = String.valueOf(res);
            tv_resultado.setText(resultado);
        } else if (seleccion.equals("multiplicar")) {
            res = valor1_int * valor2_int;
            String resultado = String.valueOf(res);
            tv_resultado.setText(resultado);
        } else if (seleccion.equals("dividir")) {
            if (valor2_int != 0) {
                res = valor1_int - valor2_int;
                String resultado = String.valueOf(res);
                tv_resultado.setText(resultado);
            } else {
                Toast.makeText(getApplicationContext(), "NO puede dividir entre 0  ", Toast.LENGTH_LONG).show();
            }
        }

    }





}
