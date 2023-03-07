<%@page import="br.com.projeto.restaurante.service.Services"%>
<%@page import="br.com.projeto.restaurante.service.ServicesFactory"%>
<%@page import="br.com.projeto.restaurante.dto.ClienteDTO"%>
<%@page import="br.com.projeto.restaurante.dto.ComandaDTO"%>
<%@page import="br.com.projeto.restaurante.dto.ProdutoDTO"%>
<%@page import="br.com.projeto.restaurante.dto.ProdutoComanda"%>
<%@page import="java.util.List"%>


<%Services<ClienteDTO> serviceCli = (Services<ClienteDTO>)ServicesFactory.getService("CLIENTE");%>
<%Services<ComandaDTO> serviceCo = (Services<ComandaDTO>)ServicesFactory.getService("COMANDA");%>
<%Integer idComanda = Integer.valueOf((String)request.getParameter("idComanda"));%>
<%ComandaDTO comanda = serviceCo.findById(idComanda);%>

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
				<h1>Comanda</h1>
				<input id="idComanda" type="hidden" value="<%=comanda.getId()%>" />
			</div>
			<div class="body">
	       
       			  <div class="form-group">
				    <label for="exampleInputName">Nome</label>
				    <input type="name" class="form-control" id="nome-produto" placeholder="Nome">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputName">Id Produto</label>
				    <input type="" class="form-control" id="id-produto" placeholder="Id produto">
				  </div>
			
				  <button class="btn btn-primary" onclick="buscarProduto();">Buscar Produto</button>
				  <button class="btn btn-primary" onclick="limparTabela();">Limpar Produtos</button>
				  <div>
				    <label for="exampleInputName">Quantidade</label>
				    <input type="number" class="form-control" id="qtd-produto" placeholder="Quantidade">
				  </div>
	        </div>
	        
	    <div>
		<h1>Itens Comanda</h1>
		<table class="table" id="tabela-produto">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nome</th>
			      <th scope="col">preço</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody> 

			  </tbody>
		</table>
			
			<!-- Button novo cliente -->
			
			
		</div>
		<div>
			<h1>Itens Comanda</h1>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">nome</th>
			      <th scope="col">quantidade</th>
			      <th scope="col">preço</th>
			      <th scope="col">valor</th>
			      <th scope="col">editar comanda</th>
			    </tr>
			  </thead>
			  <tbody> 
					<%for(ProdutoComanda p: comanda.getProdutos()){ %>
						<tr>
					      <th scope="row"><%=p.getProduto().getNome()%></th>
					      <td><%=p.getQuantidade()%></td>
					      <td><%=p.getProduto().getPreco()%></td>
					      <td><%=p.getProduto().getPreco()*p.getQuantidade()%></td>
					      <td>
					      	<button type="button" class="btn btn-info btn-lg" onclick="deleteProdutoComanda(<%=p.getId()%>)">Deletar Produto</button>
					      </td>
					    </tr>
					<%}%>
			  </tbody>
			</table>
		</div>		
	</body>
</html>