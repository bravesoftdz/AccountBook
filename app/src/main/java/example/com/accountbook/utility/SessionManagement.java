package example.com.accountbook.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by c49 on 27/01/16.
 */
public class SessionManagement {
    public static final String TAG="SessionManagement====>";
  /*  public static boolean createSessionObject(Context context,String key,String value){

            SharedPreferences sharedPreferences= context.getSharedPreferences(AppConstance.PREFERENCE_NAME,context.MODE_PRIVATE);
            sharedPreferences.edit().putString(key,value).commit();
            return true;


    }
    public static Object getSessionObject(Context context,String key, Class responseType)  {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
            return WebserviceConnector.getMapper().readValue(sharedPreferences.getString(key, null), responseType);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static boolean chkSession(Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(AppConstance.PREFERENCE_NAME,context.MODE_PRIVATE);
        Log.e(TAG, " +" + sharedPreferences.getString(AppConstance.PREFERENCE_KEY_USERINFO, null));

        if(sharedPreferences.getString(AppConstance.PREFERENCE_KEY_USERINFO,null)!=null)
            return true;
        else
            return false;
    }*/
    public static boolean savePreferences(Context context,String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
        return true;

    }
    public static String getStringValue(Context context,String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(key,value);

    }
    public static boolean saveIntValue(Context context,String key, int value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
        return true;

    }
    public static int getIntValue(Context context,String key, int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,value);

    }
    public static boolean setBoolean(Context context,String key, boolean value) {
        Log.e("set method======>",key+" "+value);
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
        Log.e("set method ======>", key + " " + sharedPreferences.getBoolean(key, false));
        return true;

    }
    public static boolean getBoolean(Context context,String key, boolean value) {

        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        Log.e("======>",key+" "+sharedPreferences.getBoolean(key,false));
        return sharedPreferences.getBoolean(key, value);


    }
    public static boolean saveColorPreferences(Context context,String key, int value) {
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
        return true;

    }
    public static int getColorPreferences(Context context,String key) {
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, -15566106);


    }
    public static int getColorPreferences(Context context,String key,int color) {
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,color);

    }
    public static void logOut(Context context){
        SharedPreferences settings = context.getSharedPreferences(AppConstance.PREFERENCE_NAME,context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }
    public static boolean setTextSize(Context context,String key, float value) {
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
        return true;

    }
    public static float getTextSize(Context context,String key,float defaultSize) {
        key=key.trim().toLowerCase();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstance.PREFERENCE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key,defaultSize);


    }

}
