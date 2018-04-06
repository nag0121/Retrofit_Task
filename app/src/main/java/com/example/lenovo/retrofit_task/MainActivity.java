package com.example.lenovo.retrofit_task;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lv_data,lv_in,lv_out;
    Button btn_all, btn_in, btn_out;

    List<DataProvider> dataproviders = new ArrayList<>();
    DataProvider dataprovider ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_data = (ListView) findViewById(R.id.lv_data_main);
        lv_in=(ListView)findViewById(R.id.lv_data1_main);
        lv_out=(ListView)findViewById(R.id.lv_data2_main);
        btn_all = (Button) findViewById(R.id.btn_all_main);
        btn_in = (Button) findViewById(R.id.btn_incoming_main);
        btn_out = (Button) findViewById(R.id.btn_out_main);



        lv_data.setVisibility(View.VISIBLE);
        lv_in.setVisibility(View.GONE);
        lv_out.setVisibility(View.GONE);

        btn_all.setBackgroundResource(R.drawable.btn_bg);
        btn_in.setBackgroundResource(R.drawable.btn_bg1);
        btn_out.setBackgroundResource(R.drawable.btn_bg1);

        btn_all.isEnabled();

        btn_in.setTextColor(Color.parseColor("#13F571"));
        btn_out.setTextColor(Color.parseColor("#13F571"));
        btn_all.setTextColor(Color.parseColor("#ffffff"));


        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lv_data.setVisibility(View.VISIBLE);
                lv_in.setVisibility(View.GONE);
                lv_out.setVisibility(View.GONE);

                btn_all.setBackgroundResource(R.drawable.btn_bg);
                btn_in.setBackgroundResource(R.drawable.btn_bg1);
                btn_out.setBackgroundResource(R.drawable.btn_bg1);

                btn_all.isEnabled();

                btn_in.setTextColor(Color.parseColor("#13F571"));
                btn_out.setTextColor(Color.parseColor("#13F571"));
                btn_all.setTextColor(Color.parseColor("#ffffff"));

            }
        });

     btn_in.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {





             lv_in.setVisibility(View.VISIBLE);
             lv_data.setVisibility(View.GONE);
             lv_out.setVisibility(View.GONE);

             btn_all.setBackgroundResource(R.drawable.btn_bg1);
             btn_in.setBackgroundResource(R.drawable.btn_bg);
             btn_out.setBackgroundResource(R.drawable.btn_bg1);

             btn_in.setTextColor(Color.parseColor("#ffffff"));
             btn_out.setTextColor(Color.parseColor("#13F571"));
             btn_all.setTextColor(Color.parseColor("#13F571"));

         }
     });
     btn_out.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

getData();
             lv_out.setVisibility(View.VISIBLE);
             lv_data.setVisibility(View.GONE);
             lv_in.setVisibility(View.GONE);
             btn_all.setBackgroundResource(R.drawable.btn_bg1);
             btn_in.setBackgroundResource(R.drawable.btn_bg1);
             btn_out.setBackgroundResource(R.drawable.btn_bg);

             btn_in.setTextColor(Color.parseColor("#13F571"));
             btn_out.setTextColor(Color.parseColor("#ffffff"));
             btn_all.setTextColor(Color.parseColor("#13F571"));

         }
     });
    }
private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://giftzay.vmgtelecoms.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiResponse apiResponse = retrofit.create(ApiResponse.class);

        Call<Transactions> transactionsCall = apiResponse.request("25");

        transactionsCall.enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {

            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {

            }
        });
    }
}
