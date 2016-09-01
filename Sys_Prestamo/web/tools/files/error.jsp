<%-- 
    Document   : error
    Created on : 30/08/2016, 11:24:33 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
    </head>
    <body>
         <section class="content-header">
      <h1>
        Página no Autorizada
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="error-page">
          <h2 class="headline text-red"><i class="fa fa-warning"></i></h2>

        <div class="error-content">
          <h3>Oops! Página no Autorizada</h3>

          <p>Ocurrió un error de autorización, por favor 
            <a href="login?act=in">Iniciar Sesión</a> 
          </p>
        </div>
      </div>
    </section>
    </body>
</html>
