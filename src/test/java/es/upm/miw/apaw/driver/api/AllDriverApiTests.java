package es.upm.miw.apaw.driver.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.driver.api.controllers.AllDriverApiControllersTests;
import es.upm.miw.apaw.driver.api.daos.memory.AllDriverApiDaosMemoryTests;
import es.upm.miw.apaw.driver.api.entities.AllDriverApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllDriverApiControllersTests.class,
    AllDriverApiEntitiesTests.class,
    AllDriverApiDaosMemoryTests.class
})
public class AllDriverApiTests {

}
