package pt.iade.ricardopereira.qrity_admin.models;

public class WorkersItem {
    private String worker_name;
    private String  role;

    private int id;

    public WorkersItem(String worker_name, String role, int id){

        this.worker_name = worker_name;
        this.role = role;
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

    public int getId() {
        return id;
    }
}
