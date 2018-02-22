package com.example.specter.sampleapi3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index extends AppCompatActivity {


    RecyclerView eventlist;
    private TextView responseText;
    List<AppEvent> appEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        eventlist = (RecyclerView) findViewById(R.id.eventlist);
        getProducts();
    }

    private void getProducts()
    {
        Call<JsonObject> eventListCall  =   APIClient.getRetrofitService().getEventlist();
        eventListCall.enqueue(new Callback<JsonObject>()
        {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response)
            {

                if(response.isSuccessful())
                {
                    JsonObject jsonObject = response.body();

                    appEvents = new Gson().fromJson(jsonObject.getAsJsonArray("app_events"),new TypeToken<List<AppEvent>>() {}.getType());
                    setProductsToAdapter();
                    // Show the products on the screen

                    String name = appEvents.get(0).getName();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t)
            {
                Toast.makeText(Index.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProductsToAdapter()
    {
        // Add products to a adapter
        // Add adapter to the recycler view
        // jsonlist.setHasFixedSize(true);
        eventlist.setLayoutManager(new LinearLayoutManager(this));
        eventlist.setAdapter(new NewAdapter(appEvents,this));
        eventlist.getAdapter().notifyDataSetChanged();


    }
}
