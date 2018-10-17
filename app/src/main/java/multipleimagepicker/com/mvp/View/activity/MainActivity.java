package multipleimagepicker.com.mvp.View.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import multipleimagepicker.com.mvp.Model.LoginResponse;
import multipleimagepicker.com.mvp.R;
import multipleimagepicker.com.mvp.View.mvp_view.MainviewPresenter;
import multipleimagepicker.com.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainviewPresenter.View {
    MainPresenter mainPresenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      mainPresenter=new MainPresenter(this,this);


        getFeed();
    }

    private void getFeed() {
        mainPresenter.callMethos();
    }


    @Override
    public void onsuccess(LoginResponse feedResponse) {
       


    }

    @Override
    public void onerror(String message) {
        Log.e("success",message);
    }
}
