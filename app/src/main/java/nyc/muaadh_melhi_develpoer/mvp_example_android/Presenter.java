package nyc.muaadh_melhi_develpoer.mvp_example_android;

import android.util.Log;

import java.util.List;

import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;

/**
 * Created by Muaadh on 3/21/18.
 */

public class Presenter implements GetDataContract.Presenter, GetDataContract.PassDataListner {
    private GetDataContract.View mGetDataView;
    private Interactor mInteractor;

    public Presenter(GetDataContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        this.mInteractor = new Interactor(this);
    }

    //need to pass the info from the interactor to >>>Presenter
    @Override
    public void getDatafromUrl() {
        mInteractor.initRetrofit();
    }

    //Presenter need to pass data to >>>>the view using middle man(PassData Interface)
    @Override
    public void onSuccess(List<CountryRes> countryResList) {
        mGetDataView.getDataSuccess(countryResList);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.getDataFailure(message);
    }
}
