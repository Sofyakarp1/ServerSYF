package mirea.mosit.serversfy.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "sensor_action")
public class Action {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer observed_id;

    @Column
    private Time time;

    @Column
    private String indicator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObserved_id() {
        return observed_id;
    }

    public void setObserved_id(Integer observed_id) {
        this.observed_id = observed_id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", observed_id=" + observed_id +
                ", time=" + time +
                ", indicator='" + indicator + '\'' +
                '}';
    }
}
