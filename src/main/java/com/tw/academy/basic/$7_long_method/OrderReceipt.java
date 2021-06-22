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

        buildTotalSalesTaxInfo(output, totalSalesTax);

        buildTotalAmountInfo(output, totalAmount);
        return output.toString();
    }

    private void buildTotalAmountInfo(StringBuilder output, double totalAmount) {
        output.append(TOTAL_AMOUNT_LABEL).append('\t').append(totalAmount);
    }

    private void buildTotalSalesTaxInfo(StringBuilder output, double totalSalesTax) {
        output.append(SALES_TAX_LABEL).append('\t').append(totalSalesTax);
    }

    private void buildLineItemsInfo(StringBuilder output) {
        output.append(order.getOrderItemsInfo());
    }

    private void buildCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerInfo());
    }
}