package com.samurai.sysequsol.ui.solution_x5;

import com.samurai.sysequsol.ui.General_Methods;

/**
 * Created by Serg on 27.05.2017.
 */

public class Solution_x5_Logic {

    private General_Methods gm = new General_Methods();

    private double[][] src_arr;
    private double[][] main_det_arr;
    private double[][] det1_arr;
    private double[][] det2_arr;
    private double[][] det3_arr;
    private double[][] det4_arr;
    private double[][] det5_arr;
    private double main_det_val;
    private boolean is_have_sol;
    private double det1_val;
    private double det2_val;
    private double det3_val;
    private double det4_val;
    private double det5_val;


    Solution_x5_Logic(double[][] arr) {
        calc_det(arr);
    }

    // Getter-Setters
    public void setSrc_arr(double[][] arr) {
        this.src_arr = arr;
    }

    public double[][] getSrc_arr() {
        return src_arr;
    }

    public void setMain_det_arr() {
        double[][] tmp = new double[5][5];
        for (int i = 0; i < tmp[0].length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                tmp[i][j] = this.src_arr[i][j];
            }
        }
        this.main_det_arr = tmp;
    }

    public double[][] getMain_det_arr() {
        return main_det_arr;
    }

    public void setDet1_arr() {
        this.det1_arr = gm.set_det(this.src_arr, 0, 5);
    }

    public double[][] getDet1_arr() {
        return det1_arr;
    }

    public void setDet2_arr() {
        this.det2_arr = gm.set_det(this.src_arr, 1, 5);
    }

    public double[][] getDet2_arr() {
        return det2_arr;
    }

    public void setDet3_arr() {
        this.det3_arr = gm.set_det(this.src_arr, 2, 5);
    }

    public double[][] getDet3_arr() {
        return det3_arr;
    }

    public void setDet4_arr() {
        this.det4_arr = gm.set_det(this.src_arr, 3, 5);
    }

    public double[][] getDet4_arr() {
        return det4_arr;
    }

    public void setDet5_arr() {
        this.det5_arr = gm.set_det(this.src_arr, 4, 5);
    }

    public double[][] getDet5_arr() {
        return det5_arr;
    }


    public void setMain_det_val() {
        this.main_det_val = gm.calc_det_val(getMain_det_arr());
    }

    public double getMain_det_val() {
        return main_det_val;
    }

    public void setIs_have_sol(boolean b) {
        this.is_have_sol = b;
    }

    public boolean getIs_have_sol() {
        return is_have_sol;
    }

    public void setDet1_val() {
        this.det1_val = gm.calc_det_val(det1_arr);
    }

    public double getDet1_val() {
        return det1_val;
    }

    public void setDet2_val() {
        this.det2_val = gm.calc_det_val(det2_arr);
    }

    public double getDet2_val() {
        return det2_val;
    }

    public void setDet3_val() {
        this.det3_val = gm.calc_det_val(det3_arr);
    }

    public double getDet3_val() {
        return det3_val;
    }

    public void setDet4_val() {
        this.det4_val = gm.calc_det_val(det4_arr);
    }

    public double getDet4_val() {
        return det4_val;
    }

    public void setDet5_val() {
        this.det5_val = gm.calc_det_val(det5_arr);
    }

    public double getDet5_val() {
        return det5_val;
    }


    public void calc_det(double[][] a) {
        // set all determinant before calculation
        setSrc_arr(a);
        setMain_det_arr();
        setMain_det_val();
        if (getMain_det_val() == 0) {
            setIs_have_sol(false);
        } else {
            setIs_have_sol(true);
            sys_solution();
        }
    }

    public void sys_solution() {
        setDet1_arr();
        setDet2_arr();
        setDet3_arr();
        setDet4_arr();
        setDet5_arr();

        setDet1_val();
        setDet2_val();
        setDet3_val();
        setDet4_val();
        setDet5_val();
    }

}
