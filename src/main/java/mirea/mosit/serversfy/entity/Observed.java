package mirea.mosit.serversfy.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "observed")
public class Observed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private Time zone_1_s;

    @Column
    private Time zone_1_f;

    @Column
    private Time zone_2_s;

    @Column
    private Time zone_2_f;

    @Column
    private Integer person_id;

    @Column
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Time getZone_1_s() {
        return zone_1_s;
    }

    public void setZone_1_s(Time zone_1_s) {
        this.zone_1_s = zone_1_s;
    }

    public Time getZone_1_f() {
        return zone_1_f;
    }

    public void setZone_1_f(Time zone_1_f) {
        this.zone_1_f = zone_1_f;
    }

    public Time getZone_2_s() {
        return zone_2_s;
    }

    public void setZone_2_s(Time zone_2_s) {
        this.zone_2_s = zone_2_s;
    }

    public Time getZone_2_f() {
        return zone_2_f;
    }

    public void setZone_2_f(Time zone_2_f) {
        this.zone_2_f = zone_2_f;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
         return "{\"id\":" + id + ", \"name\":\"" + name + "\" , \"address\":\""
                + address + "\" , \"phone\":\""+ phone + "\" , \"zone_1_s\":\"" + zone_1_s
                + "\" , \"zone_1_f\":\""+ zone_1_f
                + "\" , \"zone_2_s\":\""+ zone_2_s
                + "\" , \"zone_2_f\":\""+ zone_2_f
                + "\" , \"person_id\":\""+ person_id
                + "\" , \"url\":\""+ url
                + "\"}";
    }

    public String toString2(){
        return "{\"id\":" + id + ", \"name\":\"" + name + "\" , \"address\":\"" + address + "\" , \"phone\":\""+ phone + "\"}";
    }
}
