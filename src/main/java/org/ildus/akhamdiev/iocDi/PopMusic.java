package org.ildus.akhamdiev.iocDi;

import org.springframework.stereotype.Component;


public class PopMusic implements Music {
    @Override
    public String getSong() {
        return "Pop music";
    }
}
