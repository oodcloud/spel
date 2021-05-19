package com.tg.spel.params;

import com.tg.spel.validator.SpelValid;

/**
 * @author wangyujie
 */
@SpelValid(value = "name != '3'", applyIf = "app == '2'", message = "错误不能为2")
public class RequestTest {

    private String name;
    @SpelValid(value = "#root == '2'", message = "错误不能为test")
    private String app;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
