package multipleimagepicker.com.mvp.View.network;


import multipleimagepicker.com.mvp.Model.CountryResponse;
import multipleimagepicker.com.mvp.Model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NetworkInterface {
    @Headers("Content-Type:application/json")
    @GET("getCountries")
    Call<CountryResponse> getLogin();
}
