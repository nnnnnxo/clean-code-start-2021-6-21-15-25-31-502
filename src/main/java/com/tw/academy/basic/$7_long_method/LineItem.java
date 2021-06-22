package com.tw.academy.basic.$7_long_method;

import static com.tw.academy.basic.$7_long_method.Separator.TAB_SEPARATOR;

public class LineItem {
	public static final double SALE_TAX_RATE = .10;
	private final String description;
	private final double price;
	private final int quantity;

	public LineItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	public String toString() {
		return getDescription() + TAB_SEPARATOR + getPrice() + TAB_SEPARATOR + getQuantity() + TAB_SEPARATOR + totalAmount();
	}

	public double getSalesTax() {
		return totalAmount() * SALE_TAX_RATE;
	}

	public double getTotalAmountWithSalesTax() {
		return totalAmount() + getSalesTax();
	}
}