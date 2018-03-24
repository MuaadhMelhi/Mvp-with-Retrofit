package nyc.muaadh_melhi_develpoer.mvp_example_android;

import java.util.List;

import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;

/**
 * Main Contructor
 */

public interface GetDataContract {
    interface View {
        void getDataSuccess(List<CountryRes> countriesData);

        void getDataFailure(String message);
    }

    interface Presenter {
        void getDatafromUrl();
    }

    interface Interactor {
        void initRetrofit();

    }

    interface PassDataListner {
        void onSuccess(List<CountryRes> countryResList);
        void onFailure(String message);
    }


}
