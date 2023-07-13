package com.aem.cts.core.models;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       adapters = NestedModel.class,
       resourceType = NestedModelImpl.RESOURCE_TYPE,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

       @Exporter(name = "jackson", extensions = "json", selector = "world"
      // options={
      // @ExporterOption(name="MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value="false"),
    //     @ExporterOption(name="SerializationFeature.WRAP_ROOT_VALUE",value="false")
    //    }
       )
public class NestedModelImpl implements NestedModel {
   
   // private static Logger LOG = LoggerFactory.getLogger(NestedModelImpl.class);
     static final String RESOURCE_TYPE="aem_cts_training/components/nesteddetails";

    @ChildResource
    private List<NestedModelImpl> configurectalistItems;

    // public NestedModelImpl() {
   // }

    public List<NestedModelImpl> getCountrylocation() {
        return configurectalistItems;
    }

    @ChildResource
    private List<NestedModelImpl> links;

    public List<NestedModelImpl> getCountrylink() {
        return links;
    }

    @ValueMapValue
    private String countryId;

    @ValueMapValue
    private String countryName;

    @ValueMapValue
    private String countryLanguage;

    @ValueMapValue
    private String pathLink;

    @ValueMapValue
    private String pathtext;

    @Override
    public String getCountryId() {
        return countryId;
    }

    @Override
    public String getCountryName() {
         return countryName;
    }

    @Override
    public String getCountryLanguage() {
        return countryLanguage;
    }

    @Override
    public String getPathLink() {
        if (!StringUtils.isEmpty(pathLink) && (pathLink.startsWith("/content/") && !pathLink.endsWith(".html"))) {
            pathLink = pathLink + ".html";
         }
        return pathLink;
    }

    @Override
    public String getPathtext() {
        return pathtext;
    }


}

//use this link for JSON-->http://localhost:4502/content/aem_cts_training/us/en/drop-text2/jcr:content/root/container/nesteddetails.model.tidy.json