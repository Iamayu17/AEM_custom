package com.aem.cts.core.models;


import jdk.internal.loader.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Author.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)


public class AuthorImpl implements Author{

    @Inject
    String FirstName;

    @Inject
    String LastName;

    @Inject
    boolean Professor;

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getIsProfessor() {
        return null;
    }

    @Override
    public String getPageTitle() {
        return null;
    }




}
