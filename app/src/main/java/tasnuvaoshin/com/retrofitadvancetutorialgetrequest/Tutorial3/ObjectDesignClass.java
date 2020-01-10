package tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3;

public class ObjectDesignClass {

    private String fullname;
    private String dateofbirth;
    private String gender;
    private PositionClass position;

    public PositionClass getPositionClass() {
        return position;
    }

    public void setPosition(PositionClass position) {
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ObjectDesignClass() {
    }

    public ObjectDesignClass(String fullname, String dateofbirth, String gender,PositionClass position) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.position = position;
    }
}
