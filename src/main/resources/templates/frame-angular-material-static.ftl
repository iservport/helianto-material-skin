[#ftl]
<!DOCTYPE html >
<html id="ng-app" xmlns:ng="http://angularjs.org" ng-app="app" ng-cloak >
<head>

    [#include "/frame-head.html" /]

</head>
<body id="app" layout-fill class="heigth-fix">

[#include "lang.ftl" /]

<section layout-fill layout="column" layout-align="center center">

    [#include "/${pageName!baseName}.html" /]

</section>

[#include "/frame-js.html" /]
[#include "/frame-custom.html" /]

</body>

</html>
[#---
* msg
*
* credits: https://github.com/ratherblue/freemarker-example
*
* Functions to look up a string with optional parameters
*
* @param code string of message code to lookup
* @param args array of arguments included in string
* @param escapeHtml boolean to determine whether or not to escape the html
* @returns a string with the looked up message
--]
[#function msg code args=[] escapeHtml=true ]

[#local argsArray = [] /]

[#if args?is_string]
[#local argsArray = [args] /]
[#elseif args?is_sequence]
[#local argsArray = args /]
[#else]
[#return "" /]
[/#if]

[#return springMacroRequestContext.getMessage(code, argsArray, "", escapeHtml) /]

[/#function]
