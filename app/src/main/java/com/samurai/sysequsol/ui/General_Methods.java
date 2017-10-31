package com.samurai.sysequsol.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samurai.sysequsol.R;

import java.math.BigDecimal;
import java.util.Random;

import Jama.Matrix;

/**
 * Created by Serg on 13.05.2017.
 */

public class General_Methods extends Activity{

    public static void show_hide(View v) {
        if (v.getVisibility() == View.GONE) {
            v.setVisibility(View.VISIBLE);
        } else {
            v.setVisibility(View.GONE);
        }
    }

    public static void hide(View v) {
        v.setVisibility(View.GONE);
    }


    public int[][] generic_rand_array(int row, int col) {
        int min = -100;
        int max = 100;
        int mass[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Random r = new Random();
                mass[i][j] = r.nextInt((max - min) + 1) + min;
            }
        }
        return mass;
    }

    public String its(int i) {
        return Integer.toString(i);
    }

    public String dts(double i) {
        return Double.toString(i);
    }

    public boolean et_ch(EditText e, String s, Context con) {
        boolean result = false;
        try{
            Double.parseDouble(s);
        }catch (NumberFormatException ex){
            String err1 = con.getResources().getString(R.string.error_invalid);
            e.setError(err1);
            result = true;
        }
        if (TextUtils.isEmpty(s)) {
            String err = con.getResources().getString(R.string.error_empty);
            e.setError(err);
            result = true;
        }
        if(!result){
            et_hideError(e);
        }
        return result;
    }

    public void et_hideError(EditText e){
        e.setError(null);
    }

    public String gl_et_get(View v) {
        String result;
        EditText e = (EditText) v;
        result = e.getText().toString();
        return result;
    }

    public boolean input_is_empty(GridLayout l, Context con) {
        boolean result = false;

        int count = l.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = l.getChildAt(i);
            if (v instanceof EditText) {
                boolean a = et_ch((EditText) v, gl_et_get(v), con);
                if (a) {
                    result = true;
                }
            }
        }
        return result;
    }

    public double[][] get_input_data(GridLayout l, int row, int col) {
        double[][] input_data = new double[row][col];
        int count = l.getChildCount();
        for (int k = 0, i = 0, j = 0; k < count && i < row && j < col; k++) {
            View v = l.getChildAt(k);
            if (v instanceof EditText) {
                EditText e = (EditText) v;
                input_data[i][j] = Double.parseDouble(e.getText().toString());
                // Custom condition - it's working!
                j++;
                if (j == col) {
                    i++;
                    j = 0;
                }
            }
        }
        return input_data;
    }

    public void set_determinant_values(GridLayout l, double[][] a) {
        // Set values main det
        int g = l.getChildCount();
        for (int i = 0, f = 0; i < l.getRowCount(); i++) {
            for (int j = 0; j < l.getColumnCount(); j++) {
                if (f < g) {
                    View v = l.getChildAt(f);
                    EditText e = (EditText) v;
                    e.setText(dts(a[i][j]));
                    f++;
                }
            }
        }
    }

    public void set_fraction(LinearLayout l, double num, double denum) {
        double[] tmp = {num,denum};
        for(int i=0, j=0;i<l.getChildCount();i++){
            View v = l.getChildAt(i);
            if(v instanceof TextView){
                TextView e = (TextView) v;
                BigDecimal b = new BigDecimal(tmp[j]);
                b = b.setScale(3, BigDecimal.ROUND_HALF_UP);
                e.setText(b.toString());
                j++;
            }
        }
    }

    public String set_det_value(double d){
        String result = "";
        BigDecimal b = new BigDecimal(d);
        b = b.setScale(2, BigDecimal.ROUND_HALF_UP);
        result = "=" + b;
        return result;
    }

    public double calc_det_val(double[][] a) {
        double result = 0;
        Matrix A = new Matrix(a);
        result = A.det();
        return result;
    }

    public double[][] set_det(double[][]a, int col, int col_src){
        double[][] result = new double[a.length][a[0].length-1];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length-1;j++){
                if(i==col){
                    result[j][col] = a[j][col_src];
                }else result[j][i] = a[j][i];
            }
        }
        return result;
    }



}
