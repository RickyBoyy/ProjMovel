package pt.iade.ricardopereiradanielalmeida.qrity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="utilizador")
public class WorkersItem {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="utilizador_id") private int id;
@Column(name="utilizador_name") private String worker_name;
@Column(name="utilizador_cargo") private String role;
public WorkersItem() {}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getWorker_name() {
    return worker_name;
}
public void setWorker_name(String worker_name) {
    this.worker_name = worker_name;
}
public String getRole() {
    return role;
}
public void setRole(String role) {
    this.role = role;
}

}