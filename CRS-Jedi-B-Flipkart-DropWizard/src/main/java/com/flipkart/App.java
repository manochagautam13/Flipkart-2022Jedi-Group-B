package com.flipkart;

import com.flipkart.bean.User;
import com.flipkart.rest.AdminRestAPI;
import com.flipkart.rest.ProfessorRestAPI;
import com.flipkart.rest.StudentRestAPI;
import com.flipkart.rest.UserRestApi;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration>
{
    public static void main( String[] args ) throws Exception {
        new App().run(args);
        System.out.println("Hello World!");
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        System.out.println("sdbfjhbfkabf");
        final StudentRestAPI studentRestAPI=new StudentRestAPI() ;
        environment.jersey().register(studentRestAPI);
        final ProfessorRestAPI professorRestAPI = new ProfessorRestAPI();
        environment.jersey().register(professorRestAPI);
        final AdminRestAPI adminRestAPI = new AdminRestAPI();
        environment.jersey().register(adminRestAPI);
        final UserRestApi userRestApi = new UserRestApi();
        environment.jersey().register(userRestApi);
    }
}
