package com.ynagano.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ynagano.board.mapper")
public class BoardConfig {
}
