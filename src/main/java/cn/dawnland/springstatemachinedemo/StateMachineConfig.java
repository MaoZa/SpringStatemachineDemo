package cn.dawnland.springstatemachinedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

/**
 * @author Created by cap_sub@dawnland.cn
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<Status, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<Status, Events> states) throws Exception {
        states
                .withStates()
                .initial(Status.NOT_LOGIN)
                .state(Status.LOGINED, action())
                .end(Status.LOGINED);
    }

    @Bean
    public LoginAction action(){
        return new LoginAction();
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<Status, Events> transitions) throws Exception {
        transitions
                .withExternal()
                    .source(Status.NOT_LOGIN).target(Status.LOGINED)
                    .event(Events.LOGIN_SUCCESS)
                    .and()
                .withExternal()
                    .source(Status.NOT_LOGIN).target(Status.NOT_LOGIN)
                    .event(Events.LOGIN_FAILUER)
                    .and()
                .withExternal()
                    .source(Status.LOGINED).target(Status.NOT_LOGIN)
                    .event(Events.LOGOUT);
    }
}
