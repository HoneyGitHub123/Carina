package com.company.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/order", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/order/_post/rq.json")
@ResponseTemplatePath(path = "api/order/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostOrderMethod extends AbstractApiMethodV2 {

    public PostOrderMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));

    }
}
