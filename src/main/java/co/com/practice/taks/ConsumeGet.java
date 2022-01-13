package co.com.practice.taks;

import co.com.practice.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeGet implements Task {
    private final String resource;

    public ConsumeGet(String resource) {
        this.resource = resource;
    }

    public static ConsumeGet service(String resource) {
        return Tasks.instrumented(ConsumeGet.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(resource));
    }
}
