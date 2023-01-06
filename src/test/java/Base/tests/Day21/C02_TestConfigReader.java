package Base.tests.Day21;

import Base.utilities.ConfigReader;
import Base.utilities.Driver;
import org.testng.annotations.Test;

public class C02_TestConfigReader {


    @Test
    public void readConfig() {

        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        Driver.quitDriver();

    }


}
