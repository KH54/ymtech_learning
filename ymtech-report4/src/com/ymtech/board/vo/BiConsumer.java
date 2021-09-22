package com.ymtech.board.vo;

import java.sql.PreparedStatement;

public interface BiConsumer<S, T>{
    
    default void accept(PreparedStatement stmt) {}
}