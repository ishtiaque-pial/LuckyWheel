package com.example.luckywheel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.luckywheel.apiManager.ApiService;
import com.example.luckywheel.apiManager.RetrofitClint;
import com.example.luckywheel.apiManager.WheelPojo;
import com.example.luckywheel.library.LuckyWheelView;
import com.example.luckywheel.library.model.LuckyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<LuckyItem> data = new ArrayList<>();
    private ApiService apiService;
    private LuckyWheelView luckyWheelView;
    private int indexxx=0;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = RetrofitClint.getApiServiceWithoutHeader();

        luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.secondaryText = "ishtiaque\n morshed pial ";
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

        mp = MediaPlayer.create(this, R.raw.tick);

        /*luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);*/


        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                //callApiAgain();
                luckyWheelView.startLuckyWheelWithTargetIndex(10);
                final int initialDt = 0;
                final Handler handler = new Handler();
                final Runnable r = new Runnable() {
                    int dt = initialDt;
                    public void run() {

                        if (dt <= 5000) {
                            mp.start();
                            dt =dt+50;
                            handler.postDelayed(this, 50);
                        } else if (dt<=8000) {
                            mp.start();
                            dt = dt +200;
                            handler.postDelayed(this, 200);
                        } else if (dt<=11000){
                            mp.start();
                            dt = dt +300;
                            handler.postDelayed(this, 300);
                        }
                    }
                };
                handler.postDelayed(r, initialDt);

            }
        });
        findViewById(R.id.ok2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luckyWheelView.stopLuckyWheel();

            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).secondaryText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callApiAgain() {
        Call<WheelPojo> wheelPojoCall = apiService.WHEEL_POJO_CALL();
        wheelPojoCall.enqueue(new Callback<WheelPojo>() {
            @Override
            public void onResponse(Call<WheelPojo> call, Response<WheelPojo> response) {
                for (int i=0;i<response.body().getResponse().getWheels().size();i++) {
                    if (response.body().getResponse().getSelected().equals(response.body().getResponse().getWheels().get(i).getCode())){
                        indexxx =i;
                    }
                }
                luckyWheelView.startLuckyWheelWithTargetIndex(indexxx);
            }

            @Override
            public void onFailure(Call<WheelPojo> call, Throwable t) {

            }
        });
    }

    private void callApi() {
        Call<WheelPojo> wheelPojoCall = apiService.WHEEL_POJO_CALL();
        wheelPojoCall.enqueue(new Callback<WheelPojo>() {
            @Override
            public void onResponse(Call<WheelPojo> call, Response<WheelPojo> response) {
                for (int i=0;i<response.body().getResponse().getWheels().size();i++) {
                    LuckyItem luckyItem = new LuckyItem();
                    if (response.body().getResponse().getWheels().get(i).getName().contains("Night")) {
                        String[] value = response.body().getResponse().getWheels().get(i).getName().split("Night");
                        String finalString = value[0]+" Night-\n"+value[1];
                        luckyItem.secondaryText = finalString;
                    } else if(response.body().getResponse().getWheels().get(i).getName().contains("&")){
                        String[] value = response.body().getResponse().getWheels().get(i).getName().split("&");
                        String finalString = value[0]+" &-\n"+value[1];
                        luckyItem.secondaryText = finalString;
                    } else if (response.body().getResponse().getWheels().get(i).getName().contains("Pattaya")){
                        String[] value = response.body().getResponse().getWheels().get(i).getName().split("Pattaya");
                        String finalString = value[0]+"-\nPattaya";
                        luckyItem.secondaryText = finalString;
                    } else {
                        luckyItem.secondaryText = response.body().getResponse().getWheels().get(i).getName();
                    }
                    if (i%2==0) {
                        luckyItem.color = Color.parseColor("#FE3325");
                    } else {
                        luckyItem.color = Color.parseColor("#F57d17");
                    }

                    data.add(luckyItem);
                }
                luckyWheelView.setData(data);
                luckyWheelView.setRound(10);
            }

            @Override
            public void onFailure(Call<WheelPojo> call, Throwable t) {

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