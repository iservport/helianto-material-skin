[#ftl]
<html >
<head>
    <title>${titlePage!'Approval'}</title>
    [#include "/frame-head.html" /]
    <style>${inLineCss!''}</style>
    [#if captchaKey?? ][/#if]
</head>

<body class="heliantoLogin" >

    [#include "lang.ftl" /]

    <div id="main" class="container">
        <!--
         ! Logo
         !-->
        <br/>
        <div class="clearfix text-center">
            <a href="#" class="text-center" target="_self"><img src="${baseLogo!'/images/logo.png'}" alt="iservport" ></a>
        </div>
        <div class="row">
            <div class="col-md-offset-3 col-md-6" >
                <h1>${error_title!''}</h1>
            </div>
        </div>
    </div>

</body>
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
