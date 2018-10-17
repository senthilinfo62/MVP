package multipleimagepicker.com.mvp.View.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    public static Retrofit NetWorkClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cognitisummits.com/mgfp/mobile/") //LiveURL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
