package lab.pam.pwr.pam_lab1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.Gravity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        /**
         * Center snapping
         */

        //      SnapHelper snapHelper = new LinearSnapHelper();
//snapHelper.attachToRecyclerView(recyclerView);


        /*
        startRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
snapHelperStart.attachToRecyclerView(startRecyclerView);*/

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            recyclerView.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false));

            SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
            snapHelperStart.attachToRecyclerView(recyclerView);
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false));

            SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
            snapHelperStart.attachToRecyclerView(recyclerView);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);


        SnapRecyclerAdapter adapter = new SnapRecyclerAdapter(this, (ArrayList<Photo>) PhotosKeeper.getInstance().getItems(), height, width);
        recyclerView.setAdapter(adapter);

    }
}