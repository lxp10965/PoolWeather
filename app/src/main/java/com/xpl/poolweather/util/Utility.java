package com.xpl.poolweather.util;

import android.text.TextUtils;

import com.xpl.poolweather.db.City;
import com.xpl.poolweather.db.County;
import com.xpl.poolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /**
     * 解析和处理数据库返回的省级数据
     */

    public static boolean handleProvinceResponse(String response){

        if(!TextUtils.isEmpty(response)){ //response不为空时成立

            JSONArray allProvinces = new JSONArray();
            for (int i=0;i<=allProvinces.length();i++){
                try {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){

        if(!TextUtils.isEmpty(response)){ //response不为空时成立

            JSONArray allProvinces = new JSONArray();
            for (int i=0;i<=allProvinces.length();i++){
                try {
                    JSONObject cityObject=allProvinces.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){

        if(!TextUtils.isEmpty(response)){ //response不为空时成立

            JSONArray allProvinces = new JSONArray();
            for (int i=0;i<=allProvinces.length();i++){
                try {
                    JSONObject countyObject=allProvinces.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("id"));
                    county.setCityId(cityId);
                    county.save();
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }
}
