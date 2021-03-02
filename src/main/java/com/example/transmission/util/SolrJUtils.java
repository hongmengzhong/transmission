package com.example.transmission.util;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SolrJUtils {
    public static final String solrBaseUrl="http://116.196.123.143:8080/solr/yk_pro";
    // public static final String solrBaseUrl="http://47.94.110.202/solr/";
    //public static final String solrBaseUrl = "http://localhost:8080/solr";
    public static Logger logger= LoggerFactory.getLogger(SolrJUtils.class);
//    public static ProductBaseInfoDao productBaseInfoDao=SpringContextHolder.getBean(ProductBaseInfoDao.class);

    private static HttpSolrServer init(HttpSolrServer httpSolrClient)
            throws SolrServerException, IOException {
        httpSolrClient.setConnectionTimeout(100000);
        httpSolrClient.setDefaultMaxConnectionsPerHost(100);
        httpSolrClient.setMaxTotalConnections(10000);
        return httpSolrClient;
    }

    //获取solr服务
    @SuppressWarnings("deprecation")
    public static HttpSolrServer getClient() throws SolrServerException,
            IOException {
        HttpSolrServer httpSolrClient = new HttpSolrServer(solrBaseUrl);// early
        // version
        init(httpSolrClient);
        return httpSolrClient;
    }
}
