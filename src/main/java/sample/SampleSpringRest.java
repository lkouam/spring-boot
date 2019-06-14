package sample;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleSpringRest {

    private static final String template = "%s it's, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/time")
    public Data greeting(@RequestParam(value="name", defaultValue="Hey") String name) {
        return new Data(counter.incrementAndGet(),
                            String.format(template, name, LocalDateTime.now().toString()));
    }
}