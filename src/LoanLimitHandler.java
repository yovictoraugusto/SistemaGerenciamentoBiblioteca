public class LoanLimitHandler{
    private Integer comum_user = 3;
    private Integer student_user = 5;
    private Integer teacher_user = 10;
    private Integer employee_user = 8;

    public void setComumUser(Integer n){
        this.comum_user = n;
    }

    public void setStudentUser(Integer n){
        this.comum_user = n;
    }

    public void setTeacherUser(Integer n){
        comum_user = n;
    }

    public void setEmployeeUser(Integer n){
        comum_user = n;
    }

    public Integer getComumUser(){
        return this.comum_user;
    }

    public Integer getStudentUser(){
        return this.student_user;
    }

    public Integer getTeacherUser(){
        return this.teacher_user;
    }

    public Integer getEmployeeUser(){
        return this.employee_user;
    }

    public Integer getLimit(User user){
        if (user instanceof StudentUserType){
            return this.student_user;
        } 
        else if (user instanceof TeacherUserType){
            return this.teacher_user;
        }
        else if (user instanceof EmployeeUserType){
            return this.employee_user;
        }
        else{
            return this.comum_user;
        }

    }
}