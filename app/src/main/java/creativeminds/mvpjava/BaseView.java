package creativeminds.mvpjava;

public interface BaseView {
    //shows the progress to user
    void showProgress();

    //dismiss the progress
    void dismissProgress();

    //displaying internet error message to user
    void showInternetError();

    //handling failure response
    void onFailure(Throwable t, int request);
}
