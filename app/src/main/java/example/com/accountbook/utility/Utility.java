package example.com.accountbook.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * utility class for common methods.
 */
public class Utility {

    private static final String TAG = Utility.class.getSimpleName();

    public static boolean isConnected(Context context) {
        /*NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        Log.e("","networkInfo==>"+networkInfo.isConnected());
        return networkInfo != null && networkInfo.isConnected();*/
       try {
           NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
           Log.e("","networkInfo==>"+networkInfo.isConnected());
           return networkInfo != null && networkInfo.isConnected();
       }catch(Exception e){
           e.printStackTrace();
           return false;
       }


    }


    private static AlertDialog dialogOffline;

    /*public static void alertOffline(Context context) {
        try {
            if (dialogOffline == null || !dialogOffline.isShowing()) {
                dialogOffline = alert(context, "Please check internet connection", "Offline");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }*/


    public static AlertDialog alert(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (title != null) {
            builder.setTitle(title);
        }
        if (message != null) {
            builder.setMessage(message);
        }
        AlertDialog dialogOffline = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
        dialogOffline.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialogOffline.show();
        return dialogOffline;
    }

    public static void showToast(Context context, String message) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "showToast Exception : " + e.toString());
        }
    }
    public static String getErrorString(Exception error){
        if(error!=null && error.toString().length()>0 ){
            if(error instanceof UnknownHostException)
            {
                return AppConstance.INTERNET_CONNECTION_MESSAGE;
            }
            else if(error instanceof IOException)
            {
                return AppConstance.AUTHORIZATION_FAILED_MESSAGE;
            }
            else if(error instanceof SocketTimeoutException)
            {
                return AppConstance.SOCKET_TIME_OUT_MESSAGE;
            }
            else{
                return AppConstance.UNKNOWN_ERROR_MESSAGE;
            }
        }
        return null;

    }

    public static String getCurrentDate(){
        String pattern = "dd-MM-yyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        return dateInString;
    }

}
