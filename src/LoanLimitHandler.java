public class LoanLimitHandler{
    private Integer comum_user = 3;
    private Integer student_user = 5;
    private Integer teacher_user = 10;
    private Integer employee_user = 8;

    public LoanLimitHandler(){
        this.comum_user = 3;
        this.student_user = 5;
        this.teacher_user = 10;
        this.employee_user = 8;
    }

    public void setComumUser(Integer n)
    {this.comum_user = n;}

    public void setStudentUser(Integer n)
    {this.student_user = n;}

    public void setTeacherUser(Integer n)
    {this.teacher_user = n;}

    public void setEmployeeUser(Integer n)
    {this.employee_user = n;}

    public Integer getComumUser()
    {return this.comum_user;}

    public Integer getStudentUser()
    {return this.student_user;}

    public Integer getTeacherUser()
    {return this.teacher_user;}

    public Integer getEmployeeUser()
    {return this.employee_user;}

    public Integer getLimit(User user)
    {
        StudentUserType student = new StudentUserType(null, null, null);
        TeacherUserType teacher = new TeacherUserType(null, null, null);
        EmployeeUserType employee = new EmployeeUserType(null, null, null);

        if (user.getClass() == student.getClass())
        {return this.getStudentUser();} 
        else if(user.getClass() == teacher.getClass())
        {return this.getTeacherUser();}
        else if (user.getClass() ==  employee.getClass())
        {return this.getEmployeeUser();}
        else
        {return this.getComumUser();}
    }
}