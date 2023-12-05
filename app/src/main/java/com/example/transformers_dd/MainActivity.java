package com.example.transformers_dd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView name1, name2, opisanieRobotWords;
    private TextView energy1, energy2;
    private TextView lasers1, lasers2;
    private Button btnStart, btnFight, btnGameOver;
    private LottieAnimationView lotty1, lotty2, lotty_night_fire;
    private LinearLayout imagesRobotsLayout;


    TransformerRed robot1 = new TransformerRed(
            "Optimus", 6000, 200, " I won! It's my planet!");

    TransformerYellow robot2 = new TransformerYellow(
            "Galactus", 6000, 200);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnFight.setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View v) {


                btnStart.setVisibility(View.INVISIBLE);
                imagesRobotsLayout.setVisibility(View.INVISIBLE);

                if ((robot1.energy == 0) || robot1.energy < 0 || (robot2.energy == 0) || robot2.energy < 0) {

                    if(robot1.energy==0 || robot1.energy<0){
                        String wordsRobot2 = robot2.printSelf();
                        opisanieRobotWords.setVisibility(View.VISIBLE);
                        opisanieRobotWords.setText(wordsRobot2);

                    } else  if (robot2.energy==0 || robot2.energy <0) {
                        String wordsRobot1 = robot1.printSelf();
                        opisanieRobotWords.setVisibility(View.VISIBLE);
                        opisanieRobotWords.setText(wordsRobot1);
                    }
                    btnFight.setVisibility(View.INVISIBLE);
                    btnStart.setVisibility(View.INVISIBLE);

                    lotty1.setVisibility(View.INVISIBLE);
                    lotty2.setVisibility(View.INVISIBLE);
                    lotty_night_fire.setVisibility(View.INVISIBLE);

                    btnGameOver.setVisibility(View.VISIBLE);

                } else {

                    imagesRobotsLayout.setVisibility(View.INVISIBLE);
                    lotty1.setVisibility(View.VISIBLE);
                    lotty2.setVisibility(View.VISIBLE);
                    lotty_night_fire.setVisibility(View.VISIBLE);

                    int m = Integer.parseInt(lasers1.getText().toString());
                    robot1.minusEnergy(m);
                    energy1.setText(String.valueOf(robot1.getEnergy()));

                    int n = Integer.parseInt(lasers2.getText().toString());
                    robot2.minusEnergy(n);
                    energy2.setText(String.valueOf(robot2.energy));
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                name1.setText(robot1.getName());
                name2.setText(robot2.name);
                Random rn1 = new Random();

                energy1.setText(String.valueOf(rn1.nextInt(7001)+1));
                Random ls1 = new Random();
                lasers1.setText(String.valueOf(ls1.nextInt(601)+1));

                Random rn2 = new Random();

                energy2.setText(String.valueOf(rn2.nextInt(6001)+1));
                Random ls2 = new Random();
                lasers2.setText(String.valueOf(ls2.nextInt(501)+1));

                btnFight.setVisibility(View.VISIBLE);
            }
        });

    }
    private void init() {
        name1 = findViewById(R.id.name_1);
        name2 = findViewById(R.id.name_2);
        imagesRobotsLayout = findViewById(R.id.images_robots_layuot);
        opisanieRobotWords = findViewById(R.id.opisanieRobotWords);

        energy1 = findViewById(R.id.tv_energy1);
        energy2 = findViewById(R.id.tv_energy2);

        lasers1 = findViewById(R.id.tv_lasers1);
        lasers2 = findViewById(R.id.tv_lasers2);

        btnStart = findViewById(R.id.btn_start);
        btnFight = findViewById(R.id.btn_fight);
        btnGameOver = findViewById(R.id.btn_game_over);

        lotty1 = findViewById(R.id.lotty1);
        lotty2 = findViewById(R.id.lotty2);
        lotty_night_fire = findViewById(R.id.lotty_night_fire);

        lotty_night_fire.setAnimation(R.raw.animation_fire);
        lotty1.setAnimation(R.raw.red_robot);
        lotty2.setAnimation(R.raw.y_robot);
    }


}

//        Rundom r = new Random;
//        r.nextInt(30 + 10) +10;
//         min = 10; max = 30;
//        Сгенерируется случайное целое число (включая ноль) в диапазоне от 10 до 29 (исключая 30 !).


//        int r = (Math.random() * 20 ) - 10;
//        Сгенерируется случайное число от 0 до 20, а затем вычтется из него 10.
//        Получится случайное число(может НЕЦЕЛОЕ) в диапазоне от -10 до +10,все кроме нуля!

//
//        Чтобы сгенерировалось ЦЕЛОЕ значение в диапазоне от +1 до 10, ставим (int) перед (Math.random()):
//        int r = (int) (Math.random() * 21) +1;   Потому что (Math...)- может дать НЕЦЕЛОЕ число!
