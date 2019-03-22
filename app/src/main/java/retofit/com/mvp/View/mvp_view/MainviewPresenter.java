package retofit.com.mvp.View.mvp_view;

import java.util.ArrayList;


import retofit.com.mvp.Model.CountryModel;

public interface MainviewPresenter {
    interface View{
        void onsuccess(ArrayList<CountryModel> feedResponse);
        void onerror(String message);
    }
    interface Presenter{
        void callMethos();
    }
}
