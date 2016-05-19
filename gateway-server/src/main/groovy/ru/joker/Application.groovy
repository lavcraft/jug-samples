package ru.joker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import zipkin.server.EnableZipkinServer

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableZipkinServer
public class Application {
    public static final int DEFAULT_PADDING = 50

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run Application, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }
}