package cn.dawnland.springstatemachinedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by cap_sub@dawnland.cn
 */
@RestController
public class TestController {

    @Autowired
    private StateMachine<Status, Events> stateMachine;

    @GetMapping("test")
    public void test(){
        stateMachine.start();
    }

    @GetMapping("login")
    public void login(){
        Message<Events> message = MessageBuilder
                .withPayload(Events.LOGIN_SUCCESS)
                .setHeader("header", 1+1)
                .build();
        stateMachine.sendEvent(message);
    }

    @GetMapping("loginfail")
    public void loginfail(){
        stateMachine.sendEvent(Events.LOGIN_FAILUER);
    }

    @GetMapping("logout")
    public void logout(){
        stateMachine.sendEvent(Events.LOGOUT);
    }

}
