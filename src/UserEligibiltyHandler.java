public class UserEligibiltyHandler{
    public UserEligibiltyHandler(){}
    private LoanLimitHandler limitHandler = new LoanLimitHandler();

    public boolean verifyUser(User user){
        if(user != null){
            Integer limit = limitHandler.getLimit(user);
            Integer LoanedQuantity = user.getLoanedQuantity();

            if(LoanedQuantity < limit){
                return true;
            }
        }
        return false;
    }
}