package pt.iade.ricardopereira.qrity_admin.models;

import java.util.List;

public class StatisticsItem {

    private String sectionName;

    private List<String>sectionItems;

    public StatisticsItem(String sectionName, List<String> sectionItems) {
        this.sectionName = sectionName;
        this.sectionItems = sectionItems;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<String> getSectionItems() {
        return sectionItems;
    }

    public void setSectionItems(List<String> sectionItems) {
        this.sectionItems = sectionItems;
    }
}