package org.tasafo.tasafoconf.io.json.io.retrofit;

import org.tasafo.tasafoconf.io.json.model.Feedback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Retrofit interface.
 *
 * Created by ramonrabello on 19/11/15.
 */
public interface GoogleFormsService {

    @FormUrlEncoded
    @POST("forms/d/1SDfTi2_Q4I4XmdTmO9zUyv6QRQZIO9KJ78aZBKT-NmM/formResponse")
    Call<Void> sendFeedback(@Field("entry_2127565309") String category, @Field("entry_294440537") String type, @Field("entry.1558690542") String content, Callback<Feedback> callback);
}
