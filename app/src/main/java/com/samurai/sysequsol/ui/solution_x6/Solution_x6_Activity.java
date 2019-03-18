package com.samurai.sysequsol.ui.solution_x6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samurai.sysequsol.R;
import com.samurai.sysequsol.ui.General_Methods;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Serg on 27.05.2017.
 */

public class Solution_x6_Activity extends Activity {

    // input grid layout
    @BindView(R.id.sys6_gl_inputs)
    GridLayout sys6_gl_inputs;

    // main det grid layout
    @BindView(R.id.sys6_gl_det)
    GridLayout sys6_gl_det;

    // formula + main det layout
    @BindView(R.id.sys6_full_solution)
    LinearLayout sys6_full_solution;

    // main det value
    @BindView(R.id.sys6_det_calc_eq_before)
    TextView sys6_det_calc_eq_before;

    // if system not solurtable
    @BindView(R.id.sys6_not_solutable)
    TextView sys6_not_solutable;

    // det1234 solution layoyt
    @BindView(R.id.sys6_v_lay_det1_2)
    LinearLayout sys6_v_lay_det1_2;

    // det1 layout (values)
    @BindView(R.id.sys6_gl_det1)
    GridLayout sys6_gl_det1;
    // det1 value
    @BindView(R.id.sys6_det1_calc_eq_before)
    TextView sys6_det1_calc_eq_before;

    // det2 layout (values)
    @BindView(R.id.sys6_gl_det2)
    GridLayout sys6_gl_det2;
    // det2 value
    @BindView(R.id.sys6_det2_calc_eq_before)
    TextView sys6_det2_calc_eq_before;

    // det3 layout (values)
    @BindView(R.id.sys6_gl_det3)
    GridLayout sys6_gl_det3;
    // det3 value
    @BindView(R.id.sys6_det3_calc_eq_before)
    TextView sys6_det3_calc_eq_before;

    // det4 layout (values)
    @BindView(R.id.sys6_gl_det4)
    GridLayout sys6_gl_det4;
    // det4 value
    @BindView(R.id.sys6_det4_calc_eq_before)
    TextView sys6_det4_calc_eq_before;

    // det5 layout (values)
    @BindView(R.id.sys6_gl_det5)
    GridLayout sys6_gl_det5;
    // det5 value
    @BindView(R.id.sys6_det5_calc_eq_before)
    TextView sys6_det5_calc_eq_before;

    // det6 layout (values)
    @BindView(R.id.sys6_gl_det6)
    GridLayout sys6_gl_det6;
    // det6 value
    @BindView(R.id.sys6_det6_calc_eq_before)
    TextView sys6_det6_calc_eq_before;

    // variable values

    // layout of variable values
    @BindView(R.id.sys6_var_final_val)
    LinearLayout sys6_var_final_val;

    // var1 lay
    @BindView(R.id.sys6_v_lay_det1_val)
    LinearLayout sys6_v_lay_det1_val;
    // var1 val
    @BindView(R.id.sys6_var1_value)
    TextView sys6_var1_value;

    // var2 lay
    @BindView(R.id.sys6_v_lay_det2_val)
    LinearLayout sys6_v_lay_det2_val;
    // var2 val
    @BindView(R.id.sys6_var2_value)
    TextView sys6_var2_value;

    // va3 lay
    @BindView(R.id.sys6_v_lay_det3_val)
    LinearLayout sys6_v_lay_det3_val;
    // var3 val
    @BindView(R.id.sys6_var3_value)
    TextView sys6_var3_value;

    // var4 lay
    @BindView(R.id.sys6_v_lay_det4_val)
    LinearLayout sys6_v_lay_det4_val;
    // var4 val
    @BindView(R.id.sys6_var4_value)
    TextView sys6_var4_value;

    // var5 lay
    @BindView(R.id.sys6_v_lay_det5_val)
    LinearLayout sys6_v_lay_det5_val;
    // var5 val
    @BindView(R.id.sys6_var5_value)
    TextView sys6_var5_value;

    // var6 lay
    @BindView(R.id.sys6_v_lay_det6_val)
    LinearLayout sys6_v_lay_det6_val;
    // var6 val
    @BindView(R.id.sys6_var6_value)
    TextView sys6_var6_value;

    private General_Methods gm = new General_Methods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_x6);
        ButterKnife.bind(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        // Set input filters for edittext
        int count = sys6_gl_inputs.getChildCount();
        for (int k = 0; k < count; k++) {
            View v = sys6_gl_inputs.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                //e.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(10, 3) });
            }
        }
    }

    @OnClick(R.id.sys6_btn_back)
    public void back(View view) {
        onBackPressed();
    }

    @OnClick(R.id.sys6_btn_fill)
    public void sys6_fill(View view) {
        int mass[][] = gm.generic_rand_array(6, 7);
        int count = sys6_gl_inputs.getChildCount();
        int f = mass[0].length;
        int d = mass[1].length;
        for (int k = 0, i = 0, j = 0; k < count && i < f && j < d; k++) {
            View v = sys6_gl_inputs.getChildAt(k);
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

    @OnClick(R.id.sys6_btn_calc)
    public void calculate(View view) {
        Context con = getApplicationContext();
        if (!gm.input_is_empty(sys6_gl_inputs, con)) {
            // Get input data
            Solution_x6_Logic obj = new Solution_x6_Logic(gm.get_input_data(sys6_gl_inputs, 6, 7));
            // Set values main det
            gm.set_determinant_values(sys6_gl_det, obj.getSrc_arr());
            // Set main det value
            sys6_det_calc_eq_before.setText(gm.set_det_value(obj.getMain_det_val()));

            // Check if no view has focus:
            View vieww = this.getCurrentFocus();
            if (vieww != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            gm.hide(sys6_full_solution);
            gm.hide(sys6_not_solutable);
            gm.hide(sys6_v_lay_det1_2);
            gm.hide(sys6_var_final_val);

            // Show if system not have solution
            if (!obj.getIs_have_sol()) {
                gm.show_hide(sys6_full_solution);
                gm.show_hide(sys6_not_solutable);
                gm.hide(sys6_var_final_val);
            } else {

                // Set values det1
                gm.set_determinant_values(sys6_gl_det1, obj.getDet1_arr());
                // Set det1 value
                sys6_det1_calc_eq_before.setText(gm.set_det_value(obj.getDet1_val()));

                // Set values det2
                gm.set_determinant_values(sys6_gl_det2, obj.getDet2_arr());
                // Set det2 value
                sys6_det2_calc_eq_before.setText(gm.set_det_value(obj.getDet2_val()));

                // Set values det3
                gm.set_determinant_values(sys6_gl_det3, obj.getDet3_arr());
                // Set det3 value
                sys6_det3_calc_eq_before.setText(gm.set_det_value(obj.getDet3_val()));

                // Set values det4
                gm.set_determinant_values(sys6_gl_det4, obj.getDet4_arr());
                // Set det4 value
                sys6_det4_calc_eq_before.setText(gm.set_det_value(obj.getDet4_val()));

                // Set values det5
                gm.set_determinant_values(sys6_gl_det5, obj.getDet5_arr());
                // Set det5 value
                sys6_det5_calc_eq_before.setText(gm.set_det_value(obj.getDet5_val()));

                // Set values det6
                gm.set_determinant_values(sys6_gl_det6, obj.getDet6_arr());
                // Set det6 value
                sys6_det6_calc_eq_before.setText(gm.set_det_value(obj.getDet6_val()));

                // Set variable values
                DecimalFormat f = new DecimalFormat("#.###");

                // Set fraction (X1)
                gm.set_fraction(sys6_v_lay_det1_val, obj.getDet1_val(), obj.getMain_det_val());
                // Set var1 val
                String var1 = "=" + f.format(obj.getDet1_val() / obj.getMain_det_val()) + ";";
                sys6_var1_value.setText(var1);

                // Set fraction (X2)
                gm.set_fraction(sys6_v_lay_det2_val, obj.getDet2_val(), obj.getMain_det_val());
                // Set var2 val
                String var2 = "=" + f.format(obj.getDet2_val() / obj.getMain_det_val()) + ";";
                sys6_var2_value.setText(var2);

                // Set fraction (X3)
                gm.set_fraction(sys6_v_lay_det3_val, obj.getDet3_val(), obj.getMain_det_val());
                // Set var3 val
                String var3 = "=" + f.format(obj.getDet3_val() / obj.getMain_det_val()) + ";";
                sys6_var3_value.setText(var3);

                // Set fraction (X4)
                gm.set_fraction(sys6_v_lay_det4_val, obj.getDet4_val(), obj.getMain_det_val());
                // Set var4 val
                String var4 = "=" + f.format(obj.getDet4_val() / obj.getMain_det_val()) + ";";
                sys6_var4_value.setText(var4);

                // Set fraction (X5)
                gm.set_fraction(sys6_v_lay_det5_val, obj.getDet5_val(), obj.getMain_det_val());
                // Set var5 val
                String var5 = "=" + f.format(obj.getDet5_val() / obj.getMain_det_val()) + ";";
                sys6_var5_value.setText(var5);

                // Set fraction (X6)
                gm.set_fraction(sys6_v_lay_det6_val, obj.getDet6_val(), obj.getMain_det_val());
                // Set var6 val
                String var6 = "=" + f.format(obj.getDet6_val() / obj.getMain_det_val()) + ";";
                sys6_var6_value.setText(var6);

                // Show solution
                // Show main det solution
                gm.show_hide(sys6_full_solution);
                // Show detailed solution
                gm.hide(sys6_not_solutable);
                gm.show_hide(sys6_v_lay_det1_2);
                gm.show_hide(sys6_var_final_val);

            }
        }
    }

}
