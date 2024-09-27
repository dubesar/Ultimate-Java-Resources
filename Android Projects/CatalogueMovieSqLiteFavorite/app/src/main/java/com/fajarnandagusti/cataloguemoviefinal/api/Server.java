package com.fajarnandagusti.cataloguemoviefinal.api;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.BASE_URL_API;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class Server {
    public static ApiService getAPIService(){
        return Client.getClient(BASE_URL_API).create(ApiService.class);
    }
}
