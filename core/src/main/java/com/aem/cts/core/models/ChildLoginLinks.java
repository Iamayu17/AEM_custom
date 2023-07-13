package com.aem.cts.core.models;


import javax.inject.Inject;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChildLoginLinks{ 
	
	
	@ValueMapValue(name = "childlinktext")
    private String childlinktext;
	
	@ValueMapValue(name = "childlinkurl")
    private String childlinkurl;

	public String getChildlinktext() {
		return childlinktext;
	}

	public String getChildlinkurl() {
		return childlinkurl;
	}
	
}

