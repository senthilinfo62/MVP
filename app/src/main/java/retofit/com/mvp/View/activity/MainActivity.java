package retofit.com.mvp.View.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;


import retofit.com.mvp.Model.CountryModel;
import retofit.com.mvp.R;
import retofit.com.mvp.View.Adapter.CountryAdapter;
import retofit.com.mvp.View.mvp_view.MainviewPresenter;
import retofit.com.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainviewPresenter.View {
    MainPresenter mainPresenter;
    private ProgressDialog dialog;

    RecyclerView recyclerView;
    private CountryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      mainPresenter=new MainPresenter(this,this);
      recyclerView=(RecyclerView)findViewById(R.id.recyclerview);


        getFeed();
    }

    private void getFeed() {
        mainPresenter.callMethos();
    }



    @Override
    public void onsuccess(ArrayList<CountryModel> feedResponse) {
        mAdapter = new CountryAdapter(feedResponse,MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onerror(String message) {
        Log.e("error",message);
    }
}
