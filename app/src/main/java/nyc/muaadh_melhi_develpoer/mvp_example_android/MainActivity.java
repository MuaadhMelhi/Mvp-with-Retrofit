package nyc.muaadh_melhi_develpoer.mvp_example_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;
import nyc.muaadh_melhi_develpoer.mvp_example_android.recycleview.CountryAdapter;

public class MainActivity extends AppCompatActivity implements GetDataContract.View {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private Presenter mPresenter;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new Presenter(this);
        mPresenter.getDatafromUrl();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void getDataSuccess(List<CountryRes> countriesData) {
        //then pass the data to the adapter
        countryAdapter = new CountryAdapter(countriesData);
        recyclerView.setAdapter(countryAdapter);
    }

    @Override
    public void getDataFailure(String message) {
        Log.d("getDataFailure: ", message);
    }
}
