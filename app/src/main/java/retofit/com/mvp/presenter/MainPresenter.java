package retofit.com.mvp.presenter;


import retofit.com.mvp.Model.CountryResponse;
import retofit.com.mvp.Model.LoginResponse;
import retofit.com.mvp.View.activity.MainActivity;
import retofit.com.mvp.View.mvp_view.MainviewPresenter;
import retofit.com.mvp.View.network.NetworkClient;
import retofit.com.mvp.View.network.NetworkInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainviewPresenter.Presenter {

    LoginResponse loginResponse;
    MainviewPresenter.View mView;
    NetworkInterface apiInterface;
    public MainPresenter(MainActivity mainActivity, MainActivity mainActivity1) {
        mView=mainActivity;
        apiInterface= NetworkClient.NetWorkClient().create(NetworkInterface.class);

    }

    @Override
    public void callMethos() {
        Call<CountryResponse> call = apiInterface.getLogin();
        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse feedResponse = response.body();
                if(feedResponse.getIsSuccess()){
                    mView.onsuccess(feedResponse.getResponse());

                }else{
                    String msg=feedResponse.getUserMessage();
                    mView.onerror(msg);
                }

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });

    }
}
