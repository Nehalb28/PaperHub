package com.example.android.procnect;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class SaveSharedPreference {

    private static final String PREF_USER_NAME= "username";
    private static final String PREF_VENDOR_TYPE= "vendortype";
    private static final String PREF_LOCATION= "location";
    private static final String PBF14= "pbf14";
    private static final String PBF16= "pbf16";
    private static final String PBF18= "pbf18";
    private static final String PBF20= "pbf20";
    private static final String PBF22= "pbf22";
    private static final String PBF25= "pbf25";
    private static final String PBF28= "pbf28";
    private static final String PBF30= "pbf30";
    private static final String PBF32= "pbf32";
    private static final String PBF35= "pbf35";

    private static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.apply();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static void setVendorType(Context ctx, String vendorType){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_VENDOR_TYPE, vendorType);
        editor.apply();
    }

    public static String getVendorType(Context ctx){
        return getSharedPreferences(ctx).getString(PREF_VENDOR_TYPE, "");
    }

    public static void setLocation(Context ctx, String location){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_LOCATION, location);
        editor.apply();
    }

    public static String getLocation(Context ctx){
        return getSharedPreferences(ctx).getString(PREF_LOCATION, "");
    }

    public static String getPbf14(Context ctx){
        return getSharedPreferences(ctx).getString(PBF14, "");
    }

    public static void setPbf14(Context ctx, String pbf14){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF14, pbf14);
        editor.apply();
    }

    public static void setPbf16(Context ctx, String pbf16){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF16, pbf16);
        editor.apply();
    }

    public static String getPbf16(Context ctx){
        return getSharedPreferences(ctx).getString(PBF16, "");
    }

    public static String getPbf18(Context ctx){
        return getSharedPreferences(ctx).getString(PBF18, "");
    }

    public static void setPbf18(Context ctx, String pbf18){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF18, pbf18);
        editor.apply();
    }

    public static void setPbf20(Context ctx, String pbf20){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF20, pbf20);
        editor.apply();
    }

    public static String getPbf20(Context ctx){
        return getSharedPreferences(ctx).getString(PBF20, "");
    }

    public static void setPbf22(Context ctx, String pbf22){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF22, pbf22);
        editor.apply();
    }

    public static String getPbf22(Context ctx){
        return getSharedPreferences(ctx).getString(PBF22, "");
    }

    public static void setPbf25(Context ctx, String pbf25){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF25, pbf25);
        editor.apply();
    }

    public static String getPbf25(Context ctx){
        return getSharedPreferences(ctx).getString(PBF25, "");
    }

    public static void setPbf28(Context ctx, String pbf28){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF28, pbf28);
        editor.apply();
    }

    public static String getPbf28(Context ctx){
        return getSharedPreferences(ctx).getString(PBF28, "");
    }

    public static void setPbf30(Context ctx, String pbf30){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF30, pbf30);
        editor.apply();
    }

    public static String getPbf30(Context ctx){
        return getSharedPreferences(ctx).getString(PBF30, "");
    }

    public static void setPbf32(Context ctx, String pbf32){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF32, pbf32);
        editor.apply();
    }

    public static String getPbf32(Context ctx){
        return getSharedPreferences(ctx).getString(PBF32, "");
    }

    public static void setPbf35(Context ctx, String pbf35){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PBF35, pbf35);
        editor.apply();
    }

    public static String getPbf35(Context ctx){
        return getSharedPreferences(ctx).getString(PBF35, "");
    }

    public static void logoutUser(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.apply();
    }
}
