package multipleimagepicker.com.mvp.presenter;

import multipleimagepicker.com.mvp.Model.LoginResponse;
import multipleimagepicker.com.mvp.View.activity.MainActivity;
import multipleimagepicker.com.mvp.View.mvp_view.MainviewPresenter;
import multipleimagepicker.com.mvp.View.network.NetworkClient;
import multipleimagepicker.com.mvp.View.network.NetworkInterface;
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
        Call<LoginResponse> call = apiInterface.getLogin();
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse feedResponse = response.body();
                if(feedResponse.getStatus().equals("1")){
                    mView.onsuccess(feedResponse);

                }else{
                    String msg=feedResponse.getMessage();
                    mView.onerror(msg);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
