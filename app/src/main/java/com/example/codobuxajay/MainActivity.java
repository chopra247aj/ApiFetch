package com.example.codobuxajay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<PojoData.Datum> list = new ArrayList<>();
    int pos=0;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Gson gson = new Gson();
        String URL = "https://dummy.restapiexample.com/api/v1/employees";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("aaa",""+response.toString());
                    JSONArray array = response.getJSONArray("data");
                    for (int i = 0; i < array.length(); i++) {
                        try {
                            PojoData.Datum datum = gson.fromJson(array.getJSONObject(i).toString(),PojoData.Datum.class);
                            list.add(datum);
                             adapter =new MyAdapter(getApplicationContext(), list, new MyAdapter.GetClick() {
                                @Override
                                public void itemClick(int position) {
                                    pos=position;
                                    Intent intent  =new Intent(MainActivity.this, SecondScreen.class);
                                    Bundle bundle=new Bundle();
                                    bundle.putString("name", list.get(position).getEmployeeName());
                                    bundle.putString("id", list.get(position).getId().toString());
                                    bundle.putString("imageurl", list.get(position).getProfileImage());
                                    bundle.putString("age", list.get(position).getEmployeeAge().toString());
                                    bundle.putString("salary", list.get(position).getEmployeeSalary().toString());
                                    intent.putExtra("Bundle",bundle);
                                    startActivityForResult(intent,1);



                                }
                            });
                            recyclerView.setAdapter(adapter);
                        } catch (Exception e) {

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Bundle bundle=data.getBundleExtra("Bundle2");
                PojoData.Datum datum=new PojoData.Datum();
                datum.setId(new Integer(bundle.getString("id2")));
                datum.setEmployeeName(bundle.getString("name2"));
                datum.setEmployeeAge(new Integer(bundle.getString("age2")));
                datum.setEmployeeSalary( new BigInteger(bundle.getString("salary2")));
                list.set(pos,datum);
               // notifyAll();
                adapter.notifyDataSetChanged();

            }
        }

    }
}