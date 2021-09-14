package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private Player player;
  private Map map;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException();
    }
    this.player = player;
    this.map = map;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return (player.getInventory().getItems().size() == map.getNumItems());
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(getPlayerPosition()).getName());
    System.out.println(map.getCell(getPlayerPosition()).getDescription());
    if (map.getCell(getPlayerPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(getPlayerPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(getPlayerPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!map.getCell(getPlayerPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
      return;
    }
    if (map.getCell(getPlayerPosition()).getChest().isEmpty()) {
      System.out.println("The chest is empty.");
      return;
    }
    System.out.println(
        "You collected these items: " + map.getCell(getPlayerPosition()).getChest().getItems());
    player.getInventory().transferFrom(map.getCell(getPlayerPosition()).getChest());
    //    String items_print = "You collected these items: ";
    //    for (Item item: map.getCell(getPlayerPosition()).getChest().getItems()) {
    //      items_print += item.toString();
    //    }

  }

  @Override
  public boolean canMove(Direction direction) {
    try {
      if (map.getCell(getPlayerPosition().getNeighbor(direction)) == null) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
