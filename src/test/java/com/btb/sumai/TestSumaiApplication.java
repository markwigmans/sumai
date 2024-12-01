package com.btb.sumai;

import org.springframework.boot.SpringApplication;

public class TestSumaiApplication {

    public static void main(String[] args) {
        SpringApplication.from(SumaiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
