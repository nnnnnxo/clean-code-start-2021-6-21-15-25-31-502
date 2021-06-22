package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    // TODO: Naming
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    // TODO: Dead Code
    //Deprecated
    public String printCustomerName() {
        return o.getCustomerName();
    }

    // TODO: Long method & Naming
    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        // TODO: Magic number
        output.append("======Printing Orders======\n");

        // TODO: Dead Code
        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        // TODO: Feature envy
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
        // TODO: Dead Code
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        // TODO: Naming
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
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