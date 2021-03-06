package pl.jurasz.dev.projectmanager.integration.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

trait BaseHttpMethods {

    @Autowired TestRestTemplate restTemplate

    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, Class<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }
    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, ParameterizedTypeReference<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }

    def <T> ResponseEntity<T> get(String uri, Class<T> responseBodyType) {
        return sendRequest(uri, HttpMethod.GET, null, responseBodyType)
    }
    def <T> ResponseEntity<T> get(String uri, ParameterizedTypeReference<T> responseBodyType) {
        return sendRequest(uri, HttpMethod.GET, null, responseBodyType)
    }

    def <T> ResponseEntity<T> post(String uri, Object requestBody){
        return sendRequest(uri, HttpMethod.POST, requestBody, Object)
    }

    def put(String uri, Object requestBody){
        return sendRequest(uri, HttpMethod.PUT, requestBody, Object)
    }

    ResponseEntity patch(String uri){
        return sendRequest(uri, HttpMethod.PUT, null, Object)
    }

    ResponseEntity patch(String uri, Object requestBody){
        return sendRequest(uri, HttpMethod.PUT, requestBody, Object)
    }

    def <T> HttpEntity<T> preparePayload(T data, Map<String, List<String>> additionalHeaders = [:]){
        def headers = new HttpHeaders()
        headers.putAll(headers)
        return new HttpEntity<T>(data, headers)
    }


}