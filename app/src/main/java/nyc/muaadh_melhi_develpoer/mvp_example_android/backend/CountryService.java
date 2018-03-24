package nyc.muaadh_melhi_develpoer.mvp_example_android.backend;

import java.util.List;

import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 3/24/18.
 */

public interface CountryService {
    @GET("all")
    Call<List<CountryRes>> getAllCountry();
}
