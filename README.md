# helianto-material-skin

Helianto Skin for Material Design and Freemarker templates.

## How to use this skin

This module is a component to be used with the helianto-spring project.
It provides defaults to template rendering with freemarker, a popular
Java templating tool. Just add the projet dependencies and override 
template components as desired.

  * frame-bootstrap.ftl - the main view template
  * frame-head.ftl - include the html head section with css or js references
  * frame-js.html - include at the end of the html body section, with js libraries
  * frame-top.html - include a fixed bar at the top
  * _menu.html - the aplication menu

The server must also supply a baseName argument with a String. A ${baseName}.html
file must be placed under the src/resources/templates to render the main content.

