package com.example.grapghqltestapp.config;

import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;

@Configuration
public class GraphqlConfig /*extends GraphQlWebMvcAutoConfiguration*/{

//    @Bean
//    @Primary
//    public GraphQlProperties graphQlProperties(){
//        return new MyGraphQlProperties();
//    }
//
//    @Override
//    public RouterFunction<ServerResponse> graphQlRouterFunction(GraphQlHttpHandler httpHandler, GraphQlSource graphQlSource, GraphQlProperties properties) {
//        return super.graphQlRouterFunction(httpHandler, graphQlSource, properties);
//    }

//    @Bean
//    public GraphQlSourceBuilderCustomizer graphQlSourceBuilderCustomizer(){
//        ClassNameTypeResolver classNameTypeResolver = new ClassNameTypeResolver();
//        classNameTypeResolver.addMapping(BankAccountResponse.class, "CustomerAccountSuccess");
////        classNameTypeResolver.addMapping(BankAccountResponse.class, "CustomerAccountSuccess");
//        return builder -> builder.defaultTypeResolver(classNameTypeResolver);
//    }
}
