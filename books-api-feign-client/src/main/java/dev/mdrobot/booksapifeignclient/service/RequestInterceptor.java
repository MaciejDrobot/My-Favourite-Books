//package dev.mdrobot.booksapifeignclient.service;
//
//import feign.RequestTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RequestInterceptor implements feign.RequestInterceptor {
//
//        @Value("${books.api.key}")
//        private String apiKey;
//
//        private static final String AUTHORIZATION = "Authorization";
//
//        @Override
//        public void apply(RequestTemplate requestTemplate) {
//            requestTemplate.header(AUTHORIZATION, apiKey);
//        }
//}
