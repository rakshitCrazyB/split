package DTO;

import java.util.HashMap;

public class GroupData {
    public GroupData() {
        this.GetsOwesData = new HashMap<String, Integer>();
    }

    public HashMap<String, Integer> getGetsOwesData() {
        return GetsOwesData;
    }

    public void setGetsOwesData(HashMap<String, Integer> getsOwesData) {
        GetsOwesData = getsOwesData;
    }

    HashMap<String, Integer> GetsOwesData ;// Mapping user to what he Gets and Owes
}
