<body><h1>OAuth Approval</h1>
<p>Do you authorize 'iservport-trusted-client' to access your protected resources?</p>
<form id="confirmationForm" name="confirmationForm" action="/oauth/authorize" method="post"><input
        name="user_oauth_approval" value="true" type="hidden">
    <input type="hidden" name="_csrf" value="'${_csrf.token}'">
    <label>
        <input name="authorize" value="Authorize" type="submit">
    </label>
</form>
<form id="denialForm" name="denialForm" action="/oauth/authorize" method="post">
    <input name="user_oauth_approval" value="false" type="hidden">
    <input type="hidden" name="_csrf" value="'${_csrf.token}'">
    <label>
        <input name="deny" value="Deny" type="submit">
    </label>
</form>
<div id="window-resizer-tooltip"><a href="#" title="Edit settings"></a><span
        class="tooltipTitle">Window size: </span><span class="tooltipWidth" id="winWidth"></span> x <span
        class="tooltipHeight" id="winHeight"></span><br><span class="tooltipTitle">Viewport size: </span><span
        class="tooltipWidth" id="vpWidth"></span> x <span class="tooltipHeight" id="vpHeight"></span>
</div>
</body>