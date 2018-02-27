package com.micste.slmvp.info;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.micste.slmvp.R;
import com.micste.slmvp.netcom.ApiClient;
import com.micste.slmvp.netcom.model.ResponseData;

public class InfoActivity extends AppCompatActivity implements InfoView, View.OnClickListener {

    private RecyclerView list_subway, list_trains, list_buses;
    private ProgressBar progressBar;
    private TextView lastUpdateText;
    private Button buttonSubway, buttonTrain, buttonBus;
    private InfoPresenter presenter;
    private int btnColorActive, btnColorDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setup();
    }

    private void setup() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressBar = findViewById(R.id.info_progressbar);
        lastUpdateText = findViewById(R.id.last_update);
        buttonSubway = findViewById(R.id.btn_subway);
        buttonSubway.setOnClickListener(this);
        buttonTrain = findViewById(R.id.btn_train);
        buttonTrain.setOnClickListener(this);
        buttonBus = findViewById(R.id.btn_bus);
        buttonBus.setOnClickListener(this);
        list_subway = findViewById(R.id.recyclerview_subway);
        list_subway.setLayoutManager(new LinearLayoutManager(this));
        list_trains = findViewById(R.id.recyclerview_trains);
        list_trains.setLayoutManager(new LinearLayoutManager(this));
        list_buses = findViewById(R.id.recyclerview_buses);
        list_buses.setLayoutManager(new LinearLayoutManager(this));
        btnColorActive = ContextCompat.getColor(this, R.color.colorLightBlue);
        btnColorDefault = ContextCompat.getColor(this, R.color.colorPrimary);

        presenter = new InfoPresenter(new InfoInteractorImpl());
        presenter.attach(this);
        presenter.getInfo(getSiteId(), ApiClient.DEFAULT_TIME);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                presenter.getInfo(getSiteId(), ApiClient.DEFAULT_TIME);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void showToast(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setData(ResponseData data) {
        list_subway.setAdapter(new InfoAdapter(this, data.getMetros()));
        list_trains.setAdapter(new InfoAdapter(this, data.getTrains()));
        list_buses.setAdapter(new InfoAdapter(this, data.getBuses()));
        lastUpdateText.setText(getResources().getString(R.string.last_update) + data.getLatestUpdate());
    }

    private String getSiteId() {
        return getIntent().getStringExtra("ID");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_subway:
                presenter.showSubway();
                break;
            case R.id.btn_bus:
                presenter.showBuses();
                break;
            case R.id.btn_train:
                presenter.showTrains();
                break;
        }
    }

    @Override
    public void showBuses() {
        list_trains.setVisibility(View.GONE);
        list_subway.setVisibility(View.GONE);
        list_buses.setVisibility(View.VISIBLE);
        buttonBus.setBackgroundColor(btnColorActive);
        buttonSubway.setBackgroundColor(btnColorDefault);
        buttonTrain.setBackgroundColor(btnColorDefault);
    }

    @Override
    public void showTrains() {
        list_subway.setVisibility(View.GONE);
        list_buses.setVisibility(View.GONE);
        list_trains.setVisibility(View.VISIBLE);
        buttonTrain.setBackgroundColor(btnColorActive);
        buttonSubway.setBackgroundColor(btnColorDefault);
        buttonBus.setBackgroundColor(btnColorDefault);
    }

    @Override
    public void showSubway() {
        list_trains.setVisibility(View.GONE);
        list_buses.setVisibility(View.GONE);
        list_subway.setVisibility(View.VISIBLE);
        buttonSubway.setBackgroundColor(btnColorActive);
        buttonTrain.setBackgroundColor(btnColorDefault);
        buttonBus.setBackgroundColor(btnColorDefault);
    }
}
