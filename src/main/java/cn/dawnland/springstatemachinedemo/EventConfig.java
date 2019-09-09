package cn.dawnland.springstatemachinedemo;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author Created by cap_sub@dawnland.cn
 */
@WithStateMachine
public class EventConfig {

    @OnTransition(target = "NOT_LOGIN")
    public void create(){
        System.out.println("未登录");
    }

    @OnTransition(source = "NOT_LOGIN", target = "LOGINED")
    public void loginSuccess(){
        System.out.println("登录成功");
    }

    @OnTransition(source = "NOT_LOGIN", target = "NOT_LOGIN")
    public void loginFailuer(){
        System.out.println("登录失败");
    }

    @OnTransition(source = "LOGINED", target = "NOT_LOGIN")
    public void logout(){
        System.out.println("退出登录");
    }

}
