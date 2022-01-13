package co.com.practice.taks;

import co.com.practice.interactions.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeDelete implements Task {
    private final String resource;

    public ConsumeDelete(String resource) {
        this.resource = resource;
    }

    public static ConsumeDelete service(String resource) {
        return Tasks.instrumented(ConsumeDelete.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.service(resource));
    }
}
