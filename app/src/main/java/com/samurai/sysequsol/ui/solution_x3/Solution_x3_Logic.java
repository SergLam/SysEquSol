package com.samurai.sysequsol.ui.solution_x3;

import com.samurai.sysequsol.ui.General_Methods;

/**
 * Created by Serg on 21.05.2017.
 */

public class Solution_x3_Logic {

    private General_Methods gm = new General_Methods();

    private double[][] src_arr;
    private double[][] main_det_arr;
    private double[][] det1_arr;
    private double[][] det2_arr;
    private double[][] det3_arr;
    private String main_det_sol;
    private double main_det_val;
    private boolean is_have_sol;
    private double det1_val;
    private String det1_sol;
    private double det2_val;
    private String det2_sol;
    private double det3_val;
    private String det3_sol;

    Solution_x3_Logic(double[][] arr) {
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
        double[][] tmp = new double[3][3];
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
        this.det1_arr = gm.set_det(this.src_arr, 0, 3);
    }

    public double[][] getDet1_arr() {
        return det1_arr;
    }

    public void setDet2_arr() {
        this.det2_arr = gm.set_det(this.src_arr, 1, 3);
    }

    public double[][] getDet2_arr() {
        return det2_arr;
    }

    public void setDet3_arr() {
        this.det3_arr = gm.set_det(this.src_arr, 2, 3);
    }

    public double[][] getDet3_arr() {
        return det3_arr;
    }

    public void setMain_det_sol() {
        this.main_det_sol = sol_det_x3(getMain_det_arr());
    }

    public String getMain_det_sol() {
        return main_det_sol;
    }

    public void setMain_det_val() {
        this.main_det_val = calc_det_x3(getMain_det_arr());
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
        this.det1_val = calc_det_x3(det1_arr);
    }

    public double getDet1_val() {
        return det1_val;
    }

    public void setDet1_sol() {
        this.det1_sol = sol_det_x3(det1_arr);
    }

    public String getDet1_sol() {
        return det1_sol;
    }

    public void setDet2_val() {
        this.det2_val = calc_det_x3(det2_arr);
    }

    public double getDet2_val() {
        return det2_val;
    }

    public void setDet2_sol() {
        this.det2_sol = sol_det_x3(det2_arr);
    }

    public String getDet2_sol() {
        return det2_sol;
    }

    public void setDet3_val() {
        this.det3_val = calc_det_x3(det3_arr);
    }

    public double getDet3_val() {
        return det3_val;
    }

    public void setDet3_sol() {
        this.det3_sol = sol_det_x3(det3_arr);
    }

    public String getDet3_sol() {
        return det3_sol;
    }


    public void calc_det(double[][] a) {
        // set all determinant before calculation
        setSrc_arr(a);
        setMain_det_arr();
        setMain_det_val();
        setMain_det_sol();
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

        setDet1_val();
        setDet1_sol();
        setDet2_val();
        setDet2_sol();
        setDet3_val();
        setDet3_sol();
    }


    public double calc_det_x3(double[][] a) {
        // Way of Saryus
        // Firstly complete src det with additional columns
        double result = 0;
        int s = a[0].length;
        int add = s - 1;
        int size = s + add;
        double[][] arr = new double[s][size];
        // Copy array
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = a[i][j];
            }
        }
        // Add columns
        for (int i = 0; i < s; i++) {
            for (int j = s; j < size; j++) {
                arr[i][j] = a[i][j - s];
            }
        }
        // Calculate positive summ
        // Move by columns
        double p_sum = 0;
        for (int j = 0; j < s; j++) {
            p_sum += arr[0][j] * arr[1][j + 1] * arr[2][j + 2];
        }
        // Calculate negative summ
        // Move by columns
        double n_sum = 0;
        for (int j = size - 1; j > 1; j--) {
            n_sum -= arr[0][j] * arr[1][j - 1] * arr[2][j - 2];
        }
        // Calculate det value
        result = p_sum - (-n_sum);
        return result;
    }

    public String sol_det_x3(double[][] a) {
        // Way of Saryus
        // Firstly complete src det with additional columns
        int s = a[0].length;
        int add = s - 1;
        int size = s + add;
        double[][] arr = new double[s][size];
        // Copy array
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = a[i][j];
            }
        }
        // Add columns
        for (int i = 0; i < s; i++) {
            for (int j = s; j < size; j++) {
                arr[i][j] = a[i][j - s];
            }
        }
        // Calculate positive sum
        // Move by columns
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s; j++) {
            sb.append(gm.dts(arr[0][j]) + "*" + gm.dts(arr[1][j + 1]) + "*" + gm.dts(arr[2][j + 2]) + "+");
        }
        sb.setCharAt(sb.length() - 1, '-');
        String p_sum = sb.toString();
        sb.setLength(0);
        // Calculate negative sum
        // Move by columns
        for (int j = size - 1; j > 1; j--) {
            sb.append(gm.dts(arr[0][j]) + "*" + gm.dts(arr[1][j - 1]) + "*" + gm.dts(arr[2][j - 2]) + "-");
        }
        String n_sum = sb.toString();
        n_sum = n_sum.substring(0, n_sum.length() - 1);
        sb.setLength(0);
        // Calculate det value
        String result = p_sum + '\n' + n_sum + '\n' +"=" + gm.dts(calc_det_x3(a));
        return result;
    }


}
