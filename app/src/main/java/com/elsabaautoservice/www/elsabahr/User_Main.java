package com.elsabaautoservice.www.elsabahr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class User_Main extends AppCompatActivity {

    public static String[] Attendance_Date ;
    public static String[] Att_In = new String[2];
    public static String[] Att_Out ;
    public static String[] Att_Status ;

    ListView Attendance_List ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__main);

        setTitle(Log_IN.User_Name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Attendance_Date =  new String[2];
        Att_In = new String[2];
        Att_Out = new String[2];
        Att_Status = new String[2];





            Attendance_Date[0] = "2019-1-1";
            Attendance_Date[1] = "2019-1-2";
            Att_In[0] = "9:00AM";
            Att_In[1] = "10:00AM";
        Att_Out[0] = "5:00PM";
        Att_Out[1] = "5:00PM";
        Att_Status[0] = "Attend";
        Att_Status[1] = "Attend";






        Attendance_List = (ListView)findViewById(R.id.Attendance_listView);

        EvaluationAdapter evaluationAdapter = new EvaluationAdapter();
        Attendance_List.setAdapter(evaluationAdapter);



    }

    class EvaluationAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return Attendance_Date.length ;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.user_main,null);

            TextView Date = (TextView)view.findViewById(R.id.dt_att_date);
            TextView In = (TextView)view.findViewById(R.id.time_in);
            TextView Out = (TextView)view.findViewById(R.id.time_out);
            TextView Status = (TextView)view.findViewById(R.id.dt_att_status);

            Date.setText(Attendance_Date[i]);
            In.setText(""+Att_In[i]);
            Out.setText(""+Att_Out[i]);
            Status.setText(""+Att_Status[i]);

            return view;
        }
    }


    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(User_Main.this,MainActivity.class));

    }
    // ================================= Action for Back Button in ActionBar==============================
    public boolean onOptionsItemSelected (MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);

        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }




}
