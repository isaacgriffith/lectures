package edu.isu.cs.cs3321.sql.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("order_lines")
public class OrderLine extends Model {

    public int getQuantity() {
        return getInteger("quantity");
    }

    public void setQuantity(int quantity) {
        setInteger("quantity", quantity);
        save();
    }
}
