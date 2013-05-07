package org.cru.give.cdi;

import javax.enterprise.inject.Produces;

import org.ccci.util.time.Clock;

public class ClockProducer
{

    @Produces
    Clock systemClock = Clock.system();

}
