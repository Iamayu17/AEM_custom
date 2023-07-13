
package com.aem.cts.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

//import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageLinksDetails{ 
	
	
	@ValueMapValue(name = "pagename")
    private String pagename;
	
	@ValueMapValue(name = "pageurl")
    private String pageurl;
	
	public String getPagename() {
		return pagename;
	}

	public String getPageurl() {
		return pageurl;
	}

	 @Inject
	 @Named("childlink/.")
	 private Resource childLoginLinksResource;
	 
	 private List<ChildLoginLinks> childLoginLinks = new ArrayList<>();
	 
	 @PostConstruct
	    protected void init() {

			//Resource resource = resourceResolver.getResource(RESOURCE_TYPE);
			
			if (childLoginLinksResource != null) {
	            Iterator<Resource> resourceItr = childLoginLinksResource.listChildren();
	            while (resourceItr.hasNext()) {
	            	ChildLoginLinks childLoginLinkvalues = resourceItr.next().adaptTo(ChildLoginLinks.class);
	            	childLoginLinks.add(childLoginLinkvalues);
	            }
	        }
	    }

	 public List<ChildLoginLinks> getChildLoginLinks() {
	     return new ArrayList<ChildLoginLinks>(childLoginLinks);
	 }

}

