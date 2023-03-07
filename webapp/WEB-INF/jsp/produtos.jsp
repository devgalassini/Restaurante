<%@page import="br.com.projeto.restaurante.dto.ProdutoDTO"%>
<%@page import="br.com.projeto.restaurante.service.Services"%>
<%@page import="br.com.projeto.restaurante.service.ServicesFactory"%>
<%@page import="br.com.projeto.restaurante.dto.ClienteDTO"%>
<%@page import="java.util.List"%>


<%Services<ProdutoDTO> service = (Services<ProdutoDTO>)ServicesFactory.getService("PRODUTO");%>
<%List<ProdutoDTO> produtos = service.todos();%>


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
			
			<!-- Button novo produto -->
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Novo Produto</button>
	
		</div>
		<div>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nome</th>
			      <th scope="col">preço</th>
			    </tr>
			  </thead>
			  <tbody>
				<%for(ProdutoDTO  p : produtos){ %>
					<tr>
				      <th scope="row"><%=p.getId()%></th>
				      <td><%=p.getNome()%></td>
				      <td><%=p.getPreco()%></td>
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
					    <label >Nome</label>
					    <input type="name" class="form-control" id="nome-produto" placeholder="Nome">
					  </div>
					  <div class="form-group">
					    <label >Preço</label>
					    <input type="number"  step="0,01" class="form-control" id="preco-produto" placeholder="Preço">
					  </div>
				
					  <button type="submit" class="btn btn-primary" onclick="postProduto();">Salvar</button>
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