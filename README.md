# helianto-material-skin

Helianto Skin for Material Design and Freemarker templates.

## How to use this skin

This module is a component to be used with the helianto-spring project.
It provides defaults to template rendering with freemarker, a popular
Java templating tool. Just add the projet dependencies and override 
template components as desired.

  * frame-angular-material.ftl - the main view template
  * frame-head.html - include the html head section with css or js references
  * frame-js.html - include at the end of the html body section, with js libraries
  * frame-top.html - include a fixed bar at the top
  * frame-sidebar.html - the application sidebar

The server must also supply a baseName argument as a String. A ${baseName}.html
file must be placed under the src/resources/templates to render the main content.

## Resolvers

Please, add the following resolvers to your sbt (or maven) build.

```
  resolvers  ++= Seq(
    "Helianto Releases"  at "s3://maven.helianto.org/release",
    "Helianto Snapshots" at "s3://maven.helianto.org/snapshot"
  )
```