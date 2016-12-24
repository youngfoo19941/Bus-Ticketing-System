package domain;

public class Staff{
    private String ID;
    private String name;
    private String ic;
    private String address;
    private String password;
    private String gender;
    private String position;
    private int age;
    private String contactNo;
    private String email;
    
    

    public Staff(){
    }
    
    public Staff(String ID,String name,String ic, String address, String password,String gender, String position, int age,String contactNo,String email) {
        this.ID = ID;
        this.name = name;
        this.ic = ic;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.position = position;
        this.age = age;
        this.contactNo = contactNo;
        this.email = email;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getIC() {
        return ic;
    }

    public void setIC(String ic) {
        this.ic = ic;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
     public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getcontactNo() {
        return contactNo;
    }

    public void setcontacteNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
    
    
}
