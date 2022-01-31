public class Employee {
    private String First_name;
    private String Last_name;

    private int UniId;

    public Employee(String first_name, String last_name, int uniId) {
        First_name = first_name;
        Last_name = last_name;
        UniId = uniId;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public int getUniId() {
        return UniId;
    }

    public void setUniId(int uniId) {
        UniId = uniId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", UniId=" + UniId +
                '}';
    }

}
