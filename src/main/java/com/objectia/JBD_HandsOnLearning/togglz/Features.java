package com.objectia.JBD_HandsOnLearning.togglz;

import jdk.jfr.Label;
import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.context.FeatureContext;

public enum Features implements Feature {
    @Label("CreateCard")
    @EnabledByDefault
    CREATE_CARD,

    @EnabledByDefault
    @Label("CreateAccount")
    CREATE_ACCOUNT;



    public boolean isActive(){
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
