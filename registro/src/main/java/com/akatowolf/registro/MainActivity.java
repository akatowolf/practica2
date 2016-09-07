package com.akatowolf.registro;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String nombre, usuario, contrasena, correo, rcontrasena, sexo, pais, fecha, ide;
    String hobbie [] = new String[4];
    boolean check=false;
    EditText qLoggin, qContrasena, qrContrasena, qMail;
    Button qAceptar;
    Spinner qSpinner;
    CheckBox qFutbol, qVideojuegos, qMusica, qArte;
    RadioButton qFemenino, qMasculino;
    TextView qMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qLoggin = (EditText) findViewById(R.id.qLoggin);
        qContrasena = (EditText) findViewById(R.id.qContrasena);
        qrContrasena = (EditText) findViewById(R.id.qrContrasena);
        qMail = (EditText) findViewById(R.id.qMail);
        qAceptar = (Button) findViewById(R.id.qAceptar);
        qSpinner = (Spinner) findViewById(R.id.qSpinner);
        qFutbol = (CheckBox) findViewById(R.id.qFutbol);
        qVideojuegos = (CheckBox) findViewById(R.id.qVideojuegos);
        qMostrar = (TextView) findViewById(R.id.qMostrar);
        qArte = (CheckBox) findViewById(R.id.qArte);
        qMusica = (CheckBox) findViewById(R.id.qMusica);



    qAceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                nombre=qLoggin.getText().toString();
                contrasena=qContrasena.getText().toString();
                rcontrasena=qrContrasena.getText().toString();
                correo=qMail.getText().toString();
                if(qFemenino.isChecked()){
                    sexo="Mujer";
                }else if(qMasculino.isChecked()){
                    sexo="hombre";}
                if(qLoggin.getText().toString().trim().length()>0&&qContrasena.getText().toString().trim().length()>0 &&qrContrasena.getText().toString().trim().length()>0){
                    if(check=true&&pais.trim().length()>0&&qContrasena.equals(qrContrasena)){}
                    qMostrar.setText(nombre + contrasena + correo + sexo + pais + hobbie[1] + hobbie[2] + hobbie[3] + hobbie[4]);
                }else
                    qMostrar.setText("Le faltan casillas por llenar o ha ingresado un dato incorrecto");

            }

        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    public void onCheckboxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();
        check=true;
        switch (view.getId()) {
            case R.id.qFutbol:
            if (checked){
                hobbie[1]="Futbol";

            }else hobbie[1]="";
                break;
            case R.id.qVideojuegos:
                if(checked) {
                    hobbie[2]= "Video_Juegos";
                }else hobbie[2]="";
                break;
            case R.id.qMusica:
                if(checked){
                    hobbie[3]="Música";
                }else hobbie[3]="";
                break;
            case R.id.qArte:
                if(checked){
                    hobbie[4]="Arte";
                }hobbie[4]="";
        }

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        pais = qSpinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



