package example.com.accountbook;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by c49 on 29/03/16.
 */
public class AccountBook extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();

    }
}
