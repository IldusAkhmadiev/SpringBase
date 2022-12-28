package org.ildus.akhamdiev.iocDi;

import org.springframework.stereotype.Component;


public class RockMusic implements  Music{
    @Override
    public String getSong() {
        return "Rock music";
    }
}
