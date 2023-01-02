package org.ildus.akhamdiev.enums;

import java.util.Locale;

public enum CalculatorEnum {

    MULTIPLICATION{
        public double action(double x, double y){ return x * y;}
    },
    ADDITION{
        public double action(double x, double y){ return x + y;}
    },
    SUBTRACTION{
        public double action(double x, double y){ return x - y;}
    },
    DIVISION{
        public double action(double x, double y){ return x / y;}
    };

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    public abstract double action(double x, double y);
}
