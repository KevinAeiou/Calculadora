package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnZero, btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis,
            btnSete, btnOito, btnNove, btnPonto, btnSoma, btnSubtracao, btnMultiplicacao,
            btnIgual, btnLimpar, btnDivisao;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponetes();

        getSupportActionBar().hide();

        btnZero.setOnClickListener(this);
        btnUm.setOnClickListener(this);
        btnDois.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSete.setOnClickListener(this);
        btnOito.setOnClickListener(this);
        btnNove.setOnClickListener(this);
        btnPonto.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnSubtracao.setOnClickListener(this);
        btnMultiplicacao.setOnClickListener(this);
        btnDivisao.setOnClickListener(this);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txtExpressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0=0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResultado = (long) resultado;

                    if (resultado==(double)longResultado){
                        txtResultado.setText((CharSequence) String.valueOf(longResultado));
                    }else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }

            }
        });

    }
    private void iniciarComponetes(){
        btnZero = findViewById(R.id.btnZero);
        btnUm  = findViewById(R.id.btnUm);
        btnDois = findViewById(R.id.btnDois);
        btnTres= findViewById(R.id.btnTres);
        btnQuatro = findViewById(R.id.btnQuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSete = findViewById(R.id.btnSete);
        btnOito = findViewById(R.id.btnOito);
        btnNove = findViewById(R.id.btnNove);
        btnPonto = findViewById(R.id.ponto);
        btnSoma = findViewById(R.id.soma);
        btnSubtracao = findViewById(R.id.subtracao);
        btnMultiplicacao = findViewById(R.id.multiplicacao);
        btnDivisao = findViewById(R.id.divisao);
        btnIgual = findViewById(R.id.igual);
        btnLimpar = findViewById(R.id.btnLimpar);
        txtExpressao = findViewById(R.id.txtExpressao);
        txtResultado = findViewById(R.id.txtResultado);
        backspace = findViewById(R.id.backSpace);
    }

    public void acrescentarExpressao(String string, boolean limparDados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if (limparDados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnZero:
                acrescentarExpressao("0", true);
                break;
            case R.id.btnUm:
                acrescentarExpressao("1", true);
                break;
            case R.id.btnDois:
                acrescentarExpressao("2", true);
                break;
            case R.id.btnTres:
                acrescentarExpressao("3", true);
                break;
            case R.id.btnQuatro:
                acrescentarExpressao("4", true);
                break;
            case R.id.btnCinco:
                acrescentarExpressao("5", true);
                break;
            case R.id.btnSeis:
                acrescentarExpressao("6", true);
                break;
            case R.id.btnSete:
                acrescentarExpressao("7", true);
                break;
            case R.id.btnOito:
                acrescentarExpressao("8", true);
                break;
            case R.id.btnNove:
                acrescentarExpressao("9", true);
                break;
            case R.id.ponto:
                acrescentarExpressao(".", true);
                break;
            case R.id.soma:
                acrescentarExpressao("+", false);
                break;
            case R.id.subtracao:
                acrescentarExpressao("-", false);
                break;
            case R.id.multiplicacao:
                acrescentarExpressao("*", false);
                break;
            case R.id.divisao:
                acrescentarExpressao("/", false);
                break;
        }
    }
}