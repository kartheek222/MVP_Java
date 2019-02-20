package creativeminds.mvpjava;

import org.json.JSONObject;

public interface LoginContract {
    interface View extends BaseView {
        void onLoginSuccess(JSONObject login);
    }

    interface Presenter {
        void doLogin(String email, String password);
    }
}
