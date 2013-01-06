#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * The MIT License
 *
 * Copyright 2013 Nazar Annagurban.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ${package}.controller;

import ${package}.model.User;
import ${package}.service.GreetingService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A sample controller.
 *
 * @author Nazar Annagurban
 */
@ManagedBean
@ViewScoped
public class SampleFormBean implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(SampleFormBean.class);
    @Inject
    private User user;
    @Inject
    private GreetingService greetingService;
    private String greeting;

    public SampleFormBean() {
        logger.debug("Constructing SampleFormBean.");
    }

    @PostConstruct
    public void init() {
        logger.debug("Initializing SimpleFormBean.");
    }

    public void submit() {
        logger.debug("Calling greetingService with name: {}", user.getName());
        greeting = greetingService.greet(user.getName());
    }

    public String getGreeting() {
        return greeting;
    }

    public User getUser() {
        return user;
    }
}
