package com.aem.cts.core.models;

import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = {
        Resource.class }, resourceType = Nested.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", selector = "upskill")

public interface Nested {

    final static String RESOURCE_TYPE = "aem_cts_training/components/nested";

    @Inject
    List<Heading> getHeading();

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    interface Heading {

        @Inject
        String getName();

        @Inject
        String getNameee();

        @Inject
        List<Nestedd> getNested();
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    interface Nestedd {

        @Inject
        String getLinktxt();

        @Inject
        String getPath();

       // @Inject
        //String getNewwindow();
    }
}
