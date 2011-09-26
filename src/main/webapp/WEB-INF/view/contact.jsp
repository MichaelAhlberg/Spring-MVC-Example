<?xml version='1.0' encoding='utf-8'?>
<jsp:root version="2.0" xmlns="http://www.w3c.org/1999/xhtml"
    xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:form="http://www.springframework.org/tags/form"
    xmlns:spring="http://www.springframework.org/tags">

<jsp:directive.page contentType="text/html" pageEncoding="utf-8" />
<jsp:output omit-xml-declaration="true" />
<jsp:output doctype-root-element="html" doctype-system="about:legacy-compat" />

<html>
<head> 
    <meta charset="utf-8" />

    <title>Spring MVC example</title> 
</head>

<body>

<div>
    <c:out value="${ msg }" />
</div>

<div>
    <form:form commandName="contact" method="POST">
        First name: <form:input path="firstName" /><br/>
        Last name: <form:input path="lastName" /><br/>
        <input type="submit" value="Save Changes" />
    </form:form>
</div>

</body>
</html>
</jsp:root>