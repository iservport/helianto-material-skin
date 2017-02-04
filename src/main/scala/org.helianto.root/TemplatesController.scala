package org.helianto.root

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping}

@Controller
@RequestMapping(Array("/templates"))
class TemplatesController {

  @GetMapping(Array("/{view}")) def get(@PathVariable view:String) = view

}
