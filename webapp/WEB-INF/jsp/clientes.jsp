<%@page import="br.com.projeto.restaurante.service.Services"%>
<%@page import="br.com.projeto.restaurante.service.ServicesFactory"%>
<%@page import="br.com.projeto.restaurante.dto.ClienteDTO"%>
<%@page import="java.util.List"%>


<%Services<ClienteDTO> service = (Services<ClienteDTO>)ServicesFactory.getService("CLIENTE");%>
<%List<ClienteDTO> clientes = service.todos();%>


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
				<h1>PAGINA ONLINE</h1>
			</div>
			
			<!-- Button novo cliente -->
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Novo Cliente</button>
	
		</div>
		<div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nome</th>
			      <th scope="col">email</th>
			      <th scope="col">nova comanda</th>
			    </tr>
			  </thead>
			  <tbody>
			<%for(ClienteDTO c: clientes){ %>
				<tr>
			      <th scope="row"><%=c.getId()%></th>
			      <td><%=c.getNome()%></td>
			      <td><%=c.getEmail()%></td>
			      <td>
			      	<button type="button" class="btn btn-info btn-lg"><a href="/comandas?idCliente=<%=c.getId()%>">Ver comandas</a></button>
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
	        	<form>
	       			  <div class="form-group">
					    <label for="exampleInputPassword1">Nome</label>
					    <input type="name" class="form-control" id="nome-cliente" placeholder="Nome">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email-cliente" class="form-control" id="email-cliente" aria-describedby="emailHelp" placeholder="Email">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputCEP">CEP</label>
					    <input type="text" class="form-control" id="cep-cliente" aria-describedby="cepHelp" placeholder="Cep" onblur="getCep()">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputAddress">Endereço</label>
					    <input type="text" class="form-control" id="address-cliente" aria-describedby="addressHelp" placeholder="Endereço">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputAddress">Estado</label>
					    <input type="text" class="form-control" id="state-cliente" aria-describedby="stateHelp" placeholder="Estado">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputAddress">Distrito</label>
					    <input type="text" class="form-control" id="district-cliente" aria-describedby="districtHelp" placeholder="Distrito">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputAddress">Cidade</label>
					    <input type="text" class="form-control" id="city-cliente" aria-describedby="cityHelp" placeholder="Cidade">
					  </div>				
				
					  <button type="submit" class="btn btn-primary" onclick="postCliente();">Salvar</button>
				</form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	        </div>
	      </div>
	    </div>
	  </div>
			
	</body>
</html>