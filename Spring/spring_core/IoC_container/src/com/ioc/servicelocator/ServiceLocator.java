package com.ioc.servicelocator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private InitialContext initialContext;
    private Map cache;
    private static ServiceLocator serviceLocator;
    static{
        serviceLocator = new ServiceLocator();
    }

    public static ServiceLocator getInstance(){
        return serviceLocator;
    }

    private ServiceLocator(){
        cache = Collections.synchronizedMap(new HashMap<>());
    }

    public InitialContext getInitialContext() throws NamingException {
        try{
            if(initialContext == null){
                initialContext = new InitialContext();
            }
        }catch (Exception e){
            throw e;
        }

        return initialContext;
    }

    public String getLocalHome(String jndiHomeName){
        String home = "";

        try {
            if(cache.containsKey(jndiHomeName)){
                home = (String)cache.get(jndiHomeName);
            }else{
                home = (String)getInitialContext().lookup(jndiHomeName);
                cache.put(jndiHomeName, home);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        return home;
    }

    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocator.getInstance();
        String home = locator.getLocalHome("jndi");//찾을 수 없어서 RuntimeException으로
        //" Need to specify class name in environment or system property, or in an application resource file: java.naming.factory.initial" 발생

    }
}
