package com.example.tasks.demo;

import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

final public class ImmStock {
    private final BigDecimal price;
    private final String name;
    private final List<String> stocks;

    public ImmStock(BigDecimal price, String name, List<String> stocks) {
        this.price = Optional.ofNullable(price)
                .map(BigDecimal::toString)
                .map(BigDecimal::new)
                .orElse(null);
        this.name = name;
        this.stocks = ImmutableList.copyOf(emptyIfNull(stocks));
    }

    public BigDecimal getPrice() {
        return Optional.ofNullable(this.price)
                .map(BigDecimal::toString)
                .map(BigDecimal::new)
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public List<String> getStocks() {
        return ImmutableList.copyOf(stocks);
    }

    @Override
    public String toString() {
        return "ImmStock{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", stocks=" + stocks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmStock immStock = (ImmStock) o;
        return Objects.equals(price, immStock.price) &&
                Objects.equals(name, immStock.name) &&
                Objects.equals(stocks, immStock.stocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, stocks);
    }

    public static void main(String[] args) {
        final ImmStock immStock = new ImmStock(BigDecimal.valueOf(1), "First", new ArrayList<>());
        System.out.println(immStock);
    }
}
