<%@page import="br.com.projeto.restaurante.service.Services"%>
<%@page import="br.com.projeto.restaurante.service.ServicesFactory"%>
<%@page import="br.com.projeto.restaurante.dto.ClienteDTO"%>
<%@page import="br.com.projeto.restaurante.dto.ComandaDTO"%>
<%@page import="java.util.List"%>


<%Services<ClienteDTO> serviceCli = (Services<ClienteDTO>)ServicesFactory.getService("CLIENTE");%>
<%Services<ComandaDTO> serviceCo = (Services<ComandaDTO>)ServicesFactory.getService("COMANDA");%>
<%Integer idCliente = Integer.valueOf((String)request.getParameter("idCliente"));%>
<%ClienteDTO clientes = serviceCli.findById(idCliente);%>
<%List<ComandaDTO> comandas = serviceCo.findByEntityValues(new ComandaDTO(null, idCliente, null, null, null));%>

<html lang="pt-br">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="/js/actions.js"></script>
</head>
	<body>
		<div class="container">
	
			<div class="starter-template">
				<h1><%=clientes.getNome()%></h1>
			</div>
			
			<!-- Button novo cliente -->
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Nova Comanda</button>
	
		</div>
		<div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">Status</th>
			      <th scope="col">valor</th>
			      <th scope="col">editar comanda</th>
			    </tr>
			  </thead>
			  <tbody> 
				<%for(ComandaDTO c: comandas){ %>
					<tr>
				      <th scope="row"><%=c.getId()%></th>
				      <td><%=c.getStatus()%></td>
				      <td><%=c.getValorTotal()%></td>
				      <td>
				      	<button type="button" class="btn btn-info btn-lg"><a href="/comanda?idComanda=<%=c.getId()%>">Ver comanda</a></button>
				      </td>
				    </tr>
				<%}%>
			  </tbody>
			</table>
		</div>
		
		
		
	  <!-- Modal Cliente -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Modal Header</h4>
	        </div>
	        <div class="modal-body">

	       			  <div class="form-group">
					    <h2>Deseja criar uma nova comanda?</h2>
					  </div>
				
					  <button class="btn btn-primary" onclick="novaComanda(<%=idCliente%>);">Sim</button>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</body>
	
</html>