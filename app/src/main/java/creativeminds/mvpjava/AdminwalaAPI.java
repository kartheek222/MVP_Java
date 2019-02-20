package creativeminds.mvpjava;

import org.json.JSONObject;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ramesh on 11/11/2017.
 */
interface AdminwalaAPI {

    @POST(Appconstants.LOGIN)
    Single<JSONObject> login(@Body JSONObject payload);

}