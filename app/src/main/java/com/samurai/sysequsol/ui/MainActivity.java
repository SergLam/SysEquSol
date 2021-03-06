package com.samurai.sysequsol.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.samurai.sysequsol.R;
import com.samurai.sysequsol.ui.solution_x2.Solution_x2_Activity;
import com.samurai.sysequsol.ui.solution_x3.Solution_x3_Activity;
import com.samurai.sysequsol.ui.solution_x4.Solution_x4_Activity;
import com.samurai.sysequsol.ui.solution_x5.Solution_x5_Activity;
import com.samurai.sysequsol.ui.solution_x6.Solution_x6_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Buttons
    @BindView(R.id.btn_2x2)
    Button btn_2x2;
    @BindView(R.id.btn_3x3)
    Button btn_3x3;
    @BindView(R.id.btn_4x4)
    Button btn_4x4;
    @BindView(R.id.btn_5x5)
    Button btn_5x5;
    @BindView(R.id.btn_6x6)
    Button btn_6x6;

    @BindView(R.id.theory_lb)
    TextView theor_lb;
    @BindView(R.id.main_act_hide_lay)
    RelativeLayout main_act_hide_lay;

    private General_Methods gm = new General_Methods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    //add this so video ads will work properly
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.btn_close)
    public void close_app(View view) {
        finish();
    }

    @OnClick(R.id.theory_lb)
    public void show_theory(View view) {
        gm.show_hide(main_act_hide_lay);
        if (main_act_hide_lay.getVisibility() == View.VISIBLE) {
            theor_lb.setText(R.string.main_faq_hide);
        } else theor_lb.setText(R.string.main_faq_vis);
    }

    @OnClick(R.id.btn_2x2)
    public void x2_solution(View view) {
        Intent myIntent = new Intent(MainActivity.this, Solution_x2_Activity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @OnClick(R.id.btn_3x3)
    public void x3_solution(View view) {
        Intent myIntent = new Intent(MainActivity.this, Solution_x3_Activity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @OnClick(R.id.btn_4x4)
    public void x4_solution(View view) {
        Intent myIntent = new Intent(MainActivity.this, Solution_x4_Activity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @OnClick(R.id.btn_5x5)
    public void x5_solution(View view) {
        Intent myIntent = new Intent(MainActivity.this, Solution_x5_Activity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @OnClick(R.id.btn_6x6)
    public void x6_solution(View view) {
        Intent myIntent = new Intent(MainActivity.this, Solution_x6_Activity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @OnClick(R.id.rateAppImg)
    public void rate_app(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + this.getPackageName())));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }

}
