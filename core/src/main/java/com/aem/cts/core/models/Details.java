package com.aem.cts.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Details {
    @Inject
    @Named("details/.")
    public List<DetailsItem> details;

    public List<DetailsItem> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsItem> details) {
        this.details = details;
    }

}
