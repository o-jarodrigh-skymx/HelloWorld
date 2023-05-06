package com.example.helloworldapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText txtinfostring;
    TextView lblcadenaingresada;
    TextView lblcantidadpalabras;
    TextView lblcantidadcaracteres;
    TextView lblcantidadnumeros;


    Button btnSiguiente;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

    }

    private void initializeComponents (){
        try {
            txtinfostring = findViewById(R.id.txtinfostring);
            lblcadenaingresada = findViewById(R.id.lblcadenaingresada);
            lblcantidadpalabras = findViewById(R.id.lblcantidadpalabras);
            lblcantidadcaracteres = findViewById(R.id.lblcantidadcaracteres);
            lblcantidadnumeros = findViewById(R.id.lblcantidadnumeros);


            btnSiguiente = findViewById(R.id.btnSiguiente);
            btnBorrar = findViewById(R.id.btnBorrar);

            btnSiguiente.setOnClickListener(OnClickbtnSiguiente);
            btnBorrar.setOnClickListener(OnClickbtnBorrar);

        }catch (Exception e) {
        }
    }

    public View.OnClickListener OnClickbtnSiguiente = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            System.out.println("Click");
            if (txtinfostring.getText().toString().trim().length() == 0) {
                lblcadenaingresada.setText("Cadena Vacia");
                return;
            }else {
                lblcadenaingresada.setText("La cadena ingresada : " + txtinfostring.getText());

                String valor = txtinfostring.getText().toString().trim();
                System.out.println(valor);
                String[] palabras = valor.split(" ");
                lblcantidadpalabras.setText("No. de palabras en la cadena: " + palabras.length);
                lblcantidadcaracteres.setText("No. de caracteres en la cadena: " + valor.replace(" ", "").length());
                int contadorNumeros = 0;
                int i;
                for (i = 0; i < palabras.length; i++) {
                    if (Character.isDigit(Integer.parseInt(palabras[i]))) {
                        ++contadorNumeros;
                    }

                }
                Resultado resultado = new Resultado();
                resultado.contadorNumeros = contadorNumeros;

                lblcantidadnumeros.setText("Cantidad de numeros en la cadena: " + resultado.contadorNumeros );



            }

        }
    };

    class Resultado {
        public int contadorNumeros;
    }

    public View.OnClickListener OnClickbtnBorrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtinfostring.setText("");
            lblcadenaingresada.setText("");
            lblcantidadpalabras.setText("");
            lblcantidadcaracteres.setText("");
            lblcantidadnumeros.setText("");
        }
    };

}
