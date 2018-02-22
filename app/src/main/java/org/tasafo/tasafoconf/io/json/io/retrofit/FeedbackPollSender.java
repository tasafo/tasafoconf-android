package org.tasafo.tasafoconf.io.json.io.retrofit;

import org.tasafo.tasafoconf.io.json.model.Feedback;

import java.io.IOException;

/**
 * Created by ramonrabello on 19/11/15.
 */
public class FeedbackPollSender {

    private static final String BASE_URL = "https://docs.google.com";

    public static void sendFeedback(Feedback feedback) throws IOException {
//        final boolean feedbackWasSent;
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
//        GoogleFormsService apiService = retrofit.create(GoogleFormsService.class);
//        apiService.sendFeedback(feedback.getCategory(), feedback.getType(), feedback.getContent(), new Callback<Feedback>() {
//
//            @Override
//            public void onResponse(Response<Feedback> response, Retrofit retrofit) {
//                if (response.isSuccess()) {
//                    //viewsToBeUpdated[0]
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                feedbackWasSent = false;
//            }
//        });
//        return feedbackWasSent;

//
//        HashMap params = new HashMap();
//
//        // category
//        params.put("entry.2127565309", feedback.getCategory());
//
//        // type
//        params.put("entry.294440537", feedback.getType());
//
//        // content
//        params.put("entry.1558690542", feedback.getContent());
//
//        Call<Response> call = googleFormsService.sendFeedback(params);
//        Response<Response> response = call.execute();
//        call.enqueue(new Callback<Feedback>() {
//            @Override
//            public void onResponse(Response<Feedback> response, Retrofit retrofit) {
//                int statusCode = response.code();
//                Feedback user = response.body();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                // Log error here since request failed
//            }
//
        //});
    }
}
