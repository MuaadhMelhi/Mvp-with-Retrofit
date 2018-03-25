package nyc.muaadh_melhi_develpoer.mvp_example_android;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
        checkOrientation();
    }

    private void checkOrientation() {
        if (MainActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(GridLayoutManager.VERTICAL);
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (position % 3 == 0 ? 2 : 1);
                }
            });
            recyclerView.setLayoutManager(layoutManager);
        }
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
