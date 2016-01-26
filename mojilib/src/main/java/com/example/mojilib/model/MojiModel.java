package com.example.mojilib.model;


import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Scott Baar on 1/9/2016.
 */
public class MojiModel {
    public int id;
    public String user_id;
    public String origin_id;
    public  String name;
    public String image_url;
    public String link_url;
    public String legacy;
    public String deleted;
    public String created;
    public String access;
    public String username;
    public String flashtag;
    public int shares;
    public int remoji;
    public int likes;
    public String character;

    public MojiModel(){}
    public MojiModel(String name, String image_url){
        this.name = name;
        this.image_url = image_url;
    }

    public static JSONObject toJson(MojiModel m){
        if ( m.image_url==null||m.name==null)return null;//invalid object
        JSONObject jo = new JSONObject();
        try {
            jo.put("image_url", m.image_url);
            jo.putOpt("name", m.name);
        }
        catch (Exception e){e.printStackTrace();}
        return jo;
    }
    public static MojiModel fromJson(JSONObject jo){
        return new MojiModel(jo.optString("name"),jo.optString("image_url"));
    }
    public static JSONArray toJsonArray(Collection<MojiModel> models){
        JSONArray ja = new JSONArray();
        if (models==null ||models.isEmpty())return ja;
        for (MojiModel m : models){
            JSONObject jo = toJson(m);
            ja.put(jo);
        }
        return ja;
    }
    public static List<MojiModel> fromJSONArray(JSONArray ja){
        List<MojiModel> list = new ArrayList<>();
        for (int i = 0; i <ja.length();i++){
            try {
                list.add(fromJson(ja.getJSONObject(i)));
            }
            catch (Exception e){e.printStackTrace();}
        }
        return list;
    }
    @Override
    public String toString(){
        return ""+name;
    }
}
