 package src.main.webapp.java.org.example.domain;

 import src.main.webapp.java.org.example.validation.PhoneConstraint;

 import javax.validation.constraints.NotEmpty;
 import javax.validation.constraints.Size;
 import java.util.List;


 public class User {

    private long userId;

    @NotEmpty
    @Size(min = 3, max = 200, message = "Please enter your name between {min} and {max} characters")
    private String firstname;

    @NotEmpty
    @Size(min = 3, max = 200, message = "Please enter your name between {min} and {max} characters")
    private String lastname;

    @NotEmpty
    @PhoneConstraint
    private String phone;

    private String gender;
    private List<UserActivityAccess> accessList;

    public User() {
    }

    public User(long userid, String firstname,  String lastname ,String phone, String gender) {
        this.userId = userid;
        this.firstname = firstname;
        this.lastname=lastname;
        this.phone=phone;
        this.gender=gender;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

     public List<UserActivityAccess> getAccessList() {
         return accessList;
     }

     public void setAccessList(List<UserActivityAccess> accessList) {
         this.accessList = accessList;
     }

     @Override
    public String toString() {
        return "User{" +
                ", userId=" + userId +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                '}';
    }
}
