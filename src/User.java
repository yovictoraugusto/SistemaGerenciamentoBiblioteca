public class User {
    public String name;
    public String email;
    public String celular;

    public User(String name, String email, String celular){
        this.name = name;
        this.email = email;
        this.celular = celular;
    }

    public String getCelular(){return this.celular;}

    
}
