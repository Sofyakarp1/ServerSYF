package mirea.mosit.serversfy.domain;

import java.util.Objects;

public class Data {
    public String name;
    public String sensor_action;
    public String sensor_rele;
    public String time_action;
    public String time_rele;
    public String result;

    public Data(String name, String sensor_action, String sensor_rele, String time_action, String time_rele, String result) {
        this.name = name;
        this.sensor_action = sensor_action;
        this.sensor_rele = sensor_rele;
        this.time_action = time_action;
        this.time_rele = time_rele;
        this.result = result;
    }

    public Data() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSensor_rele() {
        return sensor_rele;
    }

    public void setSensor_rele(String sensor_rele) {
        this.sensor_rele = sensor_rele;
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
                Objects.equals(sensor_rele, data.sensor_rele) &&
                Objects.equals(time_action, data.time_action) &&
                Objects.equals(time_rele, data.time_rele);
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", sensor_action='" + sensor_action + '\'' +
                ", sensor_rele='" + sensor_rele + '\'' +
                ", time_action=" + time_action +
                ", time_rele='" + time_rele + '\'' +
                '}';
    }
}
