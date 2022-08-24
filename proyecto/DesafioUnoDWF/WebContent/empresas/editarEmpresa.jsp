<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Nueva Empresa</title>
<%@ include file='/cabecera.jsp'%>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<div class="container">
		<div class="row">
			<h3>Registro de Nueva Empresa</h3>
		</div>
		<div class="row">
			<div class="col-md-7">
				<c:if test="${not empty listaErrores}">
					<div class="alert alert-danger">
						<ul>
							<c:forEach var="errores" items="${requestScope.listaErrores}">
								<li>${errores}</li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<form role="form"
					action="${pageContext.request.contextPath}/empresas.do"
					method="POST">
					<input type="hidden" name="op" value="modificar">
					<div class="well well-sm">
						<strong><span class="glyphicon glyphiconasterisk"></span>Campos
							requeridos</strong>
					</div>
					<div class="form-group"></div>

					<label for="codigo">Codigo de la Empresa:</label>
					<div class="input-group">
						<input type="text" readonly class="form-control" name="codigo"
							id="codigo" value="${empresa.idEmpresa}"
							placeholder="Ingresa el codigo de la empresa"> <span
							class="input-group-addon"><span
							class="glyphicon glyphiconasterisk"></span></span>
					</div>

					<div class="form-group">
						<label for="nombre">Nombre de la Empresa:</label>
						<div class="input-group">
							<input type="text" class="form-control" name="nombre" id="nombre"
								value="${empresa.nombreEmpresa}"
								placeholder="Ingresa el nombre de la empresa"> <span
								class="input-group-addon"><span
								class="glyphicon glyphiconasterisk"></span></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="nombre">Direccion de la Empresa:</label>
						<div class="input-group">
							<input type="text" class="form-control" name="direccion" id="direccion"
								value="${empresa.direccionEmpresa}"
								placeholder="Ingresa la direccion de la empresa"> <span
								class="input-group-addon"><span
								class="glyphicon glyphiconasterisk"></span></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="nombre">Contacto de la Empresa:</label>
						<div class="input-group">
							<input type="text" class="form-control" name="contacto" id="contacto"
								value="${empresa.contactoEmpresa}"
								placeholder="Ingresa el nombre del contacto de la empresa"> <span
								class="input-group-addon"><span
								class="glyphicon glyphiconasterisk"></span></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="nombre">Télefono de la Empresa:</label>
						<div class="input-group">
							<input type="text" class="form-control" name="telefono" id="telefono"
								value="${empresa.telefonoEmpresa}"
								placeholder="Ingresa el telefono de la empresa"> <span
								class="input-group-addon"><span
								class="glyphicon glyphiconasterisk"></span></span>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>