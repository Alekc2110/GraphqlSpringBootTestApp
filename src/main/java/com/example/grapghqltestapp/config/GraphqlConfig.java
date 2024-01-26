package com.example.grapghqltestapp.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

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

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){
        return builder -> builder.scalar(ExtendedScalars.LocalTime);
    }
}
