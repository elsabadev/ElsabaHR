package com.elsabaautoservice.www.elsabahr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

public class Log_IN extends AppCompatActivity {


    String Success ;
    public static String EnteredUserName ;
    public static String EnteredPassword ;

    Button login ;
    EditText getUserName ;
    EditText getPassword ;

    public static int State ;
    JSONObject Result ;
    public static String User_Name ;

    ProgressBar progressBar ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);


        getUserName = (EditText)findViewById(R.id.getUserName);
        getPassword = (EditText)findViewById(R.id.getPassword);

        progressBar = (ProgressBar)findViewById(R.id.lgn_progrs_bar);




        login = (Button) findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                EnteredUserName = getUserName.getText().toString();
                EnteredPassword = getPassword.getText().toString();


                JsonRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Connection.User_LogIn,
                        Connection.Params_usr_Pswd(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            int state = response.getInt("State");
                            JSONObject result = response.getJSONObject("result");
                            String userName = result.getString("User_Name");


                            State = state;
                            Result = result;
                            User_Name = userName;
                        } catch (Exception ex) {
                            ex.getMessage();
                        }



                        if (State == 1)

                        {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplication(),getString(R.string.Welcome) + User_Name,Toast.LENGTH_LONG).show();

                            startActivity(new Intent(Log_IN.this,User_Main.class));





                        }else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplication(),getString(R.string.Ask_Fro_Valid_User_Name_Password),Toast.LENGTH_LONG).show();
                        }



                    }


                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplication(),getString(R.string.Connection_Error),Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);


                    }
                });
                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                        500,
                        DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


                MySingleton.getInstance(Log_IN.this).addToRequestQueue(jsonObjectRequest);







            }
        });



    }
}
