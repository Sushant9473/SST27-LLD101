package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
import java.util.Collections;

public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        // Defensive copy and unmodifiable
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, OrderLine firstLine) {
            this.id = id;
            this.customerEmail = customerEmail;
            if (firstLine == null) throw new IllegalArgumentException("At least one line required");
            this.lines.add(copyLine(firstLine));
        }

        public Builder addLine(OrderLine line) {
            if (line == null) throw new IllegalArgumentException("OrderLine cannot be null");
            this.lines.add(copyLine(line));
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email");
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be 0..100");
            }
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            return new Order(this);
        }

        // Defensive copy of OrderLine
        private static OrderLine copyLine(OrderLine l) {
            return new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents());
        }
    }
}
