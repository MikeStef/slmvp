package com.micste.slmvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.micste.slmvp.R;
import com.micste.slmvp.netcom.model.Station;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StationsView{

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private EditText userInput;
    private StationsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        progressBar = findViewById(R.id.main_progressbar);
        recyclerView = findViewById(R.id.stations_list);
        userInput = findViewById(R.id.input_text);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getStations(userInput.getText().toString());
            }
        });

        presenter = new StationsPresenter(new StationsInteractorImpl());
        presenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void showToast(int message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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
    public void setData(List<Station> data) {
        recyclerView.setAdapter(new StationsAdapter(this, data));
    }
}
