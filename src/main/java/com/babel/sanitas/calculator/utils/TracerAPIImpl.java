package com.babel.sanitas.calculator.utils;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class TracerAPIImpl implements TracerAPI {
    private TracerImpl tracer;

    public TracerAPIImpl() {
        tracer = new TracerImpl();
    }

    @Override
    public <T> void trace(T t) {
        this.tracer.trace(t);
    }
}
