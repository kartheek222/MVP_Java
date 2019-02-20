package creativeminds.mvpjava;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;

abstract public class BasePresenter implements LifecycleObserver {

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private Lifecycle lifecycleData;

    public BasePresenter(Lifecycle lifecycleData) {
        lifecycleData.addObserver(this);
        this.lifecycleData = lifecycleData;
    }

    public Lifecycle getLifecycle() {
        return lifecycleData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        //clearing all ongoing requests
        mCompositeDisposable.dispose();

        //unregister life cycle observer
        lifecycleData.removeObserver(this);

    }

    public AdminwalaAPI getAPiService() {
        return ApiService.getApiService();
    }


}