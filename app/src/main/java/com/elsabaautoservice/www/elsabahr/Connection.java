package com.elsabaautoservice.www.elsabahr;

import org.json.JSONException;
import org.json.JSONObject;

public class Connection {

    public static String IP_Adress = "197.50.45.168:8030";
    public static JSONObject Params = new JSONObject();


    public static String User_LogIn = "http://"+IP_Adress+"/MotiveTestDev/Authentication/Login";

//================================Parameter (Brand - Branch - From Date - To Date )========================================

    public static JSONObject Params_b_b_f_t(){

        try {
//            Params.put("FromDate", Filter.From_Date);
//            Params.put("ToDate", Filter.To_Date);
//            Params.put("brandId", Filter.BrandID);
//            Params.put("branchId", "1");

            Params.put("FromDate", "2018-07-10");
            Params.put("ToDate", "2018-07-20");
            Params.put("brandId",1);
            Params.put("branchId", "3");
            return Params;
        }catch(JSONException ex) {
            return null;
        }
    }

    public static JSONObject Params_usr_Pswd(){

        try {
//
            Params.put("UserName", Log_IN.EnteredUserName);
            Params.put("UserPassword", Log_IN.EnteredPassword);
            Params.put("DeviceName", "android");

            return Params;
        }catch(JSONException ex) {
            return null;
        }
    }
}
