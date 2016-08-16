package controller;

import common.BaseController;

/**
 * Created by Xiaofeng on 2016/8/16.
 */
public class HelloWorldController extends BaseController {
    public void index(){
        renderText("Hello World !");
    }
}
