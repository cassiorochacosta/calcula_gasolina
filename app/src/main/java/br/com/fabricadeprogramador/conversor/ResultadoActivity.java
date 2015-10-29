package br.com.fabricadeprogramador.conversor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by marcelo terenciani on 27/10/2015.
 */
public class ResultadoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        Double resultadoGasolina = bundle.getDouble("rGasolina");
        Double resultadoAlcool = bundle.getDouble("rAlcool");


        EditText edtEconomia = (EditText) findViewById(R.id.edtEconomia);
        EditText edtOpcao = (EditText) findViewById(R.id.edtOpcao);
        EditText edtDif = (EditText) findViewById(R.id.edtDif);

        Double porcentagem, diferenca;
        if (resultadoAlcool > resultadoGasolina) {
            porcentagem = ((resultadoAlcool / resultadoGasolina) - 1) * 100;
            edtEconomia.setText(porcentagem.toString());
            edtOpcao.setText("Alcool");
            diferenca = resultadoAlcool - resultadoGasolina;
            edtDif.setText(diferenca.toString());
        } else {
            porcentagem = ((resultadoGasolina / resultadoAlcool) - 1) * 100;
            edtEconomia.setText(porcentagem.toString());
            edtOpcao.setText("Gasolina");
            diferenca = resultadoGasolina - resultadoAlcool;
            edtDif.setText(diferenca.toString());
        }

        Button btnFechar = (Button) findViewById(R.id.btnFechar);

        btnFechar.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     finish();
                 }
             }
        );

    }
}
