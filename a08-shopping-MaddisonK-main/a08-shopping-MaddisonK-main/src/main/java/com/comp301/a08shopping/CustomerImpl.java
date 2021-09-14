package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {
  private String name;
  private double budget;
  private List<ReceiptItem> receipts = new ArrayList<>();

  public CustomerImpl(String name, double budget) {
    if (name == null || budget < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.budget = budget;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBudget() {
    return budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException();
    }
    double price = store.getSalePrice(product);
    if (price > budget) {
      throw new IllegalStateException();
    } else {
      budget -= price;
      receipts.add(store.purchaseProduct(product));
    }
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    List<ReceiptItem> retList = new ArrayList<>();
    for (ReceiptItem item : receipts) {
      retList.add(item);
    }
    return retList;
  }

  @Override
  public void update(StoreEvent event) {
    if (event == null) {
      throw new IllegalArgumentException();
    }
    if (event instanceof BackInStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    } else if (event instanceof OutOfStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    } else if (event instanceof PurchaseEvent) {
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    } else if (event instanceof SaleEndEvent) {
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    } else if (event instanceof SaleStartEvent) {
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
    }
  }
}
