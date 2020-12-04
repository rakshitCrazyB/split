package DTO;

import javafx.util.Pair;

import java.util.ArrayList;

public class Transaction {
    ArrayList<String> UsersInvolved;
    Integer TotalAmount;
    Integer GroupId;

    public ArrayList<String> getUsersInvolved() {
        return UsersInvolved;
    }

    public void setUsersInvolved(ArrayList<String> usersInvolved) {
        UsersInvolved = usersInvolved;
    }

    public Integer getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        TotalAmount = totalAmount;
    }

    public Integer getGroupId() {
        return GroupId;
    }

    public void setGroupId(Integer groupId) {
        GroupId = groupId;
    }

    public ArrayList<Pair<String, Integer>> getSplitValue() {
        return splitValue;
    }

    public void setSplitValue(ArrayList<Pair<String, Integer>> splitValue) {
        this.splitValue = splitValue;
    }

    ArrayList<Pair<String,Integer>> splitValue;
}
