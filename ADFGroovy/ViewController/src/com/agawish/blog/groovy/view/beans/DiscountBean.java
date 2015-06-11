package com.agawish.blog.groovy.view.beans;

import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

public class DiscountBean {
    private Double subtotal;
    private Double total;

    public DiscountBean() {
        super();
    }

    public String submitSubtotal() throws IOException {
        //Path to physical file
        //TODO Change me
        File discountFile =
            new File("C:\\Users\\amr\\dev\\ADFGroovy\\ViewController\\public_html\\WEB-INF\\discountvalue.groovy");
        String discountValue = "";
        if (discountFile.exists()) {
            GroovyShell shell = new GroovyShell();
            Object value;
            value = shell.evaluate(discountFile);
            if (value != null) {
                if (value instanceof String) {
                    discountValue = (String)value;
                }
            }
            //Calculate the amount of discount to subtract
            Double discount =
                (Double.parseDouble(discountValue) / 100) * subtotal;

            //Get the total
            total = subtotal - discount;
        }
        return null;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }
}
