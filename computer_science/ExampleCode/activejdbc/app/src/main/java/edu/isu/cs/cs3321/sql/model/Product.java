package edu.isu.cs.cs3321.sql.model;

import lombok.Builder;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Many2Many;

import java.math.BigDecimal;

@Many2Many(other = Order.class, join = "order_lines", sourceFKName = "product_id", targetFKName = "order_id")
public class Product extends Model {

    public Product() {
        super();
    }

    @Builder(buildMethodName = "create")
    public Product(String description, String finish, double price, int productLine) {
        this();
        setString("description", description);
        setString("finish", finish);
        setBigDecimal("price", new BigDecimal(price));
        setInteger("product_line_id", productLine);
        save();
    }

    public void setDescription(String desc) {
        setString("description", desc);
        save();
    }

    public void setPrice(double price) {
        setBigDecimal("price", new BigDecimal(price));
        save();
    }

    public void setFinish(String finish) {
        setString("finish", finish);
        save();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Description: %s\n", getString("description")));
        builder.append(String.format("Finish: %s\n", getString("finish")));
        builder.append(String.format("Price: %s\n", getBigDecimal("price").toPlainString()));
        return builder.toString();
    }
}
