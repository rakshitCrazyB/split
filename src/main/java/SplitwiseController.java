import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

/*addTransactionToGroup
        {
            UsersInvolved :["rakshit","harsh"],
            TotalAmount: 5000,
            GroupId: 12345,
            SplitType : EQUAL/BYPERCENTAGE/BYVALUE,
            SplitData :BYPERCENTAGE: [{user1,percent1},{user2,percent2}]
                      :BYVALUE[{user1,val1},{user2,val2}]
                       :null
        }*/



@RestController
public class SplitwiseController{
    @Autowired
    SplitwiseService splitwiseService;


    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionToGroup")
    public void addTransactionToGroup(@RequestBody TransactionDTO transactionDTO) {
        splitwiseService.addTransaction(transactionDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void registeruser(@RequestBody String username) {
        splitwiseService.registerUser(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createGroup")
    public void createGroup(@RequestBody Integer groupid) {
        splitwiseService.createGroup(groupid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUserToGroup")
    public void addUserToGroup(@RequestBody Integer groupid,@RequestBody String username) {
        splitwiseService.addUsertoGroup(groupid,username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getTransactions")
    public ArrayList<Transaction> getTransaction(@RequestBody Integer groupid) {
        return splitwiseService.getTransaction(groupid);
    }
}
