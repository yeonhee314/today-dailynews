package com.yeonhee.dailynews.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.yeonhee.dailynews.vo.JtbcRss;

@Service("rssService")
public class RssService {
	public JtbcRss getJtbcRss(String urlAddress) {
		JtbcRss rss = null;
		XmlMapper mapper = new XmlMapper();
		try {
			rss = mapper.readValue(urlAddress, JtbcRss.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
}
