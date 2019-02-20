package creativeminds.mvpjava;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;

import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenter(Context context, LoginContract.View view, Lifecycle lifecycleData) {
        super(lifecycleData);
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        //after validation and network checks

        mCompositeDisposable.add(getAPiService().login(new JSONObject())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new NetworkSingleCallBack<JSONObject>(view, 51) {


                    @Override
                    void onSuccess(JSONObject jsonObject, int request) {
                        view.onLoginSuccess(jsonObject);
                    }

                    @Override
                    void onFailure(Throwable e, int request) {
                        view.onFailure(e, request);
                    }
                }));

    }
}
