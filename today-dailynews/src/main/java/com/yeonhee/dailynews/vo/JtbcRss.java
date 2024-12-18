package com.yeonhee.dailynews.vo;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName="jtbc")
public class JtbcRss {
	@JacksonXmlProperty(isAttribute = true)
	private String version;
	private Channel channel;
	
	@Data
	public static class Channel{
		private String title;
		private String link;
		private String description;
		private String language;
		private String copyright;
		private String category;
		private String pubDate;
		List<Item> item;
	}
	@Data
	public static class Item{
		private String title;
		private String link;
		private String description;
		private String pubDate;
	}
}
