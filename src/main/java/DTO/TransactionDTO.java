package DTO;

import javafx.util.Pair;

import java.util.ArrayList;

public class TransactionDTO {
    ArrayList<String> UsersInvolved;
    Integer TotalAmount;
    Integer GroupId;
    SplitType splitType;
    ArrayList<Pair<String,Integer>> splitData;
    String paidbyuser;

    public String getPaidbyuser() {
        return paidbyuser;
    }

    public void setPaidbyuser(String paidbyuser) {
        this.paidbyuser = paidbyuser;
    }

    public enum SplitType {
        EQUAL,
        BYPERCENTAGE,
        BYVALUE
    }

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

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public ArrayList<Pair<String, Integer>> getSplitData() {
        return splitData;
    }

    public void setSplitData(ArrayList<Pair<String, Integer>> splitData) {
        this.splitData = splitData;
    }



}
