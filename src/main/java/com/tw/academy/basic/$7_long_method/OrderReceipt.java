package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    // TODO: Long method
    public String build() {
        StringBuilder output = new StringBuilder();

        // print headers
        // TODO: Magic number
        output.append("======Printing Orders======\n");

        // TODO: Feature envy
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // TODO: Naming
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            // TODO: Feature envy
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            // TODO: Feature envy & Magic number
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // TODO: Feature envy
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        // TODO: Magic number
        output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        // TODO: Magic number
        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }
}