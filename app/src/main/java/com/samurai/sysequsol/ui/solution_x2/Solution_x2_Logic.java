package com.samurai.sysequsol.ui.solution_x2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.samurai.sysequsol.ui.General_Methods;

/**
 * Created by Serg on 14.05.2017.
 */

public class Solution_x2_Logic {

    private General_Methods gm = new General_Methods();

    private double[][] src_arr;
    private double[][] det1_arr;
    private double[][] det2_arr;
    private String main_det_sol;
    private double main_det;
    private boolean is_have_sol;
    private double det1_val;
    private String det1_sol;
    private double det2_val;
    private String det2_sol;

    Solution_x2_Logic(double[][] arr) {
        calc_det(arr);
    }

    // Getter-Setters
    public void setSrc_arr(double[][] a) {
        this.src_arr = a;
    }

    public double[][] getSrc_arr() {
        return src_arr;
    }

    public void setDet1_arr() {
        double[][] tmp = new double[2][2];
        for (int i = 0; i < tmp[0].length; i++) {
            tmp[i][0] = this.src_arr[i][2];
            tmp[i][1] = this.src_arr[i][1];
        }
        this.det1_arr = tmp;
    }

    public double[][] getDet1_arr() {
        return this.det1_arr;
    }

    public void setDet2_arr() {
        double[][] tmp = new double[2][2];
        for (int i = 0; i < tmp[0].length; i++) {
            tmp[i][0] = this.src_arr[i][0];
            tmp[i][1] = this.src_arr[i][2];
        }
        this.det2_arr = tmp;
    }

    public double[][] getDet2_arr() {
        return this.det2_arr;
    }

    public void setMain_det_sol(String s) {
        this.main_det_sol = s;
    }

    public String getMain_det_sol() {
        return main_det_sol;
    }

    public void setMain_det(double d) {
        this.main_det = d;
    }

    public double getMain_det() {
        return main_det;
    }

    public void setIs_have_sol(boolean b) {
        this.is_have_sol = b;
    }

    public boolean getIs_have_sol() {
        return is_have_sol;
    }

    public void setDet1_val(double d) {
        this.det1_val = d;
    }

    public double getDet1_val() {
        return det1_val;
    }

    public void setDet1_sol(String s) {
        this.det1_sol = s;
    }

    public String getDet1_sol() {
        return det1_sol;
    }

    public void setDet2_val(double d) {
        this.det2_val = d;
    }

    public double getDet2_val() {
        return det2_val;
    }

    public void setDet2_sol(String s) {
        this.det2_sol = s;
    }

    public String getDet2_sol() {
        return det2_sol;
    }

    public void calc_det(double[][] a) {
        setSrc_arr(a);
        double main_det = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        setMain_det(main_det);
        String main_sol = gm.dts(a[0][0]) + "*" + gm.dts(a[1][1]) + "-" + gm.dts(a[0][1]) + "*" + gm.dts(a[1][0]) + "=" + gm.dts(main_det);
        setMain_det_sol(main_sol);
        if (getMain_det() == 0) {
            setIs_have_sol(false);
        } else {
            setIs_have_sol(true);
            sys_solution();
        }
    }

    public void sys_solution() {
        setDet1_arr();
        setDet2_arr();
        double det1_val = src_arr[0][2] * src_arr[1][1] - src_arr[1][2] * src_arr[0][1];
        setDet1_val(det1_val);
        String det1_sol = gm.dts(src_arr[0][2]) + "*" + gm.dts(src_arr[1][1]) + "-" + gm.dts(src_arr[1][2]) + "*" + gm.dts(src_arr[0][1]) + "=" + gm.dts(det1_val);
        setDet1_sol(det1_sol);
        double det2_val = src_arr[0][0] * src_arr[1][2] - src_arr[1][0] * src_arr[0][2];
        setDet2_val(det2_val);
        String det2_sol = gm.dts(src_arr[0][0]) + "*" + gm.dts(src_arr[1][2]) + "-" + gm.dts(src_arr[1][0]) + "*" + gm.dts(src_arr[0][2]) + "=" + gm.dts(det2_val);
        setDet2_sol(det2_sol);
    }

}
