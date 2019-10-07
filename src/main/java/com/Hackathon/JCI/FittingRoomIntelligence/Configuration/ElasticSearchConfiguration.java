package com.Hackathon.JCI.FittingRoomIntelligence.Configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration extends AbstractFactoryBean {

	public RestHighLevelClient restHighLevelClient;

	@Override
	public Class<RestHighLevelClient> getObjectType() {

		return RestHighLevelClient.class;
	}

	@Override
    public void destroy() {
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        } catch (final Exception e) {
           e.printStackTrace();
        }
    }
	
	
	@Override
	protected RestHighLevelClient createInstance() throws Exception {

		return buildClient();
	}

	private RestHighLevelClient buildClient() {

		try {

			restHighLevelClient = new RestHighLevelClient(RestClient.builder(

					new HttpHost("http://10.47.82.251", 9200, "http")));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
