package mirea.mosit.serversfy.domain;

import java.sql.Time;
import java.util.Objects;

public class Data {
    public String name;
    public String sensor_action;
    public String getSensor_rele;
    public String time_action;
    public String time_rele;

    public Data(String name, String sensor_action, String getSensor_rele, String time_action, String time_rele) {
        this.name = name;
        this.sensor_action = sensor_action;
        this.getSensor_rele = getSensor_rele;
        this.time_action = time_action;
        this.time_rele = time_rele;
    }

    public Data() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSensor_action() {
        return sensor_action;
    }

    public void setSensor_action(String sensor_action) {
        this.sensor_action = sensor_action;
    }

    public String getGetSensor_rele() {
        return getSensor_rele;
    }

    public void setGetSensor_rele(String getSensor_rele) {
        this.getSensor_rele = getSensor_rele;
    }

    public String getTime_action() {
        return time_action;
    }

    public void setTime_action(String time_action) {
        this.time_action = time_action;
    }

    public String getTime_rele() {
        return time_rele;
    }

    public void setTime_rele(String time_rele) {
        this.time_rele = time_rele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name) &&
                Objects.equals(sensor_action, data.sensor_action) &&
                Objects.equals(getSensor_rele, data.getSensor_rele) &&
                Objects.equals(time_action, data.time_action) &&
                Objects.equals(time_rele, data.time_rele);
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", sensor_action='" + sensor_action + '\'' +
                ", getSensor_rele='" + getSensor_rele + '\'' +
                ", time_action=" + time_action +
                ", time_rele='" + time_rele + '\'' +
                '}';
    }
}
