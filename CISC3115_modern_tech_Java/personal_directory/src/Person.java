public abstract class Person{
    private String firstName,lastName,memberType;

    public Person(String firstName,String lastName,String memberType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberType = memberType;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMemberType(){
        return memberType;
    }

    public abstract int getId();
}
