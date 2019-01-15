package org.chobit.wp;

/**
 * @author robin
 */
public class Config {

    static {
        PropKit.load("/config.properties");
    }


    public static final String XML_RPC_URL = PropKit.getProp("website", System.getProperty("website"));


    public static final String USERNAME = PropKit.getProp("username", System.getProperty("username"));


    public static final String PASSWORD = PropKit.getProp("password", System.getProperty("password"));


}
