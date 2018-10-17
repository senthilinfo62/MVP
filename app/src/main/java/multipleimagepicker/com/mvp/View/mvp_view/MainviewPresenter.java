package multipleimagepicker.com.mvp.View.mvp_view;

import multipleimagepicker.com.mvp.Model.Country;

public interface MainviewPresenter {
    interface View{
        void onsuccess(Country feedResponse);
        void onerror(String message);
    }
    interface Presenter{
        void callMethos();
    }
}
