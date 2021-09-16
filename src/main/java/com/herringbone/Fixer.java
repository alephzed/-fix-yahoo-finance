package com.herringbone;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Fixer {

    private static final String YAHOO_COOKIE = "";
    private static final String YAHOO_CRUMB_ = "";
    private LocalDateTime YAHOO_CHECKED = null;
    private static final int YAHOO_TTL = 180;

    protected String[] getYahooCrumb( boolean force ) {
        if (YAHOO_CHECKED != null && !force) {
            LocalDateTime now = LocalDateTime.now();
            long delta = ChronoUnit.SECONDS.between(now, YAHOO_CHECKED);
            if (delta < YAHOO_TTL) {
                return new String[]{YAHOO_CRUMB_, YAHOO_COOKIE};
            }
        }
        return null;
    }
}
