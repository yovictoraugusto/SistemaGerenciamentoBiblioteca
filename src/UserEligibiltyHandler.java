public class UserEligibiltyHandler{
    public UserEligibiltyHandler(){}
    private LoanLimitHandler limitHandler;

    public boolean verifyUser(User user){
        Integer limit = limitHandler.getLimit(user);
        Integer LoanedQuantity = user.getLoanedQuantity();

        if(LoanedQuantity < limit){
            return true;
        }
        return false;
    }
}