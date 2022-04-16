package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView giris, sonuc;
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,
            button_9, button_sil, button_topla, button_cikar, button_carp, button_bol, button_dot, button_esittir;
    private final char TOPLA = '+';
    private final char CIKAR = '-';
    private final char CARP = '*';
    private final char BOL = '/';
    private final char ESIT = 0;
    private double deger1 = Double.NaN;
    private double deger2;
    private char ISLEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        views();

        button_0.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "0");
        });

        button_1.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "1");
        });

        button_2.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "2");
        });

        button_3.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "3");
        });

        button_4.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "4");
        });

        button_5.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "5");
        });

        button_6.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "6");
        });

        button_7.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "7");
        });

        button_8.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "8");
        });

        button_9.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + "9");
        });

        button_dot.setOnClickListener(view -> {
            giris.setText(giris.getText().toString() + ".");
        });


        button_topla.setOnClickListener(view -> {
            try {
                Hesapla();
                ISLEM = TOPLA;
                sonuc.setText(String.valueOf(deger1) + "+");
                giris.setText(null);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Bir Sayı Girin", Toast.LENGTH_SHORT).show();
            }

        });

        button_cikar.setOnClickListener(view -> {
            try {
                Hesapla();
                ISLEM = CIKAR;
                sonuc.setText(String.valueOf(deger1) + "-");
                giris.setText(null);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Bir Sayı Girin", Toast.LENGTH_SHORT).show();
            }

        });

        button_carp.setOnClickListener(view -> {
            try {
                Hesapla();
                ISLEM = CARP;
                sonuc.setText(String.valueOf(deger1) + "*");
                giris.setText(null);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Bir Sayı Girin", Toast.LENGTH_SHORT).show();
            }

        });

        button_bol.setOnClickListener(view -> {
            try {
                Hesapla();
                ISLEM = BOL;
                sonuc.setText(String.valueOf(deger1) + "/");
                giris.setText(null);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Bir Sayı Girin", Toast.LENGTH_SHORT).show();
            }

        });

        button_esittir.setOnClickListener(view -> {
            try {
                Hesapla();
                ISLEM = ESIT;
                sonuc.setText(sonuc.getText().toString() + String.valueOf(deger2) + "=" + String.valueOf(deger1));
                giris.setText(null);
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Bir İşlem Yapın", Toast.LENGTH_SHORT).show();
            }

        });

        button_sil.setOnClickListener(view -> {
            if(giris.getText().length() > 0) {
                CharSequence ifade = giris.getText().toString();
                giris.setText(ifade.subSequence(0, ifade.length() - 1));
            } else {
                deger1 = Double.NaN;
                deger2 = Double.NaN;
                giris.setText(null);
                sonuc.setText(null);
            }
        });


    }


    private void views() {
        giris = (TextView) findViewById(R.id.textViewIslem);
        sonuc = (TextView) findViewById(R.id.textViewSonuc);

        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);

        button_sil = (Button) findViewById(R.id.buttonSil);
        button_topla = (Button) findViewById(R.id.buttonTopla);
        button_esittir = (Button) findViewById(R.id.buttonEsittir);
        button_cikar = (Button) findViewById(R.id.buttonCikar);
        button_carp = (Button) findViewById(R.id.buttonCarp);
        button_bol = (Button) findViewById(R.id.buttonBol);
        button_dot = (Button) findViewById(R.id.buttonDot);
    }


    private void Hesapla() {
        if (!Double.isNaN(deger1)) {
            deger2 = Double.parseDouble(giris.getText().toString());

            switch (ISLEM) {
                case TOPLA:
                    deger1 = deger1 + deger2;
                    break;
                case CIKAR:
                    deger1 = deger1 - deger2;
                    break;
                case CARP:
                    deger1 = deger1 * deger2;
                    break;
                case BOL:
                    deger1 = deger1 / deger2;
                    break;
                case ESIT:
                    break;
            }
        } else {
            deger1 = Double.parseDouble(giris.getText().toString());
        }
    }


}