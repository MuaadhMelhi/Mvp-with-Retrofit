package nyc.muaadh_melhi_develpoer.mvp_example_android;

import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.mvp_example_android.backend.CountryService;
import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.PATCH;

/**
 * Created by Muaadh on 3/23/18.
 */

public class Interactor implements GetDataContract.Interactor {
    //need to pass data to middleMan(Interface PassData)
    GetDataContract.PassDataListner passDataListner;
    private CountryService countryService;
    private final String BASE_URL = "https://restcountries.eu/rest/v2/";

    public Interactor(GetDataContract.PassDataListner passDataListner) {
        this.passDataListner = passDataListner;
    }

    @Override
    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(App.getContext().getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        countryService = retrofit.create(CountryService.class);
        Call<List<CountryRes>> countryCall = countryService.getAllCountry();
        countryCall.enqueue(new Callback<List<CountryRes>>() {
            @Override
            public void onResponse(Call<List<CountryRes>> call, Response<List<CountryRes>> response) {
                passDataListner.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryRes>> call, Throwable t) {
                passDataListner.onFailure(t.getMessage());

            }
        });


    }
}
