package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class DiskreteRandomVariable {
    private List<Event> distributionTable = new ArrayList<>();

    public List<Event> getDistributionTable() {
        return distributionTable;
    }

    public void setDistributionTable(List<Event> distributionTable) {
        this.distributionTable = distributionTable;
    }

    public List<Event> fillTable(){
        distributionTable.add(new Event(5, 0.1));
        distributionTable.add(new Event(8, 0.02));
        distributionTable.add(new Event(13, 0.25));
        distributionTable.add(new Event(16, 0.15));
        distributionTable.add(new Event(21, 0.35));
        distributionTable.add(new Event(24, 0.03));
        distributionTable.add(new Event(29, 0.1));
        return this.distributionTable;
    }
}
