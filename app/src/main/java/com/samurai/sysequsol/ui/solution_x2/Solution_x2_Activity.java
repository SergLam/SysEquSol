package com.samurai.sysequsol.ui.solution_x2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mobfox.sdk.bannerads.Banner;
import com.mobfox.sdk.bannerads.BannerListener;
import com.samurai.sysequsol.R;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.samurai.sysequsol.ui.General_Methods;

/**
 * Created by Sergey on 24.04.2017.
 */

public class Solution_x2_Activity extends Activity {

    // Input grid layout
    @BindView(R.id.sys2_gl_inputs)
    GridLayout sys2_gl_inputs;

    // Main det layout
    @BindView(R.id.sys2_v_lay_det)
    LinearLayout sys2_v_lay_det;

    // Grid layoyt (main det values)
    @BindView(R.id.sys2_gl_det)
    GridLayout sys2_gl_det;

    // Main det solution
    @BindView(R.id.sys2_det_calc_field)
    EditText sys2_det_calc_field;

    // If system has no solution
    @BindView(R.id.sys2_not_solutable)
    TextView sys2_not_solutable;

    // Detailed solution layout
    @BindView(R.id.sys2_v_lay_det1_2)
    LinearLayout sys2_v_lay_det1_2;
    // det1 gridlayout
    @BindView(R.id.sys2_gl_det1)
    GridLayout sys2_gl_det1;
    // det1 solution
    @BindView(R.id.sys2_det1_calc_field)
    EditText sys2_det1_calc_field;
    // det2 gridlayout
    @BindView(R.id.sys2_gl_det2)
    GridLayout sys2_gl_det2;
    // det2 solution
    @BindView(R.id.sys2_det2_calc_field)
    EditText sys2_det2_calc_field;

    // FINALLY!
    // var1 vertical lay - var calculation
    @BindView(R.id.sys2_v_lay_det_values)
    LinearLayout sys2_v_lay_det_values;
    // var1 value
    @BindView(R.id.sys2_var1_value)
    TextView sys2_var1_value;

    // var2 vertical lay - var calculation
    @BindView(R.id.sys2_v_lay_det2_val)
    LinearLayout sys2_v_lay_det2_val;
    // var2 value
    @BindView(R.id.sys2_var2_value)
    TextView sys2_var2_value;

    private General_Methods gm = new General_Methods();
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_x2);
        ButterKnife.bind(this);

        // Uncoment before publishing
        banner = (Banner) findViewById(R.id.adView_x2);

        final Activity self = this;
        banner.setListener(new BannerListener() {
            @Override
            public void onBannerError(View banner, Exception e) {
//                Toast.makeText(self, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onBannerLoaded(View banner) {
//                Toast.makeText(self, "loaded", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onBannerClosed(View banner) {
//                Toast.makeText(self, "closed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onBannerFinished() {
//                Toast.makeText(self, "finished", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onBannerClicked(View banner) {
//                Toast.makeText(self, "clicked", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNoFill(View banner) {
//                Toast.makeText(self, "no fill", Toast.LENGTH_SHORT).show();
            }
        });
        banner.setInventoryHash(getResources().getString(R.string.mobfox_prod));
        banner.load();
    }

    //permission dialog for marshmello and above
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        banner.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //add this so video ads will work properly
    @Override
    protected void onPause() {
        super.onPause();
        banner.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.onResume();
    }

    @Override
    protected void onStart(){
        super.onStart();
        // Set input filters for edittext
        int count = sys2_gl_inputs.getChildCount();
        for (int k = 0;k<count; k++) {
            View v = sys2_gl_inputs.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                //e.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(10, 3) });
            }
        }
    }

    @OnClick(R.id.sys2_btn_back)
    public void back(View view) {
        onBackPressed();
    }

    @OnClick(R.id.sys2_btn_fill)
    public void sys2_fill(View view) {
        int mass[][] = gm.generic_rand_array(2, 3);
        int count = sys2_gl_inputs.getChildCount();
        int f = mass[0].length;
        int d = mass[1].length;
        for (int k = 0, i = 0, j = 0; k < count && i < f && j < d; k++) {
            View v = sys2_gl_inputs.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                e.setText(gm.its(mass[i][j]));
                // Custom condition - it's working!
                j++;
                if (j == d) {
                    i++;
                    j = 0;
                }
            }
        }
    }

    @OnClick(R.id.sys2_btn_calc)
    public void calculate(View view) {
        Context con = getApplicationContext();
        if (!gm.input_is_empty(sys2_gl_inputs, con)) {
            // Get input data
            Solution_x2_Logic obj = new Solution_x2_Logic(gm.get_input_data(sys2_gl_inputs, 2, 3));
            // Set values main det

            gm.set_determinant_values(sys2_gl_det, obj.getSrc_arr());
            // Set detailed solution
            sys2_det_calc_field.setText(obj.getMain_det_sol());

            // Check if no view has focus:
            View vieww = this.getCurrentFocus();
            if (vieww != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            // Condition for reusage
            gm.hide(sys2_v_lay_det);
            gm.hide(sys2_not_solutable);
            gm.hide(sys2_v_lay_det1_2);

            // Show if system not have solution
            if (!obj.getIs_have_sol()) {
                gm.show_hide(sys2_v_lay_det);
                gm.show_hide(sys2_not_solutable);
            } else {
                // Set values det1
                gm.set_determinant_values(sys2_gl_det1, obj.getDet1_arr());
                // Set det1 detailed solution
                sys2_det1_calc_field.setText(obj.getDet1_sol());
                // Set values det2
                gm.set_determinant_values(sys2_gl_det2, obj.getDet2_arr());
                // Set det 2 detailed solution
                sys2_det2_calc_field.setText(obj.getDet2_sol());

                // Set variable values
                DecimalFormat f = new DecimalFormat("#.###");
                // Set fraction (X1)
                gm.set_fraction(sys2_v_lay_det_values, obj.getDet1_val(), obj.getMain_det());
                // Set var1 val
                String var1 = "=" + f.format(obj.getDet1_val() / obj.getMain_det()) + ";";
                sys2_var1_value.setText(var1);
                // Set fraction (X2)
                gm.set_fraction(sys2_v_lay_det2_val, obj.getDet2_val(), obj.getMain_det());
                // Set var2 val
                String var2 = "=" + f.format(obj.getDet2_val() / obj.getMain_det()) + ";";
                sys2_var2_value.setText(var2);

                // Show solution
                // Show main det solution
                gm.show_hide(sys2_v_lay_det);
                // Show detailed solution
                gm.hide(sys2_not_solutable);
                gm.show_hide(sys2_v_lay_det1_2);

            }
        }
    }


}
