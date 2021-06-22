package com.tw.academy.basic.$7_long_method;

import java.util.List;

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
        double totalAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalAmount += lineItem.getTotalAmountWithSalesTax();
        }
        return totalAmount;
    }

    public double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax();
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    public String getOrderItemsInfo() {
        String orderItemsInfo = "";
        for (LineItem lineItem : getLineItems()) {
            orderItemsInfo = orderItemsInfo.concat(lineItem.toString());
            orderItemsInfo = orderItemsInfo.concat("\n");
        }
        return orderItemsInfo;
    }
}
