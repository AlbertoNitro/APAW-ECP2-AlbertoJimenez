package es.upm.miw.apaw.driver.api.entities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DriverTest.class,
    DriverBuilderTest.class,
    CarTest.class,
    CarBuilderTest.class
})
public class AllDriverApiEntitiesTests {

}
