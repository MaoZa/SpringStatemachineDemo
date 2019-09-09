package cn.dawnland.springstatemachinedemo;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 * @author Created by cap_sub@dawnland.cn
 */
public class LoginAction implements Action<Status, Events> {

    @Override
    public void execute(StateContext<Status, Events> stateContext) {
        //controller 发送message event 状态成功变更后 触发到此进行业务逻辑处理
        System.out.println("action");
    }

}
