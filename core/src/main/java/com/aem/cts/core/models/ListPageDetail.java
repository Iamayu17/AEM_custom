package com.aem.cts.core.models;

import org.apache.commons.lang3.StringUtils;

public class ListPageDetail {
		private String title;
		private String path;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			if (!StringUtils.isEmpty(path) && (path.startsWith("/content/") && !path.endsWith(".html"))) {

	    		path = path + ".html";

	    	}
	    	 
			this.path = path;
		}
		
}
