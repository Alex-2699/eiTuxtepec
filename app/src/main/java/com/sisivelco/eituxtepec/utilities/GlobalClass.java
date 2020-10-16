package com.sisivelco.eituxtepec.utilities;

import android.app.Application;

public class GlobalClass extends Application {
    private String clvRuta;
    private String ipEquipo;


    public String getSomeVariable() {
        return clvRuta;
    }

    public void setSomeVariable(String clvRuta) {
        this.clvRuta = clvRuta;
    }

    public String getIpEquipo() {
        ipEquipo = "http://192.168.1.68:3000";
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }
}
