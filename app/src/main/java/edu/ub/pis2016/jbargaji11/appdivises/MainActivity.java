package edu.ub.pis2016.jbargaji11.appdivises;

import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.btnCanvi);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView textEuro = (TextView) findViewById(R.id.txtEuro);
                TextView textDolar = (TextView) findViewById(R.id.txtDolar);
                EditText entTipusCanvi = (EditText) findViewById(R.id.entTipusCanvi);

                if(textEuro.getText().equals(getString(R.string.eur))) {
                    textEuro.setText(getString(R.string.dol));
                    textDolar.setText(getString(R.string.eur));
                    entTipusCanvi.setText(getString(R.string.tipusDol));

                }else {
                    textEuro.setText(getString(R.string.eur));
                    textDolar.setText(getString(R.string.dol));
                    entTipusCanvi.setText(getString(R.string.tipusEur));
                }

                EditText textIntro = (EditText) findViewById(R.id.entIntro);
                TextView textResultat = (TextView) findViewById(R.id.txtResultat);

                textIntro.setText(R.string.zero);
                textResultat.setText(R.string.resultat);

            }

        });



        Button t = (Button) findViewById(R.id.btnTrans);

        t.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    EditText entIntro = (EditText) findViewById(R.id.entIntro);
                    if(entIntro.length()!=0) {

                        TextView textResultat = (TextView) findViewById(R.id.txtResultat);
                        TextView textEuro = (TextView) findViewById(R.id.txtEuro);
                        EditText entTipusCanvi = (EditText) findViewById(R.id.entTipusCanvi);
                        EditText entComissio = (EditText) findViewById(R.id.entPercentatge);

                        double tipusCanvi = Double.parseDouble(entTipusCanvi.getText().toString());

                        double canvi = Double.parseDouble(entIntro.getText().toString()) * tipusCanvi;
                        canvi-=canvi*Double.parseDouble(entComissio.getText().toString())/100;
                        textResultat.setText("" + canvi);
                    }
                }
        });

    }


}
