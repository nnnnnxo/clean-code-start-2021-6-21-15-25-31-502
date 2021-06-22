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

        buildCustomerInfo(output);

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        buildLineItemsInfo(output);

        totalSalesTax = order.getTotalSalesTax();

        totalAmount = order.getTotalAmount();

        // prints the state tax
        output.append(SALES_TAX_LABEL).append('\t').append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT_LABEL).append('\t').append(totalAmount);
        return output.toString();
    }

    private void buildLineItemsInfo(StringBuilder output) {
        String lineItemsInfo = getOrderItemsInfo();
        output.append(lineItemsInfo);
    }

    private String getOrderItemsInfo() {
        String orderItemsInfo = "";
        for (LineItem lineItem : order.getLineItems()) {
            orderItemsInfo = orderItemsInfo.concat(lineItem.toString());
            orderItemsInfo = orderItemsInfo.concat("\n");
        }
        return orderItemsInfo;
    }

    private void buildCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerInfo());
    }

}