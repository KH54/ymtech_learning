package com.ymtech.board.vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.BiConsumer;

public interface GenericVo<PreparedStatement, T> {
   
  void accept(PreparedStatement stmt);
}
