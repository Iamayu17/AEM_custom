package com.aem.cts.core.models;

import java.util.List;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = {
        Resource.class }, resourceType = Nestedduplicate.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", selector = "model")

public interface Nestedduplicate {

    final static String RESOURCE_TYPE = "aem_cts_training/components/nestedjson";

    @Inject
    List<Countrylocation> getCountrylocation();



  @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
   interface Countrylocation {

        @Inject
        String getCountryid();

        @Inject
        String getCountryname();

        @Inject
        String getCountrylanguage();

        @Inject
        List<Linkes> getLinks();

    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    interface Linkes {


     @Inject
     String getPathlink();

        @Inject
        String getPathtext();

    }
      
}

//For JSON path - http://localhost:4502/content/aem_cts_training/us/en/drop-text2/jcr:content/root/container/nestedjson.model.tidy.json