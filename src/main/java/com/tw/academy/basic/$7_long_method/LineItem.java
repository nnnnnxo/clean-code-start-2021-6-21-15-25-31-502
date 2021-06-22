package com.tw.academy.basic.$7_long_method;

public class LineItem {
	public static final double SALE_TAX_RATE = .10;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double p, int quantity) {
		super();
		this.description = description;
		this.price = p;
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
		return getDescription() + "\t" + getPrice() + "\t" + getQuantity() + "\t" + totalAmount();
	}

	public double getSalesTax() {
		return totalAmount() * SALE_TAX_RATE;
	}

	public double getTotalAmountWithSalesTax() {
		return totalAmount() + getSalesTax();
	}
}