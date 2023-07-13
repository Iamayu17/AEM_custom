package com.aem.cts.core.models;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;


@Model(adaptables =  {SlingHttpServletRequest.class, Resource.class}, resourceType = { PageNavigation.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageNavigation {

	
	private static final Logger LOG = LoggerFactory.getLogger(PageNavigation.class);

	public static final String RESOURCE_TYPE = "aem_cts_training/components/pagenavigation";
	
	@ValueMapValue
	private String navigationRoot;
	
	@ValueMapValue
	private int structureDepth;
	
	@SlingObject
	private ResourceResolver resourceResolver;

	private ArrayList<ListPageDetail> resultArray = new ArrayList<ListPageDetail>();

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
