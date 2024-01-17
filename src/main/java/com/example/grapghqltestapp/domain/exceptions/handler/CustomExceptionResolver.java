package com.example.grapghqltestapp.domain.exceptions.handler;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(@NotNull Throwable ex, @NotNull DataFetchingEnvironment env) {

        // Example of catching validation BindException and return customized response
        if (ex instanceof BindException) {
            Optional<ObjectError> errorOptional = ((BindException) ex).getBindingResult().getAllErrors().stream().findFirst();
            AtomicReference<GraphQLError> error = new AtomicReference<>();
            errorOptional.ifPresent(objectError -> {
                log.info("error field name: {}", objectError.getDefaultMessage());
                error.set(GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.BAD_REQUEST)
                        .message("bad request for the argument value %s", objectError.getObjectName())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build());

            });
            return error.get();
        }
        if (ex instanceof DataIntegrityViolationException e) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message("DataIntegrityViolationException: %s", e.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }
        // Example of catching custom runtime exception
        if (ex instanceof RuntimeException e) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message("runtime exception: %s", e.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }
            return null;
    }
}
