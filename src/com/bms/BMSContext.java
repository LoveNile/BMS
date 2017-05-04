package com.bms;

import java.util.HashMap;
import java.util.Map;

import com.bms.po.User;

public class BMSContext {
    private static ThreadLocal<BMSContext> bmsMap = new ThreadLocal<BMSContext>();
    private Map<String, Object> objects = new HashMap<String, Object>();
    private static String contextPath;

    private BMSContext() {

    }

    public static String getContextPath() {
        return contextPath;
    }

    public static void setContextPath(String contextPath) {
        if (BMSContext.contextPath == null) {
            BMSContext.contextPath = contextPath;
        }
    }

    public static BMSContext getBMSContext() {
        BMSContext bmsContext = bmsMap.get();
        if (bmsContext == null) {
            bmsContext = new BMSContext();
            bmsMap.set(bmsContext);
        }
        return bmsContext;
    }

    public Object getObject(String key) {
        return objects.get(key);
    }

    public void clear() {
        objects.clear();
    }

    public Map<String, Object> getObjectMap() {
        return objects;
    }

    public void setObject(Map<String, Object> object) {
        if (object == null) {
            object = new HashMap<String, Object>();
        }
        this.objects = object;
    }

    public void removeObject(String string) {
        objects.remove(string);
    }

    public void addObject(String key, Object object) {
        objects.put(key, object);
    }

    public User getUser() {
        return (User)objects.get(Constants.BMS_CONTEXT_USER);
    }

    public String getUserName() {
        User user = (User) objects.get(Constants.BMS_CONTEXT_USER);
        if (user != null) {
            return user.getUsername();
        }
        return "";
    }

    public int getUserId() {
        User user = (User) objects.get(Constants.BMS_CONTEXT_USER);
        if (user != null) {
            return user.getUserid();
        }
        return 0;
    }
}

