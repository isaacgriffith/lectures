package edu.isu.cs.cs3321.sql.model;

import lombok.Builder;
import org.javalite.activejdbc.Model;

public class Customer extends Model {

    public Customer() {
        super();
    }

    @Builder(buildMethodName = "create")
    public Customer(String name, String address, String city, String state, String postalCode) {
        this();
        set("name", name, "address", address, "city", city, "state", state, "postal_code", postalCode);
        save();
    }

    public void setName(String name) {
        setString("name", name);
        save();
    }

    public void setAddress(String street, String city, String state, String zip) {
        setString("address", street);
        setString("city", city);
        setString("state", state);
        setString("postal_code", zip);
        save();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s\n", getString("name")));
        builder.append(String.format("%s\n", getString("address")));
        builder.append(String.format("%s, %s  %s\n", getString("city"), getString("state"), getString("postal_code")));
        return builder.toString();
    }

}
