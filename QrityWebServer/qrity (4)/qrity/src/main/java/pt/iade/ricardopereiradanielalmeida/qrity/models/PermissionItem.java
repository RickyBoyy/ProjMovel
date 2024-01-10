package pt.iade.ricardopereiradanielalmeida.qrity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="door")
public class PermissionItem {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="door_id") private int id;
@Column(name="door_name") private String door_name;
@Column(name="door_area_id")private int area_id;
public PermissionItem() {}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getDoor_name() {
    return door_name;
}
public void setDoor_name(String door_name) {
    this.door_name = door_name;
}
public int getArea_id() {
    return area_id;
}
public void setArea_id(int area_id) {
    this.area_id = area_id;
}




}

