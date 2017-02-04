package org.helianto.root

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.oauth2.client.OAuth2RestOperations
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

@Controller
@RequestMapping(Array("/home"))
class HomeController {

  @GetMapping(value = Array("favicon.ico"))
  def favicon():String  = "forward:/images/favicon.png"

  @Value("${helianto.title}") val title = ""

  @Value("${helianto.base-name}") val baseName = ""

  @Value("${helianto.base-logo}") val baseLogo = ""

  @ModelAttribute("baseName") def getBaseName = baseName

  @ModelAttribute("baseLogo") def getBaseLogo = baseLogo

  @ModelAttribute("title") def getTitle = title

  @GetMapping def index = "frame-angular-material"

}
