package org.helianto.root

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.oauth2.client.OAuth2RestOperations
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

@Controller
@RequestMapping(Array("/"))
class RootController(restTemplate: OAuth2RestOperations) {

  @GetMapping(value = Array("favicon.ico"))
  def favicon():String  = "forward:/images/favicon.png"

  @Value("${helianto.title}") val title = ""

  @Value("${helianto.base-name}") val baseName = ""

  @Value("${helianto.api.url}") val apiUrl = ""

  @ModelAttribute("baseName") def getBaseName = baseName

  @ModelAttribute("title") def getTitle = title

  @GetMapping def index = "frame-angular-material"

  @GetMapping(Array("templates/{view}")) def get(@PathVariable view:String) = view

  @GetMapping(Array("/error")) def error = "frame-error"

  @GetMapping(Array("/app/me")) @ResponseBody def me = restTemplate.getForObject(s"$apiUrl/api/me", classOf[String])

  @GetMapping(Array("/app/entity")) @ResponseBody def entity = restTemplate.getForObject(s"$apiUrl/api/entity", classOf[String])

}
