package com.aem.cts.core.models;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.wcm.core.components.models.Navigation;
import com.day.cq.wcm.api.Page;

/**
 * Navigation model implementation.
 */
@Model(adaptables =  {SlingHttpServletRequest.class, Resource.class}, resourceType = { SampleCustomNavigation.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SampleCustomNavigation implements Navigation{

	
	private static final Logger LOG = LoggerFactory.getLogger(SampleCustomNavigation.class);
	/**
	 * The resource navigation component resource type.
	 */
	public static final String RESOURCE_TYPE = "aem_cts_training/components/customnavigation";
	
	@ValueMapValue
	private String navigationRoot;
	
	@ValueMapValue
	private int structureDepth;
	
	
	@ChildResource
	private Resource levelonepages;
	
	@SlingObject
	private ResourceResolver resourceResolver;
	
	private List<PageLinksDetails> pages = new ArrayList<>();
	
	private ArrayList<ListPageDetail> resultArray = new ArrayList<ListPageDetail>();
	
	private List<List<ListPageDetail>> secondlevel = new ArrayList<>();
	@PostConstruct
    protected void init() {
		LOG.info("Navigation root {}",navigationRoot);	
		
		if (levelonepages!= null) {
            Iterator<Resource> resourceItr =levelonepages.listChildren();
            while (resourceItr.hasNext()) {
            	PageLinksDetails pagevalues = resourceItr.next().adaptTo(PageLinksDetails.class);
            	pages.add(pagevalues);
            }
        }	
		
    }

	public List<PageLinksDetails> getPageLinksDetails() {	
    	return new ArrayList<PageLinksDetails>(pages);
    }
	public List<ListPageDetail> getResultArray() {
		
		Resource resource= resourceResolver.getResource(navigationRoot);
		LOG.info("Resource {}",resource);
		if(resource!=null)
		{
			Page parentPage = resource.adaptTo(Page.class);
			if(parentPage!=null)
			{
				Iterator<Page> listChildPages = parentPage.listChildren();
				while (listChildPages.hasNext() && structureDepth!=0) {
					Page childPage = listChildPages.next();
					LOG.info("ChildPages {}",childPage.getName());
					ListPageDetail detail = new ListPageDetail();
					detail.setTitle(childPage.getPageTitle());
					detail.setPath(childPage.getPath());
					resultArray.add(detail);
					structureDepth--;
				}
			}
		}
		return resultArray;
	}
}
