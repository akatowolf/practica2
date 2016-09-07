package com.akatowolf.area;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button aCalcular;
    RadioGroup aG;
    EditText aRadio, aLado, aAltura, aBase;
    TextView aResultado;
    RadioButton aCirculo, aTriangulo, aRectangulo, aCuadro;
    double pi=3.141592653589793;
    String area;

    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aCalcular = (Button) findViewById(R.id.aCalcular);
        aRadio = (EditText) findViewById(R.id.aRadio);
        aLado = (EditText) findViewById(R.id.aLado);
        aAltura = (EditText) findViewById(R.id.aAltura);
        aBase = (EditText) findViewById(R.id.aBase);
        aCirculo = (RadioButton) findViewById(R.id.aCirculo);
        aRectangulo= (RadioButton) findViewById(R.id.aRectangulo);
        aCuadro = (RadioButton) findViewById(R.id.aCuadro);
        aTriangulo = (RadioButton) findViewById(R.id.aTriangulo);
        aResultado = (TextView)  findViewById(R.id.aResultado);
        aCalcular.setOnClickListener(this);
        RadioGroup aG = (RadioGroup) findViewById(R.id.aG);
        int checkid=aG.getCheckedRadioButtonId();
        aG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup arg0, int id){
                if(aCirculo.getId()==id){
                    aRadio.setVisibility(View.VISIBLE);
                    aAltura.setVisibility(View.GONE);
                    aBase.setVisibility(View.GONE);
                    aLado.setVisibility(View.GONE);
                }else if(aRectangulo.getId()==id){
                    aRadio.setVisibility(View.GONE);
                    aAltura.setVisibility(View.VISIBLE);
                    aBase.setVisibility(View.VISIBLE);
                    aLado.setVisibility(View.GONE);
                }else if(aTriangulo.getId()==id){
                    aRadio.setVisibility(View.GONE);
                    aAltura.setVisibility(View.VISIBLE);
                    aBase.setVisibility(View.VISIBLE);
                    aLado.setVisibility(View.GONE);
                }else if(aCuadro.getId()==id){
                    aRadio.setVisibility(View.GONE);
                    aAltura.setVisibility(View.GONE);
                    aBase.setVisibility(View.GONE);
                    aLado.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    public int estado() {
        int i;
        if (aCirculo.isChecked()) {
            i = 1;
        } else if (aTriangulo.isChecked()) {
            i = 2;
        } else if (aRectangulo.isChecked()) {
            i = 3;
        } else if (aCuadro.isChecked()) {
            i = 4;
        } else {
            i = 0;
        }
        return i;
    }

    public void onClick(View view) {
        x=estado();
        int lado, radio, base, altura;
        double area1=0;
        if(x!=0){

            switch (x) {
                case 1:
                    radio=Integer.parseInt(aRadio.getText().toString());
                    if (aRadio.getText().toString().trim().length() > 0){
                        area1 = pi * radio*radio;
                    area = String.valueOf(area1);
                    aResultado.setText(area);

            }else{ aResultado.setText("");}
                    break;
                case 2:

                    altura=Integer.parseInt(aAltura.getText().toString());
                    base=Integer.parseInt(aBase.getText().toString());

                    if (aAltura.getText().toString().trim().length()>0 && aBase.getText().toString().trim().length()>0){
                        area1=0.5*altura*base;
                        area=String.valueOf(area1);
                        aResultado.setText(area);
                    }else{ aResultado.setText("");}
                    break;
                case 3:


                    altura=Integer.parseInt(aAltura.getText().toString());
                    base=Integer.parseInt(aBase.getText().toString());

                    if (aAltura.getText().toString().trim().length()>0 && aBase.getText().toString().trim().length()>0){
                        area1=altura*base;
                        area=String.valueOf(area1);
                        aResultado.setText(area);
                    }else{ aResultado.setText("");}
                    break;
                case 4:

                    lado=Integer.parseInt(aLado.getText().toString());
                    if (aLado.getText().toString().trim().length()>0){
                        area1=lado*lado;
                        area=String.valueOf(area1);
                        aResultado.setText(area);
                    }else{ aResultado.setText("");}
                    break;
            }

        }

    }
}
