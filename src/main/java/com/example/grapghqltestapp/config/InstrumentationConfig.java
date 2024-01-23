package com.example.grapghqltestapp.config;

import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * to enable trace logging in playground
 */
@Slf4j
@Component
public class InstrumentationConfig extends TracingInstrumentation {
}
