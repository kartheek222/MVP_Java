package creativeminds.mvpjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginPresenter presenter = new LoginPresenter(this, this, getLifecycle());

        presenter.doLogin("email", "password");
    }

    @Override
    public void onLoginSuccess(JSONObject login) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showInternetError() {

    }

    @Override
    public void onFailure(Throwable t, int request) {

    }
}
