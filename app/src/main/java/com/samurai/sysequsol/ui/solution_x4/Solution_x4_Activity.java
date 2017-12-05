package com.samurai.sysequsol.ui.solution_x4;

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
import com.samurai.sysequsol.ui.General_Methods;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Serg on 21.05.2017.
 */

public class Solution_x4_Activity extends Activity {

    // inputs grid layoyt
    @BindView(R.id.sys4_gl_inputs)
    GridLayout sys4_gl_inputs;

    // main det layout container
    @BindView(R.id.sys4_full_solution)
    LinearLayout sys4_full_solution;

    // main det container layout
    @BindView(R.id.sys4_h_lay_det_calc)
    LinearLayout sys4_h_lay_det_calc;
    // main det layout (values)
    @BindView(R.id.sys4_gl_det)
    GridLayout sys4_gl_det;
    // main det value
    @BindView(R.id.sys4_det_calc_eq_before)
    TextView sys4_det_calc_eq_before;

    // if system does not have solytion
    @BindView(R.id.sys4_not_solutable)
    TextView sys4_not_solutable;

    // det1234 solution layoyt
    @BindView(R.id.sys4_v_lay_det1_2)
    LinearLayout sys4_v_lay_det1_2;

    // det1 layout (values)
    @BindView(R.id.sys4_gl_det1)
    GridLayout sys4_gl_det1;
    // det1 value
    @BindView(R.id.sys4_det1_calc_eq_before)
    TextView sys4_det1_calc_eq_before;

    // det2 layout (values)
    @BindView(R.id.sys4_gl_det2)
    GridLayout sys4_gl_det2;
    // det2 value
    @BindView(R.id.sys4_det2_calc_eq_before)
    TextView sys4_det2_calc_eq_before;

    // det3 layout (values)
    @BindView(R.id.sys4_gl_det3)
    GridLayout sys4_gl_det3;
    // det3 value
    @BindView(R.id.sys4_det3_calc_eq_before)
    TextView sys4_det3_calc_eq_before;

    // det4 layout (values)
    @BindView(R.id.sys4_gl_det4)
    GridLayout sys4_gl_det4;
    // det4 value
    @BindView(R.id.sys4_det4_calc_eq_before)
    TextView sys4_det4_calc_eq_before;

    // variable values

    // layout of variable values
    @BindView(R.id.sys4_var_final_val)
    LinearLayout sys4_var_final_val;

    // var1 lay
    @BindView(R.id.sys4_v_lay_det1_val)
    LinearLayout sys4_v_lay_det1_val;
    // var1 val
    @BindView(R.id.sys4_var1_value)
    TextView sys4_var1_value;

    // var2 lay
    @BindView(R.id.sys4_v_lay_det2_val)
    LinearLayout sys4_v_lay_det2_val;
    // var2 val
    @BindView(R.id.sys4_var2_value)
    TextView sys4_var2_value;

    // va3 lay
    @BindView(R.id.sys4_v_lay_det3_val)
    LinearLayout sys4_v_lay_det3_val;
    // var3 val
    @BindView(R.id.sys4_var3_value)
    TextView sys4_var3_value;

    // var4 lay
    @BindView(R.id.sys4_v_lay_det4_val)
    LinearLayout sys4_v_lay_det4_val;
    // var4 val
    @BindView(R.id.sys4_var4_value)
    TextView sys4_var4_value;

    private General_Methods gm = new General_Methods();
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_x4);
        ButterKnife.bind(this);

        // Uncoment before publishing
        banner = (Banner) findViewById(R.id.adView_x4);

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
        int count = sys4_gl_inputs.getChildCount();
        for (int k = 0;k<count; k++) {
            View v = sys4_gl_inputs.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                //e.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(10, 3) });
            }
        }
    }

    @OnClick(R.id.sys4_btn_back)
    public void back(View view) {
        onBackPressed();
    }

    @OnClick(R.id.sys4_btn_fill)
    public void sys4_fill(View view) {
        int mass[][] = gm.generic_rand_array(4, 5);
        int count = sys4_gl_inputs.getChildCount();
        int f = mass[0].length;
        int d = mass[1].length;
        for (int k = 0, i = 0, j = 0; k < count && i < f && j < d; k++) {
            View v = sys4_gl_inputs.getChildAt(k);
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

    @OnClick(R.id.sys4_btn_calc)
    public void calculate(View view) {
        Context con = getApplicationContext();
        if (!gm.input_is_empty(sys4_gl_inputs,con)) {
            // Get input data
            Solution_x4_Logic obj = new Solution_x4_Logic(gm.get_input_data(sys4_gl_inputs, 4, 5));
            // Set values main det
            gm.set_determinant_values(sys4_gl_det, obj.getSrc_arr());
            // Set main det value
            sys4_det_calc_eq_before.setText(gm.set_det_value(obj.getMain_det_val()));

            // Check if no view has focus:
            View vieww = this.getCurrentFocus();
            if (vieww != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            // Condition for reusage
            gm.hide(sys4_full_solution);
            gm.hide(sys4_not_solutable);
            gm.hide(sys4_v_lay_det1_2);
            gm.hide(sys4_var_final_val);

            // Show if system not have solution
            if (!obj.getIs_have_sol()) {
                gm.show_hide(sys4_full_solution);
                gm.show_hide(sys4_not_solutable);
                gm.hide(sys4_var_final_val);
            } else {
                // Set values det1
                gm.set_determinant_values(sys4_gl_det1, obj.getDet1_arr());
                // Set det1 value
                sys4_det1_calc_eq_before.setText(gm.set_det_value(obj.getDet1_val()));

                // Set values det2
                gm.set_determinant_values(sys4_gl_det2, obj.getDet2_arr());
                // Set det2 value
                sys4_det2_calc_eq_before.setText(gm.set_det_value(obj.getDet2_val()));

                // Set values det3
                gm.set_determinant_values(sys4_gl_det3, obj.getDet3_arr());
                // Set det3 value
                sys4_det3_calc_eq_before.setText(gm.set_det_value(obj.getDet3_val()));

                // Set values det4
                gm.set_determinant_values(sys4_gl_det4, obj.getDet4_arr());
                // Set det4 value
                sys4_det4_calc_eq_before.setText(gm.set_det_value(obj.getDet4_val()));

                // Set variable values
                DecimalFormat f = new DecimalFormat("#.###");

                // Set fraction (X1)
                gm.set_fraction(sys4_v_lay_det1_val, obj.getDet1_val(), obj.getMain_det_val());
                // Set var1 val
                String var1 = "=" + f.format(obj.getDet1_val() / obj.getMain_det_val()) + ";";
                sys4_var1_value.setText(var1);

                // Set fraction (X2)
                gm.set_fraction(sys4_v_lay_det2_val, obj.getDet2_val(), obj.getMain_det_val());
                // Set var2 val
                String var2 = "=" + f.format(obj.getDet2_val() / obj.getMain_det_val()) + ";";
                sys4_var2_value.setText(var2);

                // Set fraction (X3)
                gm.set_fraction(sys4_v_lay_det3_val, obj.getDet3_val(), obj.getMain_det_val());
                // Set var3 val
                String var3 = "=" + f.format(obj.getDet3_val() / obj.getMain_det_val()) + ";";
                sys4_var3_value.setText(var3);

                // Set fraction (X4)
                gm.set_fraction(sys4_v_lay_det4_val, obj.getDet4_val(), obj.getMain_det_val());
                // Set var4 val
                String var4 = "=" + f.format(obj.getDet4_val() / obj.getMain_det_val()) + ";";
                sys4_var4_value.setText(var4);

                // Show solution
                // Show main det solution
                gm.show_hide(sys4_full_solution);
                // Show detailed solution
                gm.hide(sys4_not_solutable);
                gm.show_hide(sys4_v_lay_det1_2);
                gm.show_hide(sys4_var_final_val);
            }
        }
    }

}
