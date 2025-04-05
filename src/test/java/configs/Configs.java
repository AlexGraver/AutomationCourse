package configs;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:timeout.properties",
        "classpath:sycretKey.properties"
})


public interface Configs extends Config{

    @Key("explicit.wait")
    int explicitWait();

    @Key("implicit.wait")
    int implicitWait();

    @Key("polling.fluent")
    int fluentPolling();

    @Key("timeout.fluent")
    int fluentTimeout();

}
