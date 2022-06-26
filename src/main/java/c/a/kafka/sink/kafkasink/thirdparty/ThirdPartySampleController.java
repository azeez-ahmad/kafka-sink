package c.a.kafka.sink.kafkasink.thirdparty;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartySampleController {
    @PostMapping("/thirdparty")
    public String me(@RequestBody String message){

        System.out.println("*@*@*@**@*@**@*@* THIRD PARTY @**@*@*@**@*@*@**@*@**@");
        System.out.println(message);
        return "message received";

    }
}
