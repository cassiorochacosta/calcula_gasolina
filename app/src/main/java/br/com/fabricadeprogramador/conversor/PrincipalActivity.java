package br.com.fabricadeprogramador.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        final EditText edtValor = (EditText) findViewById(R.id.edtValor);

        //Pegando os valores da tela para a gasolina
        final EditText edtPrecoGasolina = (EditText) findViewById(R.id.edtPrecoGasolina);
        final EditText edtKmGasolina = (EditText) findViewById(R.id.edtKmGasolina);

        //Pegando os valores da tela para o alcool
        final EditText edtPrecoAlcool = (EditText) findViewById(R.id.edtValorAlcool);
        final EditText edtKmAlcool = (EditText) findViewById(R.id.edtKmAlcool);


        Button btnCalculo = (Button) findViewById(R.id.btnCalculo);



        btnCalculo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Double resultadoGasolina = calculoGasolina();


                Double resultadoAlcool = calculoAlcool();

                Bundle bundle = new Bundle();

                bundle.putDouble("rGasolina", resultadoGasolina);
                bundle.putDouble("rAlcool", resultadoAlcool);

                Intent irParaResultado = new Intent(PrincipalActivity.this, ResultadoActivity.class);

                irParaResultado.putExtras(bundle);
                startActivity(irParaResultado,bundle);



            }

            public Double calculoGasolina() {



                //Pegando os valores dos editText e convertendo para double
                Double valor = Double.parseDouble(edtValor.getText().toString());
                Double precoGasolina = Double.parseDouble(edtPrecoGasolina.getText().toString());
                Double kmGasolina = Double.parseDouble(edtKmGasolina.getText().toString());

                Double litros = (valor / precoGasolina);
                return litros * kmGasolina;

            }

            public Double calculoAlcool() {

                //Pegando os valores dos editText e convertendo para double
                Double valor = Double.parseDouble(edtValor.getText().toString());
                Double precoAlcool = Double.parseDouble(edtPrecoAlcool.getText().toString());
                Double kmAlcool = Double.parseDouble(edtKmAlcool.getText().toString());

                Double litros = (valor / precoAlcool);
                return litros * kmAlcool;

            }
        });

        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                edtValor.setText("");
                edtPrecoGasolina.setText("");
                edtKmGasolina.setText("");
                edtPrecoAlcool.setText("");
                edtKmAlcool.setText("");
            }
        });

    }
}
