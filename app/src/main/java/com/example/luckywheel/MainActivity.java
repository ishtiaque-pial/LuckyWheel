package com.example.luckywheel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.luckywheel.library.LuckyWheelView;
import com.example.luckywheel.library.model.LuckyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<LuckyItem> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.secondaryText = "100000000000";
        //luckyItem1.icon = R.drawable.test1;
        luckyItem1.color = Color.parseColor("#FE3325");
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.secondaryText = "1000";
        //luckyItem2.icon = R.drawable.test2;
        luckyItem2.color = Color.parseColor("#F57d17");
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.secondaryText = "1000";
       // luckyItem3.icon = R.drawable.test3;
        luckyItem3.color = Color.parseColor("#FE3325");
        data.add(luckyItem3);

        //////////////////
        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.secondaryText = "1000";
       // luckyItem4.icon = R.drawable.test4;
        luckyItem4.color = Color.parseColor("#F57d17");
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.secondaryText = "1000";
       // luckyItem5.icon = R.drawable.test5;
        luckyItem5.color = Color.parseColor("#FE3325");
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.secondaryText = "1000";
       // luckyItem6.icon = R.drawable.test6;
        luckyItem6.color = Color.parseColor("#F57d17");
        data.add(luckyItem6);
        //////////////////

        //////////////////////
        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.secondaryText = "1000";
       // luckyItem7.icon = R.drawable.test7;
        luckyItem7.color = Color.parseColor("#FE3325");
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.secondaryText = "1000";
       // luckyItem8.icon = R.drawable.test8;
        luckyItem8.color = Color.parseColor("#F57d17");
        data.add(luckyItem8);


        LuckyItem luckyItem9 = new LuckyItem();
        luckyItem9.secondaryText = "1000";
       // luckyItem9.icon = R.drawable.test9;
        luckyItem9.color = Color.parseColor("#FE3325");
        data.add(luckyItem9);
        ////////////////////////

        LuckyItem luckyItem10 = new LuckyItem();
        luckyItem10.secondaryText = "1000";
       // luckyItem10.icon = R.drawable.test10;
        luckyItem10.color = Color.parseColor("#F57d17");
        data.add(luckyItem10);

        LuckyItem luckyItem11 = new LuckyItem();
        luckyItem11.secondaryText = "1000";
       // luckyItem11.icon = R.drawable.test10;
        luckyItem11.color = Color.parseColor("#FE3325");
        data.add(luckyItem11);

        LuckyItem luckyItem12 = new LuckyItem();
        luckyItem12.secondaryText = "1000";
       // luckyItem12.icon = R.drawable.test10;
        luckyItem12.color = Color.parseColor("#F57d17");
        data.add(luckyItem12);

        /////////////////////

        luckyWheelView.setData(data);
        luckyWheelView.setRound(10);

        /*luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);*/


        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(getRandomIndex());
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).topText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }
}