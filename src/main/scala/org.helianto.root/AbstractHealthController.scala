package org.helianto.root

import java.util.Date

import org.springframework.web.bind.annotation.GetMapping

abstract class AbstractHealthController {

  @GetMapping
  def get = s"""{"timeStamp":"${new Date()}"}"""

}
