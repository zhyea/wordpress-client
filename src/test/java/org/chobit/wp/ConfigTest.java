package org.chobit.wp;

import org.junit.Test;

import static org.chobit.wp.Config.*;

/**
 * @author robin
 */
public class ConfigTest {

    @Test
    public void config() {
        System.out.println(XML_RPC_URL);
        System.out.println(USERNAME);
        System.out.println(PASSWORD);
    }

}
