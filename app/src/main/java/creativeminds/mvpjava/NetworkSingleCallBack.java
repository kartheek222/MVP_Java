package creativeminds.mvpjava;

import io.reactivex.observers.DisposableSingleObserver;


abstract class NetworkSingleCallBack<T> extends DisposableSingleObserver<T> {

    private final int request;
    private BaseView baseView;

    public NetworkSingleCallBack(BaseView view, int i) {
        this.baseView = view;
        this.request = i;
    }

    @Override
    public void onSuccess(T t) {
        baseView.dismissProgress();
        onSuccess(t, request);
    }

    @Override
    public void onError(Throwable e) {
        baseView.dismissProgress();
        onFailure(e, request);

    }


    //network api success
    abstract void onSuccess(T t, int request);

    //api failure
    abstract void onFailure(Throwable e, int request);


}