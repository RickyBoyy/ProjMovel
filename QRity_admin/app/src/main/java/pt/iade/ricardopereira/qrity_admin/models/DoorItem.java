package pt.iade.ricardopereira.qrity_admin.models;

import java.util.ArrayList;

public class DoorItem {



   private int id;
   private String name;

   private String area;


   public DoorItem() {

       this(0, "", "");

   }



    public  DoorItem(int id, String name, String area){
        this.id = id;
        this.name = name;
        this.area = area;
    }


    public static ArrayList<DoorItem> arrayList(){
        ArrayList<DoorItem> items = new ArrayList<>();


        //fetch stuff from the web server aka data base

        //simulação:

        items.add(new DoorItem(1, "Jardim", "Edificio B"));
        items.add(new DoorItem(2, "Tech Room", "Edificio A"));
        items.add(new DoorItem(3, "Boss Office", "Edificio A"));


        return items;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

