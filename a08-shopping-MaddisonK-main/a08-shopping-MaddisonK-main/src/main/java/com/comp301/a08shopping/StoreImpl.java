package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StoreImpl implements Store {
  private String name;
  private List<StoreObserver> observers = new ArrayList<>();
  private List<Product> products = new ArrayList<>();

  public StoreImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    if (observers.contains(observer)) {
      return;
    } else {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    List<Product> retList = new ArrayList<>();
    for (Product item : products) {
      retList.add(item);
    }
    return retList;
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == null || basePrice <= 0.0 || inventory < 0) {
      throw new IllegalArgumentException();
    }
    Product product = new ProductImpl(name, basePrice, inventory);
    products.add(product);
    return product;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) throws OutOfStockException {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl purchase = (ProductImpl) products.get(products.indexOf(product));
      try {
        double price = purchase.purchaseProduct();
        notify(new PurchaseEvent(purchase, this));
        if (purchase.outOfStock()) {
          notify(new OutOfStockEvent(purchase, this));
        }
        return new ReceiptItemImpl(purchase.getName(), price, this.name);
      } catch (OutOfStockException e) {
        notify(new OutOfStockEvent(purchase, this));
        throw new OutOfStockException();
      }
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl restock = (ProductImpl) products.get(products.indexOf(product));
      if (restock.outOfStock() && numItems > 0) {
        notify(new BackInStockEvent(restock, this));
      }
      restock.restockProduct(numItems);
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff <= 0 || percentOff >= 1.0) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl saleProduct = (ProductImpl) products.get(products.indexOf(product));
      saleProduct.discount(percentOff);
      notify(new SaleStartEvent(saleProduct, this));
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl revertProduct = (ProductImpl) products.get(products.indexOf(product));
      revertProduct.revert();
      notify(new SaleEndEvent(revertProduct, this));
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      return ((ProductImpl) products.get(products.indexOf(product))).getQuantity();
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      return (!((ProductImpl) products.get(products.indexOf(product))).outOfStock());
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      return ((ProductImpl) products.get(products.indexOf(product))).getSellPrice();
    } else {
      throw new ProductNotFoundException();
    }
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product)) {
      ProductImpl current = ((ProductImpl) products.get(products.indexOf(product)));
      return (current.getSellPrice() != current.getBasePrice());
    } else {
      throw new ProductNotFoundException();
    }
  }

  private void notify(StoreEvent event) {
    for (StoreObserver ob : observers) {
      ob.update(event);
    }
  }
}
