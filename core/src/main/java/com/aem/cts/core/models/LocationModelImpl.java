package com.aem.cts.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, adapters = LocationModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class LocationModelImpl implements LocationModel {
   
    @ChildResource
    private List< Resource > configurectalistItems;

    public List<Resource> getCountrylocation() {
        return configurectalistItems;
    }

    @ValueMapValue
    private String countryId;

    @ValueMapValue
    private String countryName;

    @ValueMapValue
    private String countryDetail;

    @ValueMapValue
    private String countryLanguage;

    @ValueMapValue
    private String countrySymbol;

    @ValueMapValue
    private String countryLink;

    @Override
    public String getCountryId() {
        return countryId;
    }

    @Override
    public String getCountryName() {
         return countryName;
    }

    @Override
    public String getCountryDetail() {
        return countryDetail;
    }

    @Override
    public String getCountryLanguage() {
        return countryLanguage;
    }

    @Override
    public String getCountrySymbol() {
        return countrySymbol;
    }

    @Override
    public String getCountryLink() {
        return countryLink;
    }


}