package org.ildus.akhamdiev.iocDi;

import org.springframework.stereotype.Component;


public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Classic music";
    }
}
