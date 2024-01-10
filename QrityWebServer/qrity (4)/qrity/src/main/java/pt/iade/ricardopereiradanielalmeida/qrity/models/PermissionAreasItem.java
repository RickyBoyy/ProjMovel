package pt.iade.ricardopereiradanielalmeida.qrity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="areas")
public class PermissionAreasItem {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="area_id") private int id;
@Column(name="area_name") private String area;

public PermissionAreasItem() {}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getArea() {
    return area;
}
public void setArea(String area) {
    this.area = area;
}



}

