package ca.hjtaki.diagnostic_test_tools;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Particle extends AppCompatActivity {

    private ImageView die1, die2, die3, die4, die5, die6, die7, die8, die9, die10;
    private ImageView die11, die12, die13, die14, die15, die16, die17, die18, die19, die20;
    private ImageView die21, die22, die23, die24, die25, die26, die27, die28, die29, die30;
    private ImageView die31, die32, die33, die34, die35, die36, die37, die38, die39, die40;
    private ImageView die41, die42, die43, die44, die45, die46, die47, die48, die49, die50;
    private ImageView die51, die52, die53, die54, die55, die56, die57, die58, die59, die60;
    private ImageView die61, die62, die63, die64, die65, die66, die67, die68, die69, die70;
    private ImageView die71, die72, die73, die74, die75, die76, die77, die78, die79, die80;
    private ImageView die81, die82, die83, die84, die85, die86, die87, die88, die89, die90;
    private ImageView die91, die92, die93, die94, die95, die96, die97, die98, die99, die100;
    private ImageView die101, die102, die103, die104, die105, die106, die107, die108, die109, die110;
    private ImageView die111, die112, die113, die114, die115, die116, die117, die118, die119, die120;
    private ImageView die121, die122, die123, die124, die125, die126, die127, die128, die129, die130;
    private ImageView die131, die132, die133, die134, die135, die136, die137, die138, die139, die140;
    private ImageView die141, die142, die143, die144, die145, die146, die147, die148;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particle);


        InputStream inputStream = getResources().openRawResource(R.raw.flatness);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> dataArray = new ArrayList<>();
        try {
            String test;
            while (true) {
                test = bufferedReader.readLine();
                if (test == null)
                    break;
                dataArray.add(test);
            }
            bufferedReader.close();
            inputStream.close();

        for (int i = 1; i < 149; i++) {
                System.out.println(i + " --------> "+ dataArray.get(i));
                ImageView notes = findViewById(getResources().getIdentifier("imageView"+i, "id", getPackageName()));
                colorMake(Integer.parseInt(dataArray.get(i)), notes);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        private void colorMake(int value, ImageView target) {
        if (value > 5){
            target.setBackgroundResource(R.color.red);
        }
        else if (value > 4){
            target.setBackgroundResource(R.color.orange);
        }
        else if (value > 3){
            target.setBackgroundResource(R.color.yellow);
        }
        else if (value > 2){
            target.setBackgroundResource(R.color.green);
        }
        else if (value > 1) {
            target.setBackgroundResource(R.color.lightblue);
        }else{
            target.setBackgroundResource(R.color.blue);
        }



    }
}












