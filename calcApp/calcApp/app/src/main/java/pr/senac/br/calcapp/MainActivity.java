package pr.senac.br.calcapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends Activity implements View.OnClickListener{

    // Botões operação
    private Button btnDiv, btnMulti, btnMenos, btnMais, btnResult, btnZerar;

    //Botões números
    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;

    //TextView da Expressão e Resultado
    private TextView txtExpression, txtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarCalc();

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnZerar.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMais.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMulti.setOnClickListener(this);

        btnZerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    Expression expressao = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double)longResult){
                        txtResult.setText((CharSequence) String.valueOf(longResult));
                    }
                    else {
                        txtResult.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });

    }



    private void IniciarCalc(){

        //Botões númericos
        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);

        //Botões de operação
        btnDiv = findViewById(R.id.btnDiv);
        btnMulti = findViewById(R.id.btnMulti);
        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnResult = findViewById(R.id.btnResult);
        btnZerar = findViewById(R.id.btnZerar);

        //TextView Expressão e Resultado
        txtExpression = findViewById(R.id.txtExpression);
        txtResult = findViewById(R.id.txtResult);

    }

    public void Expressao(String string, boolean limpar){

        if (txtResult.getText().equals("")){
            txtExpression.setText(" ");
        }

        if(limpar){

            txtResult.setText(" ");
            txtExpression.append(string);
        }
        else{

            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnNum0:
                Expressao("0", true);
                break;

            case R.id.btnNum1:
                Expressao("1", true);
                break;

            case R.id.btnNum2:
                Expressao("2", true);
                break;

            case R.id.btnNum3:
                Expressao("3", true);
                break;

            case R.id.btnNum4:
                Expressao("4", true);
                break;

            case R.id.btnNum5:
                Expressao("5", true);
                break;

            case R.id.btnNum6:
                Expressao("6", true);
                break;

            case R.id.btnNum7:
                Expressao("7", true);
                break;

            case R.id.btnNum8:
                Expressao("8", true);
                break;

            case R.id.btnNum9:
                Expressao("9", true);
                break;

            case R.id.btnZerar:
                Expressao(" ", false);
                break;

            case R.id.btnDiv:
                Expressao("/", false);
                break;

            case R.id.btnMais:
                Expressao("+", false);
                break;

            case R.id.btnMenos:
                Expressao("-", false);
                break;

            case R.id.btnMulti:
                Expressao("*", false);
                break;
        }

    }
}
