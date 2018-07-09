package ca.hjtaki.diagnostic_test_tools;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Alignment extends AppCompatActivity {
    private int sensorReference1 = 8;
    private int sensorReference2 = 7;
    private int sensorReference3 = 16;
    private int sensorReference4 = 15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment);





        GraphView graph = (GraphView) findViewById(R.id.alignment_gragh);

        InputStream inputStream = getResources().openRawResource(R.raw.alignment);
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

        LineGraphSeries<DataPoint> reference = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, sensorReference1),
                new DataPoint(2, sensorReference2),
                new DataPoint(3, sensorReference3),
                new DataPoint(4, sensorReference4),
                new DataPoint(5, 0)


        });
        reference.setThickness(10);
        graph.addSeries(reference);


        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {

                new DataPoint(1, dataArray.get(1)),
                new DataPoint(2, dataArray.get(2)),
                new DataPoint(3, dataArray.get(3)),
                new DataPoint(4, dataArray.get(4)),
                new DataPoint(5, 0)

        });
        series.setColor(Color.RED);
        graph.addSeries(series);

        ImageView imageView = findViewById(R.id.alignment_wafer);

        if(dataArray.get(1) < sensorReference1
                && dataArray.get(2) < sensorReference2
                && dataArray.get(3) < sensorReference3
                && dataArray.get(4) < sensorReference4){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.alignment_shift_left_top));
        } else if(dataArray.get(1) > sensorReference1
                && dataArray.get(2) > sensorReference2
                && dataArray.get(3) > sensorReference3
                && dataArray.get(4) > sensorReference4){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.alignment_shift_right_bottom));
        } else if(dataArray.get(1) > sensorReference1
                && dataArray.get(2) > sensorReference2
                && dataArray.get(3) < sensorReference3
                && dataArray.get(4) < sensorReference4){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.alignment_rotate_left));
        }else
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.alignment_rotate_right));








    }

}
