package com.akatowolf.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText cNUM1, cNUM2;
    TextView cResultado;
    Button cCALCULAR;
    RadioButton cSUMA, cRESTA, cMULTIPLICACION, cDIVISION;
    int n,m,r;
    boolean z=false, s=false;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cNUM1 = (EditText) findViewById(R.id.cNUM1);
        cNUM2 = (EditText) findViewById(R.id.cNUM2);
        cResultado = (TextView) findViewById(R.id.cResultado);
        cSUMA = (RadioButton) findViewById(R.id.cSUMA);
        cRESTA = (RadioButton) findViewById(R.id.cRESTA);
        cMULTIPLICACION = (RadioButton) findViewById(R.id.cMULTIPLICACION);
        cDIVISION = (RadioButton) findViewById(R.id.cDIVISION);
        cCALCULAR = (Button) findViewById(R.id.cCALCULAR);

        cCALCULAR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean check1=false, check2=false;
                if(cNUM1.getText().toString().trim().length()>0){
                    check1=true;
                }
                if(cNUM2.getText().toString().trim().length()>0){
                    check2=true;
                }
                cNUM1.requestFocus();
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                n = Integer.parseInt(cNUM1.getText().toString());
                z = true;
                cNUM2.requestFocus();
                m = Integer.parseInt(cNUM2.getText().toString());
                s = true;

                    if (cSUMA.isChecked() && check1==true && check2==true) {
                        r = n + m;
                        result = String.valueOf(r);
                        cResultado.setText(result);
                        cRESTA.setChecked(false);
                        cMULTIPLICACION.setChecked(false);
                        cDIVISION.setChecked(false);

                    } else if (cRESTA.isChecked()&& check1==true && check2==true) {
                        r = n - m;
                        result = String.valueOf(r);
                        cResultado.setText(result);
                        cSUMA.setChecked(false);
                        cMULTIPLICACION.setChecked(false);
                        cDIVISION.setChecked(false);
                    } else if (cMULTIPLICACION.isChecked()&& check1==true && check2==true) {
                        r = n * m;
                        result = String.valueOf(r);
                        cResultado.setText(result);
                        cSUMA.setChecked(false);
                        cRESTA.setChecked(false);
                        cDIVISION.setChecked(false);
                    } else if (cDIVISION.isChecked()&& check1==true && check2==true) {
                        cSUMA.setChecked(false);
                        cRESTA.setChecked(false);
                        cMULTIPLICACION.setChecked(false);
                        if (m != 0) {
                            r = n / m;
                            result = String.valueOf(r);
                            cResultado.setText(result);
                        } else
                            cResultado.setText("Math error");
                    }

            }
        }
        );
    }
}
