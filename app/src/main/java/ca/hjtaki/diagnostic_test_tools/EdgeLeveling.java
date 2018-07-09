package ca.hjtaki.diagnostic_test_tools;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EdgeLeveling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edge_leveling);




        GraphView graph = (GraphView) findViewById(R.id.graph);

        InputStream inputStream = getResources().openRawResource(R.raw.edgeleveling);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<Float> dataArray = new ArrayList<>();
        try {
            String line;
            while (true) {
                line = (bufferedReader.readLine());
                if (line == null)
                    break;
                dataArray.add(Float.valueOf(line));

            }
            bufferedReader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }




            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {

                    new DataPoint(1, dataArray.get(1)),
                    new DataPoint(2, dataArray.get(2)),
                    new DataPoint(3, dataArray.get(3)),
                    new DataPoint(4, dataArray.get(4)),
                    new DataPoint(5, dataArray.get(5)),
                    new DataPoint(6, dataArray.get(6)),
                    new DataPoint(7, dataArray.get(7)),
                    new DataPoint(8, dataArray.get(8)),
                    new DataPoint(9, dataArray.get(9)),
                    new DataPoint(10, dataArray.get(10)),

                    new DataPoint(11, dataArray.get(11)),
                    new DataPoint(12, dataArray.get(12)),
                    new DataPoint(13, dataArray.get(13)),
                    new DataPoint(14, dataArray.get(14)),
                    new DataPoint(15, dataArray.get(15)),
                    new DataPoint(16, dataArray.get(16)),
                    new DataPoint(17, dataArray.get(17)),
                    new DataPoint(18, dataArray.get(18)),
                    new DataPoint(19, dataArray.get(19)),
                    new DataPoint(20, dataArray.get(20)),

                    new DataPoint(21, dataArray.get(21)),
                    new DataPoint(22, dataArray.get(22)),
                    new DataPoint(23, dataArray.get(23)),
                    new DataPoint(24, dataArray.get(24)),
                    new DataPoint(25, dataArray.get(25)),
                    new DataPoint(26, dataArray.get(26)),
                    new DataPoint(27, dataArray.get(27)),
                    new DataPoint(28, dataArray.get(28)),
                    new DataPoint(29, dataArray.get(29)),
                    new DataPoint(30, dataArray.get(30)),

                    new DataPoint(31, dataArray.get(31)),
                    new DataPoint(32, dataArray.get(32)),
                    new DataPoint(33, dataArray.get(33)),
                    new DataPoint(34, dataArray.get(34)),
                    new DataPoint(35, dataArray.get(35)),
                    new DataPoint(36, dataArray.get(36)),
                    new DataPoint(37, dataArray.get(37)),
                    new DataPoint(38, dataArray.get(38)),
                    new DataPoint(39, dataArray.get(39)),
                    new DataPoint(40, dataArray.get(40)),
                    new DataPoint(41, dataArray.get(40))



            }

        );


        graph.addSeries(series);


        for (int i = 1; i < 36; i++) {
            System.out.println(i + " --------> "+ dataArray.get(i));
            ImageView notes = findViewById(getResources().getIdentifier("imageView"+i, "id", getPackageName()));
            colorMake(dataArray.get(i), notes);
        }


    }

    private void colorMake(Float value, ImageView target) {
        if (value > 5 ){
            target.setBackgroundResource(R.color.red);
        } else if (value > 4){
            target.setBackgroundResource(R.color.orange);
        } else if (value > 3){
            target.setBackgroundResource(R.color.yellow);
        } else if (value > 2){
            target.setBackgroundResource(R.color.green);
        } else if (value > 1){
            target.setBackgroundResource(R.color.lightblue);
        } else if(value >= 0){
            target.setBackgroundResource(R.color.blue);
        } else  if(value > -1){
            target.setBackgroundResource(R.color.darkGreen);
        }else  if(value > -2){
            target.setBackgroundResource(R.color.darkYellow);
        }else  if(value > -3){
            target.setBackgroundResource(R.color.darkOrange);
        }else  if(value > -3){
            target.setBackgroundResource(R.color.darkRed);

        }



    }
}
