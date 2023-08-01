package com.example.helloworldapplication;

import static java.util.Collections.reverse;

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
    TextView lblCantidadVocales;
    TextView lblCantidadConsonantes;
    TextView lblCantidadSignos;
    TextView lblPalabrasInvertidas;
    TextView lblCadenaInvertida;

    String voc="";
    String cons="";
    String sign="";

    int n_voc=0;
    int n_cons=0;
    int n_sign=0;

    String invertida;



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
            lblCantidadVocales = findViewById(R.id.lblCantidadVocales);
            lblCantidadConsonantes = findViewById(R.id.lblCantidadConsonantes);
            lblCantidadSignos = findViewById(R.id.lblCantidadSignos);
            lblPalabrasInvertidas = findViewById(R.id.lblPalabrasInvertidas);
            lblCadenaInvertida = findViewById(R.id.lblCadenaInvertida);




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

                contadorLetras();
                lblCantidadVocales.setText("No. de vocales en la cadena: "+n_voc+" ("+voc+")");
                lblCantidadConsonantes.setText("No. de consonantes en la cadena:  "+n_cons+" ("+cons+")");
                lblCantidadSignos.setText("No. de signos en la cadena: "+n_sign+" ("+sign+")");

                //cadena invertida

                cadenaInvertida();
                lblCadenaInvertida.setText("Cadena invertida: "+invertida);

                //palabra invertida
                String palabraInvertida ="";
                for (int x = 0; x< palabras.length; x++){
                  String palabra = palabras[x];
                  String invertida = cadenaInvertidaGenerico(palabra);
                  palabraInvertida+= invertida +" ";
                }
                lblPalabrasInvertidas.setText("Palabras invertidas: "+palabraInvertida);

            }
        }
    };

    public void contadorLetras(){
        char[] signos = {',' , ';' , '.' , ':' , '¿' , '?' , '¡' , '!' , '-' , '_' , '/' , '&', '@' , '$'};
        char[] vocales = {'a','e','i','o','u'};
        char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','ñ','p','q','r','s','t','v','w','x','y','z'};

        String entrada = txtinfostring.getText().toString().trim().toLowerCase();

        for (int i=0; i<entrada.length(); i++){
            for (int a=0; a<vocales.length; a++){
                if (entrada.charAt(i) == vocales[a]){
                    n_voc++;
                    voc+=entrada.charAt(i);
                }
            }
            for (int a=0; a<consonantes.length; a++){
                if (entrada.charAt(i) == consonantes[a]){
                    n_cons++;
                    cons+=entrada.charAt(i);
                }
            }
            for (int a=0; a<signos.length; a++){
                if (entrada.charAt(i) == signos[a]) {
                    n_sign++;
                    sign += entrada.charAt(i);
                }

            }
        }
    }

    public void cadenaInvertida(){
        String cadena = txtinfostring.getText().toString().trim();

        StringBuilder stringBuilder = new StringBuilder(cadena);
        invertida = stringBuilder.reverse().toString();
    }

    public String cadenaInvertidaGenerico(String cadenaOriginal){

        StringBuilder stringBuilder = new StringBuilder(cadenaOriginal);

        return stringBuilder.reverse().toString();
    }

    public View.OnClickListener OnClickbtnBorrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtinfostring.setText("");
            lblcadenaingresada.setText("");
            lblcantidadpalabras.setText("");
            lblcantidadcaracteres.setText("");
            lblCantidadVocales.setText("");
            lblCantidadConsonantes.setText("");
            lblCantidadSignos.setText("");
            lblCadenaInvertida.setText("");

        }
    };

}
