package edu.isu.cs.cs3321.sql.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@BelongsTo(parent = Customer.class, foreignKeyName = "customer_id")
public class Order extends Model {

    public Order() {
        super();

        setDate("order_date", new Date(Calendar.getInstance().getTime().getTime()));
        save();
    }

    public int getOrderedQuantity(Product prod) {
        OrderLine line = getOrderLineForProduct(prod);
        if (line != null) return line.getQuantity();
        return 0;
    }

    public void addOrderLine(Product prod, int quantity) {
        add(prod);
        save();
        OrderLine line = getOrderLineForProduct(prod);
        if (line != null)
            line.setQuantity(quantity);
    }

    private OrderLine getOrderLineForProduct(Product prod) {
        return OrderLine.findFirst("order_id = ? and product_id = ?", this.getId(), prod.getId());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%-50s  Quantity\n", "Description"));
        builder.append("--------------------------------------------------  --------\n");

        List<Product> products = getAll(Product.class);
        products.forEach(p -> {
            int quantity = getOrderLineForProduct(p).getQuantity();
            String desc = p.getString("description");

            builder.append(String.format("%-50s  %8d\n", desc, quantity));
        });

        return builder.toString();
    }
}
