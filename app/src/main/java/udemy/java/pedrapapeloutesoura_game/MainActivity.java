package udemy.java.pedrapapeloutesoura_game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario) {

        ImageView imageViewResultado = findViewById(R.id.imageView_resultado);
        TextView textoResultado = findViewById(R.id.textView_resultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra" , "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra" :
                imageViewResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                imageViewResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura" :
                imageViewResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if( (opcaoApp == "tesoura" && opcaoUsuario == "papel")
                || (opcaoApp == "papel" && opcaoUsuario == "pedra")
                || (opcaoApp == "pedra" && opcaoUsuario == "tesoura")

        ) {
            textoResultado.setText("Você perdeu :( ");
        } else if( (opcaoUsuario == "tesoura" && opcaoApp == "papel")
                        || (opcaoUsuario == "papel" && opcaoApp == "pedra")
                        || (opcaoUsuario == "pedra" && opcaoApp == "tesoura")
        ) {
            textoResultado.setText("Você ganhou :) ");
        } else {
            textoResultado.setText("Empatamos ;)");
        }
        System.out.println("Item selecionado:" + opcaoApp);
    }
}