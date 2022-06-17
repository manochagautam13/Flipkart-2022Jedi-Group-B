package com.flipkart;

import com.flipkart.rest.AdminRestAPI;
import com.flipkart.rest.ProfessorRestAPI;
import com.flipkart.rest.StudentRestAPI;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends io.dropwizard.Application<ApplicationConfiguration>
{
    public static void main( String[] args ) throws Exception {
        new App().run();
        System.out.println("Hello World!");
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> b) {
    }

    @Override
    public String getName() {
        return "hello-world";
    }


    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) {
        final StudentRestAPI studentRestAPI=new StudentRestAPI() ;
        environment.jersey().register(studentRestAPI);
        final ProfessorRestAPI professorRestAPI = new ProfessorRestAPI();
        environment.jersey().register(professorRestAPI);
        final AdminRestAPI adminRestAPI = new AdminRestAPI();
        environment.jersey().register(adminRestAPI);
    }
}
