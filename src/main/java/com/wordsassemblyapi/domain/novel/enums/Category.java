package com.wordsassemblyapi.domain.novel.enums;

import java.util.Objects;

public enum Category {
  ALL("all"),
  MISTERY("mistery"),
  LOVESTORY("lovestory"),
  SF("sf"),
  FANTASY("fantasy"),
  HORROR("horror"),
  KIDS("kids"),
  OTHER("other");

  private final String category;

  Category(String category) {
    this.category = category;
  }

  public static Category getEnum(String category) {
    for (Category c : Category.values()) {
      if (Objects.equals(c.category, category)) {
        return c;
      }
    }
    throw new IllegalArgumentException("不正なジャンル: " + category);
  }
}
