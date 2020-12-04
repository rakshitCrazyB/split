package Service;

import DTO.GroupData;
import DTO.Transaction;
import DTO.TransactionDTO;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class SplitwiseService {
    HashMap<Integer, GroupData> AllGroups; //Group Data
    HashMap<Integer, ArrayList<Transaction> > TransactionsByGroup; //group to transaction mapping
    HashMap<String, ArrayList<Integer>> GroupsofUser; // List groups of a user

    SplitwiseService(){
        AllGroups = new HashMap<Integer, GroupData>();
        TransactionsByGroup = new HashMap<Integer, ArrayList<Transaction>>();
        GroupsofUser = new HashMap<String, ArrayList<Integer>>();
    }

    public ArrayList<Transaction> getTransaction(Integer groupid){
       return TransactionsByGroup.get(groupid);
    }

    public void registerUser(String username){
        GroupsofUser.put(username,new ArrayList<Integer>());
    }

    public void createGroup(Integer groupid){
        TransactionsByGroup.put(groupid,new ArrayList<Transaction>());
        AllGroups.put(groupid,new GroupData());
    }

    public void addUsertoGroup(Integer groupid ,String username){
        GroupsofUser.get(username).add(groupid);
    }

    public void addTransaction(TransactionDTO transactionDTO){
        Transaction t = new Transaction();
        t.setGroupId(transactionDTO.getGroupId());
        t.setTotalAmount(transactionDTO.getTotalAmount());
        ArrayList<Pair<String,Integer>> splitval= new ArrayList<Pair<String,Integer>>();
        t.setUsersInvolved(transactionDTO.getUsersInvolved());
        if(transactionDTO.getSplitType()== TransactionDTO.SplitType.EQUAL){
            for(String user :transactionDTO.getUsersInvolved()){
                if(user.equals(transactionDTO.getPaidbyuser())){
                    splitval.add(new Pair(user,transactionDTO.getTotalAmount()/transactionDTO.getUsersInvolved().size()-transactionDTO.getTotalAmount()));
                }else {
                    splitval.add(new Pair(user, transactionDTO.getTotalAmount() / transactionDTO.getUsersInvolved().size()));
                }
            }
        }
        t.setSplitValue(splitval);

        TransactionsByGroup.get(transactionDTO.getGroupId()).add(t);
        GroupData groupData = AllGroups.get(transactionDTO.getGroupId());
        for(Pair<String,Integer> p : splitval){
            if (groupData.getGetsOwesData().containsKey(p.getKey())){
                groupData.getGetsOwesData().put(p.getKey(),groupData.getGetsOwesData().get(p.getKey())+p.getValue());
            }
        }


    }
}
