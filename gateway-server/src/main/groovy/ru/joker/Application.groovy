package ru.joker

import info.developerblog.services.auth.TAuthToken
import info.developerblog.services.auth.TUnauthorizedException
import info.developerblog.services.auth.TUser
import org.apache.thrift.TException
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean
import ru.aatarasoff.thrift.api.gateway.core.AuthTokenExchanger

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrixDashboard
public class Application {
    public static final int DEFAULT_PADDING = 50

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run Application, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }

    @Bean
    AuthTokenExchanger<TAuthToken, TUser> authTokenExchanger() {
        return new AuthTokenExchanger<TAuthToken, TUser>() {
            @Override
            TAuthToken createEmptyAuthToken() {
                return new TAuthToken()
            }

            @Override
            TUser process(TAuthToken authToken) throws TException {
                if ("ABCD".equals(authToken.getToken())) {
                    return new TUser().setUserId(1L)
                }

                throw new TUnauthorizedException("!!!")
            }
        }
    }
}