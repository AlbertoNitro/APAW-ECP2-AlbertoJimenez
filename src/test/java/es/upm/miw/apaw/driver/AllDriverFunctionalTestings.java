package es.upm.miw.apaw.driver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DriverResourceFunctionalTesting.class, 
    CarResourceFunctionalTesting.class
})
public class AllDriverFunctionalTestings {

}
