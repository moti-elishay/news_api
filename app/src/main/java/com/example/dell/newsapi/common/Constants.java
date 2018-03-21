package com.example.dell.newsapi.common;

/**
 * Created by eshcerbinock on 3/21/18.
 */

public class Constants {

    /**
     * Private constructor because we don't need to create instance of this class
     */
    private Constants() {
    }

    public static class Api {
        public static final String KEY = "883063e20fa54d88a1654263b9d08aad";
        public static final String BASE_URL = "https://newsapi.org/";

        public static class Endpoint {
            public static class Sources {
                public static final String FETCH_SOURCES = "v2/sources";

                public static class Query {
                    public static final String API_KEY = "apiKey";
                }
            }
        }
    }

    public static class Model {
        public static class Response {
            public static final String STATUS = "status";
            public static final String SOURCES = "sources";
        }

        public static class Source {
            public static final String NAME = "name";
            public static final String URL = "url";
        }
    }

}
