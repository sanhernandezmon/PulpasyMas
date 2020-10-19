package pulpas.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {

    private String email;
    private String name;
    private long phoneNumber;
    private int numberOfOrdersDone;

    public Cliente() {
    }

    public Cliente(@JsonProperty("email") String email,
                @JsonProperty("name") String name,
                @JsonProperty("phoneNumber") long phoneNumber
    ) {

        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numberOfOrdersDone = 0;
    }

    @Override
    public String toString() {
        return "User{" +
            "email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", phoneNumber=" + phoneNumber +
            ", numberOfOrdersdone=" + numberOfOrdersDone +
            '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfOrdersDone() {
        return numberOfOrdersDone;
    }

    public void setNumberOfOrdersDone(int numberOfOrdersDone) {
        this.numberOfOrdersDone = numberOfOrdersDone;
    }
}
