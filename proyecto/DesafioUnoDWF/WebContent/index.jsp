
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <jsp:include page="/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h2>Prueba de la tabla Empresas</h2>
            </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="glyphicon glyphicon-book huge"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${requestScope.totallib}</div>
                                        <div><h4>Libros</h4></div>
                                    </div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/empresas.do?op=listar">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver Empresa</span>
                                    <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>              
                </div>
        </div>
                
    </body>
</html>
