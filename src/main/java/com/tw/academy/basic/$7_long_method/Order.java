package com.tw.academy.basic.$7_long_method;

import java.util.List;

import static com.tw.academy.basic.$7_long_method.Separator.LINE_SEPARATOR;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getCustomerInfo() {
        return getCustomerName() + getCustomerAddress();
    }

    public double getTotalAmount() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalAmountWithSalesTax).sum();
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    public String getOrderItemsInfo() {
        String orderItemsInfo = "";
        for (LineItem lineItem : getLineItems()) {
            orderItemsInfo = orderItemsInfo.concat(lineItem.toString());
            orderItemsInfo = orderItemsInfo.concat(LINE_SEPARATOR);
        }
        return orderItemsInfo;
    }
}
