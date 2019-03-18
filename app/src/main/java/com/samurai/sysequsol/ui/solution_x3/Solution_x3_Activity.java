package com.samurai.sysequsol.ui.solution_x3;

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
 * Created by Serg on 20.05.2017.
 */


public class Solution_x3_Activity extends Activity {

    // Inputs layout
    @BindView(R.id.sys3_gl_inputs)
    GridLayout sys3_gl_inputs;
    // Main det lay
    @BindView(R.id.sys3_v_lay_det)
    LinearLayout sys3_v_lay_det;
    // Main det grid lay (values)
    @BindView(R.id.sys3_gl_det)
    GridLayout sys3_gl_det;
    // Main det solution
    @BindView(R.id.sys3_det_calc_field)
    EditText sys3_det_calc_field;
    // System not solutable
    @BindView(R.id.sys3_not_solutable)
    TextView sys3_not_solutable;

    // Det 1 2 3 solution lay
    @BindView(R.id.sys3_v_lay_det1_2)
    LinearLayout sys3_v_lay_det1_2;
    // Det1 values
    @BindView(R.id.sys3_gl_det1)
    GridLayout sys3_gl_det1;
    // Det1 solution
    @BindView(R.id.sys3_det1_calc_field)
    EditText sys3_det1_calc_field;
    // Det2 values
    @BindView(R.id.sys3_gl_det2)
    GridLayout sys3_gl_det2;
    // Det2 solution
    @BindView(R.id.sys3_det2_calc_field)
    EditText sys3_det2_calc_field;
    // Det3 values
    @BindView(R.id.sys3_gl_det3)
    GridLayout sys3_gl_det3;
    // Det3 solution
    @BindView(R.id.sys3_det3_calc_field)
    EditText sys3_det3_calc_field;

    // variable values

    // layout of variable values
    @BindView(R.id.sys3_var_final_val)
    LinearLayout sys3_var_final_val;

    // var 1 lay
    @BindView(R.id.sys3_v_lay_det_values)
    LinearLayout sys3_v_lay_det_values;
    // var1 val
    @BindView(R.id.sys3_var1_value)
    TextView sys3_var1_value;
    // var 2 lay
    @BindView(R.id.sys3_v_lay_det2_val)
    LinearLayout sys3_v_lay_det2_val;
    // var2 val
    @BindView(R.id.sys3_var2_value)
    TextView sys3_var2_value;
    // var 3 lay
    @BindView(R.id.sys3_v_lay_det3_val)
    LinearLayout sys3_v_lay_det3_val;
    // var 3 val
    @BindView(R.id.sys3_var3_value)
    TextView sys3_var3_value;

    private General_Methods gm = new General_Methods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_x3);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        // Set input filters for edittext
        int count = sys3_gl_inputs.getChildCount();
        for (int k = 0;k<count; k++) {
            View v = sys3_gl_inputs.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                //e.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(10, 3) });
            }
        }
    }

    @OnClick(R.id.sys3_btn_back)
    public void back(View view) {
        onBackPressed();
    }

    @OnClick(R.id.sys3_btn_fill)
    public void sys3_fill(View view) {
        int mass[][] = gm.generic_rand_array(3, 4);
        int count = sys3_gl_inputs.getChildCount();
        int f = mass[0].length;
        int d = mass[1].length;
        for (int k = 0, i = 0, j = 0; k < count && i < f && j < d; k++) {
            View v = sys3_gl_inputs.getChildAt(k);
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

    @OnClick(R.id.sys3_btn_calc)
    public void calculate(View view) {
        Context con = getApplicationContext();
        if (!gm.input_is_empty(sys3_gl_inputs, con)) {
            // Get input data
            Solution_x3_Logic obj = new Solution_x3_Logic(gm.get_input_data(sys3_gl_inputs, 3, 4));
            // Set values main det
            gm.set_determinant_values(sys3_gl_det, obj.getSrc_arr());
            // Set detailed solution
            sys3_det_calc_field.setText(obj.getMain_det_sol());

            // Check if no view has focus:
            View vieww = this.getCurrentFocus();
            if (vieww != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            // Condition for reusage
            gm.hide(sys3_v_lay_det);
            gm.hide(sys3_not_solutable);
            gm.hide(sys3_v_lay_det1_2);
            gm.hide(sys3_var_final_val);

            // Show if system not have solution
            if (!obj.getIs_have_sol()) {
                gm.show_hide(sys3_v_lay_det);
                gm.show_hide(sys3_not_solutable);
                gm.hide(sys3_var_final_val);
            } else {
                // Set values det1
                gm.set_determinant_values(sys3_gl_det1, obj.getDet1_arr());
                // Set det1 detailed solution
                sys3_det1_calc_field.setText(obj.getDet1_sol());

                // Set values det2
                gm.set_determinant_values(sys3_gl_det2, obj.getDet2_arr());
                // Set det 2 detailed solution
                sys3_det2_calc_field.setText(obj.getDet2_sol());

                // Set values det3
                gm.set_determinant_values(sys3_gl_det3, obj.getDet3_arr());
                // Set det 3 detailed solution
                sys3_det3_calc_field.setText(obj.getDet3_sol());

                // Set variable values
                DecimalFormat f = new DecimalFormat("#.###");

                // Set fraction (X1)
                gm.set_fraction(sys3_v_lay_det_values, obj.getDet1_val(), obj.getMain_det_val());
                // Set var1 val
                String var1 = "=" + f.format(obj.getDet1_val() / obj.getMain_det_val()) + ";";
                sys3_var1_value.setText(var1);

                // Set fraction (X2)
                gm.set_fraction(sys3_v_lay_det2_val, obj.getDet2_val(), obj.getMain_det_val());
                // Set var2 val
                String var2 = "=" + f.format(obj.getDet2_val() / obj.getMain_det_val()) + ";";
                sys3_var2_value.setText(var2);

                // Set fraction (X3)
                gm.set_fraction(sys3_v_lay_det3_val, obj.getDet3_val(), obj.getMain_det_val());
                // Set var2 val
                String var3 = "=" + f.format(obj.getDet3_val() / obj.getMain_det_val()) + ";";
                sys3_var3_value.setText(var3);

                // Show solution
                // Show main det solution
                gm.show_hide(sys3_v_lay_det);
                // Show detailed solution
                gm.hide(sys3_not_solutable);
                gm.show_hide(sys3_v_lay_det1_2);
                gm.show_hide(sys3_var_final_val);
            }
        }
    }


}
