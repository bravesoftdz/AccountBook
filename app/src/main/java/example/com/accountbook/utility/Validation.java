package example.com.accountbook.utility;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Spinner;

import example.com.accountbook.R;

/**
 * Created by c49 on 01/02/16.
 */
public class Validation {

    public static boolean chkRequired(Context context,EditText editText,String errorMeaasge,int minLen,int maxLen){
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);

        String text=editText.getText().toString().trim();
        if(text.length()<minLen){
            editText.requestFocus();

            editText.setBackgroundResource(R.drawable.textbox_bg_error);
            editText.startAnimation(shake);
           // Toast.makeText(context,errorMeaasge,Toast.LENGTH_LONG).show();
            return false;
        }
        else if(text.length()<minLen||text.length()>maxLen){
            editText.requestFocus();
            editText.setBackgroundResource(R.drawable.textbox_bg_error);
          //  Toast.makeText(context,errorMeaasge,Toast.LENGTH_LONG).show();
            editText.startAnimation(shake);
            return false;
        }
        else{
            editText.setBackgroundResource(R.drawable.textbox_bg);
            return true;
        }

    }
    public static boolean chkSpinnerItemSelected(Context context,Spinner spinner){
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
        int selectedItem=spinner.getSelectedItemPosition();
                if(selectedItem>0){
                    spinner.setBackgroundResource(R.drawable.textbox_bg);
                    return true;
                }
            else{
                    spinner.setBackgroundResource(R.drawable.textbox_bg_error);
                    spinner.startAnimation(shake);
                    return false;
                }

    }
    public static boolean chkemailAddress(Context context,EditText editText,String errorMessage,int minLen,int maxLen){
        String emaiText=editText.getText().toString().trim();
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
        if(emaiText.length()>minLen){
            if(emaiText.length()>maxLen){
                editText.requestFocus();
                editText.setBackgroundResource(R.drawable.textbox_bg_error);
                editText.startAnimation(shake);
               // Toast.makeText(context,"Your email address lenght must not exceed "+maxLen+" character",Toast.LENGTH_LONG).show();
                return false;
            }
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emaiText).matches()){
                editText.requestFocus();
                editText.setBackgroundResource(R.drawable.textbox_bg_error);
                editText.startAnimation(shake);
               // Toast.makeText(context,errorMessage,Toast.LENGTH_LONG).show();
                return false;
            }


        }
        editText.setBackgroundResource(R.drawable.textbox_bg);
        return true;
    }
}
