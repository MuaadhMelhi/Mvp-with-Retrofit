package nyc.muaadh_melhi_develpoer.mvp_example_android;

import android.app.Application;
import android.content.Context;

/**
 * Created by Muaadh on 3/24/18.
 */

public class App extends Application {
    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = this;
    }

    public static Context getContext() {
        return mcontext;
    }
}
