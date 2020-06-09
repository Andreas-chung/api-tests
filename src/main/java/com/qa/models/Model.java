package com.qa.models;

import org.apache.commons.beanutils.PropertyUtils;

import static java.lang.String.format;

abstract class Model {

    public Object getProperty(String property) {
        try {
            return PropertyUtils.getProperty(this, property);
        } catch (Exception e) {
            throw new RuntimeException(format("Unable to get property:", property, e));
        }
    }

}
