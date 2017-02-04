package org.helianto.root

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.oauth2.client.OAuth2RestOperations
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/app"))
class AppController(restTemplate: OAuth2RestOperations) {

  @Value("${helianto.api.url}") val apiUrl = ""

  @GetMapping(Array("/me"))
  def me = restTemplate.getForObject(s"$apiUrl/api/me", classOf[String])

  @GetMapping(Array("/entity"))
  def entity = restTemplate.getForObject(s"$apiUrl/api/entity", classOf[String])

  @GetMapping(Array("/identity/{id}"))
  def identity(@PathVariable id: String) = restTemplate.getForObject(s"$apiUrl/identity/?id=$id", classOf[String])

}
