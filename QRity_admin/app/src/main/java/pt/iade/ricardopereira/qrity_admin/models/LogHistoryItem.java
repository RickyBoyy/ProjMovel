package pt.iade.ricardopereira.qrity_admin.models;

public class LogHistoryItem {
    private String worker;

    private String door;

    private String area;

    private String timestamp;








    public LogHistoryItem(String worker, String door, String area, String timestamp){

        this.worker = worker;
        this.door = door;
        this.area = area;
        this.timestamp = timestamp;


    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
