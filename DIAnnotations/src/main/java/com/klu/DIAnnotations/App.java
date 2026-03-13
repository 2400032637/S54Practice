package com.klu.DIAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext appContext;

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        appContext = new ClassPathXmlApplicationContext("beans.xml");
        DepartmentConstructor deptCons = (DepartmentConstructor)appContext.getBean(DepartmentConstructor.class);
        deptCons.show();
    }
}
