package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author Thoughtworks
 * @version 1.0
 * @since 2018-1-1
 */
public class OrderReceipt {
    public static final String RECEIPT_HEADER = "======Printing Orders======\n";
    public static final String SALES_TAX_LABEL = "Sales Tax";
    public static final String TOTAL_AMOUNT_LABEL = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    // TODO: Long method
    public String build() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append(RECEIPT_HEADER);

        // TODO: Feature envy
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            buildLineItemInfo(output, lineItem);

            // calculate sales tax @ rate of 10%
            // TODO: Feature envy & Magic number
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // TODO: Feature envy
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append(SALES_TAX_LABEL).append('\t').append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT_LABEL).append('\t').append(totalAmount);
        return output.toString();
    }

    private void buildLineItemInfo(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.toString());
        output.append("\n");
    }
}