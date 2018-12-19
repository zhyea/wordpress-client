package org.chobit.wp;


import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件操作类
 *
 * @author robin
 */
public abstract class PropKit {

    private static final Map M = new Hashtable();

    /**
     * 加载配置文件
     *
     * @param propertyFileName 配置文件名称，通常使用“/name.properties”这样的值
     * @return 配置信息
     */
    public static Properties load(String propertyFileName) {
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = PropKit.class.getResourceAsStream(propertyFileName);
            if (in != null) {
                p.load(in);
                M.putAll(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return p;
    }

    public static String getProp(String key, String defaultValue) {
        Object oval = M.get(key);
        String sval = (oval instanceof String) ? (String) oval : null;
        return (sval == null) ? defaultValue : sval;
    }

    public static String getProp(String key) {
        return getProp(key, null);
    }

    public static Object setProp(String key, String value) {
        return M.put(key, value);
    }

    public static Integer getInt(String key, Integer defaultValue) {
        String value = getProp(key);
        return (value != null) ? Integer.parseInt(value) : defaultValue;
    }

    public static Integer getInt(String key) {
        return getInt(key, 0);
    }

    public static Double getDouble(String key, Double defaultValue) {
        String value = getProp(key);
        return (value != null) ? Double.parseDouble(value) : defaultValue;
    }

    public static Double getDouble(String key) {
        return getDouble(key, 0.0);
    }

    public static Boolean getBoolean(String key, Boolean defaultValue) {
        String value = getProp(key);
        return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
    }

    public static Boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    private PropKit() {
        throw new UnsupportedOperationException("private constructor, cannot be called.");
    }
}

