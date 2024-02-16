package com.example.rockscisorpaper;

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

    private int contadorRobo = 0;
    private int contadorJogador = 0;

    public void resetPoints(View view) {
        contadorRobo = 0;
        contadorJogador = 0;

        TextView pontosRobo = findViewById(R.id.contador_pontos_robo);
        TextView pontosJogador = findViewById(R.id.contador_pontos_jogador);
        TextView textoResultado = findViewById(R.id.text_resultado);

        ImageView imageApp = findViewById(R.id.image_app);
        imageApp.setImageResource(R.drawable.padrao);

        ImageView playersMove = findViewById(R.id.image_sua_escolha);
        playersMove.setImageResource(R.drawable.padrao);

        pontosRobo.setText("0");
        pontosJogador.setText("0");
        textoResultado.setText("Pontos resetados");
    }
    public void chooseRock(View view) {
        ImageView playersMove = findViewById(R.id.image_sua_escolha);
        playersMove.setImageResource(R.drawable.pedra);
        verifyWinner("rock");
    }
    public void choosePaper(View view) {
        ImageView playersMove = findViewById(R.id.image_sua_escolha);
        playersMove.setImageResource(R.drawable.papel);
        verifyWinner("paper");
    }

    public void chooseScisor(View view) {
        ImageView playersMove = findViewById(R.id.image_sua_escolha);
        playersMove.setImageResource(R.drawable.tesoura);
        verifyWinner("scisor");
    }

    private String randomChoice() {
        String[] options = {"rock", "paper","scisor"};
        int randomNumber = new Random().nextInt(3);

        ImageView imageApp = findViewById(R.id.image_app);
        String robotChoice = options[randomNumber];

        switch(robotChoice) {
            case "rock":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "paper":
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "scisor":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return robotChoice;
    }
    private void verifyWinner(String usersChoice) {
        String robotChoice = randomChoice();
        TextView textoResultado = findViewById(R.id.text_resultado);
        TextView pontosRobo = findViewById(R.id.contador_pontos_robo);
        TextView pontosJogador = findViewById(R.id.contador_pontos_jogador);

        if( (robotChoice.equals("rock") && usersChoice.equals("scisor")) ||
            (robotChoice.equals("paper") && usersChoice.equals("rock")) ||
            (robotChoice.equals("scisor") && usersChoice.equals("paper")) ) {

            textoResultado.setText("Você perdeu. :(");

            contadorRobo++;
            pontosRobo.setText(String.valueOf(contadorRobo));
      } else if(
                (robotChoice.equals("rock") && usersChoice.equals("paper")) ||
                 (robotChoice.equals("paper") && usersChoice.equals("scisor")) ||
                  (robotChoice.equals("scisor") && usersChoice.equals("rock")) ) {

            textoResultado.setText("Você venceu! :D");

            contadorJogador++;
            pontosJogador.setText(String.valueOf(contadorJogador));
        } else {
            textoResultado.setText("Empate. :T");
        }

    }
}