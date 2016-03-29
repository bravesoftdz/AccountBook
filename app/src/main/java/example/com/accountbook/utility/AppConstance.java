package example.com.accountbook.utility;

/**
 * Created by c49 on 25/03/16.
 */
public class AppConstance {


    /**
     * URLS....
     */
    public static final String BASE_URL="https://sspmobile.openroadsdemo.com/opentms/ssp/";
    public static final String RECHABLE_URL="https://sspmobile.openroadsdemo.com/opentms/ssp/assistCause";
    public static final String LOGIN_URL=BASE_URL+"driver/login";
    public static final String LOGIN_COMPLETE_URL=BASE_URL+"driver/completeLogin";
    public static final String ASSIST_CAUSE_URL=BASE_URL+"assistCause";


    /**
     * END URLS
     */
    public static final String USERNAME="techark.test";
    public static final String PASSWORD="techark";
    public static final String PREFERENCE_KEY_USERNAME="username";
    public static final String PREFERENCE_KEY_PASSWORD="password";
    public static final String SELLER_ID="seller_id";
    public static final String TRANSACTION_ID="transaction_id";

    public static final int REQUEST_LOGIN = 1;
    public static final int REQUEST_LOGIN_COMPLETE = 2;
    public static final int REQUEST_ASSIST_CAUSE = 3;

    /**
     * http methods
     */
    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 2;
    public static final int METHOD_PUT = 3;
    public static final int METHOD_DELETE = 4;


    public static final String PREFERENCE_NAME="qfree_credential";
    public static final String PREFERENCE_KEY_USERINFO="user_info";

    /*
    * System messages
    *
    * **/
    public static final String INTERNET_CONNECTION_MESSAGE="Make sure network connection is ON.";
    public static final String AUTHORIZATION_FAILED_MESSAGE="Authorization failed.";
    public static final String SOCKET_TIME_OUT_MESSAGE="Request time out, try again.";
    public static final String UNKNOWN_ERROR_MESSAGE="Unknown error, try again.";
    public static final String SENDING_MESSAGE="Sending data to server";

}
