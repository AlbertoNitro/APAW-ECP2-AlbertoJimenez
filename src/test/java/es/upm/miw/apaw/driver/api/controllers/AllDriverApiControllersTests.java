package es.upm.miw.apaw.driver.api.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DriverControllerIT.class, 
    CarControllerIT.class
})
public class AllDriverApiControllersTests {

}
