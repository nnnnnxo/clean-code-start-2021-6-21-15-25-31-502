package com.tw.academy.basic.$7_long_method;

import static com.tw.academy.basic.$7_long_method.Separator.TAB_SEPARATOR;

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

    public String build() {
        StringBuilder receipt = new StringBuilder();

        buildReceiptHeader(receipt);
        buildCustomerInfo(receipt);
        buildLineItemsInfo(receipt);
        buildTotalSalesTaxInfo(receipt, order.getTotalSalesTax());
        buildTotalAmountInfo(receipt, order.getTotalAmount());

        return receipt.toString();
    }

    private void buildReceiptHeader(StringBuilder receipt) {
        receipt.append(RECEIPT_HEADER);
    }

    private void buildTotalAmountInfo(StringBuilder receipt, double totalAmount) {
        receipt.append(TOTAL_AMOUNT_LABEL).append(TAB_SEPARATOR).append(totalAmount);
    }

    private void buildTotalSalesTaxInfo(StringBuilder receipt, double totalSalesTax) {
        receipt.append(SALES_TAX_LABEL).append(TAB_SEPARATOR).append(totalSalesTax);
    }

    private void buildLineItemsInfo(StringBuilder receipt) {
        receipt.append(order.getOrderItemsInfo());
    }

    private void buildCustomerInfo(StringBuilder receipt) {
        receipt.append(order.getCustomerInfo());
    }
}