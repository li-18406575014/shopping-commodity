package com.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Commodity;
import com.api.es.CommodityDao;

@RestController
@RequestMapping("CommodityController")
public class CommodityController {

	@Autowired
	private CommodityDao commodityDao;

	@RequestMapping("getCommodity")
	public List<Commodity> getCommodity(String productName,HttpServletRequest request,HttpServletResponse response) {
		// 允许所有的域都可以跨域访问
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 允许跨域GET和POST请求
		response.addHeader("Access-Control-Allow-Method", "*");
		// 需要添加普通跨域请求的两行代码，然后再添加下面的代码。
		// 解决JSON格式的ajax请求，先是 Options请求，这是预检命令，如果预检命令检查通过之后才进行真正的请求。
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		// 缓存预检命令，在规定的时间内不需要重复的进行预检操作。
		response.addHeader("Access-Control-Max-Age", "3600");// 单位为秒。
		if ("".equals(productName)||productName==null) {
			NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
			queryBuilder.withQuery(QueryBuilders.matchAllQuery());
			Page<Commodity> page = commodityDao.search(queryBuilder.build());
			List<Commodity> list = page.getContent();
			return list;
		}else {
			NativeSearchQueryBuilder nqb = new NativeSearchQueryBuilder();
			nqb.withQuery(QueryBuilders.matchQuery("name", productName));
			Page<Commodity> pages = commodityDao.search(nqb.build());
			List<Commodity> list = pages.getContent();
			for (Commodity Commodity : list) {
				System.out.println(Commodity.getId() + "----" + Commodity.getImgname() + "----" + Commodity.getName()
						+ "----" + Commodity.getPrice());
			}
			return list;
		}
		
	}
}
