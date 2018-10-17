package multipleimagepicker.com.mvp.View.mvp_view;

import multipleimagepicker.com.mvp.Model.LoginResponse;

public interface MainviewPresenter {
    interface View{
        void onsuccess(LoginResponse feedResponse);
        void onerror(String message);
    }
    interface Presenter{
        void callMethos();
    }
}
