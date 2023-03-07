var host = window.location.origin;

function getRequest(urlPath, dadosHeader){
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open( "GET", urlPath, false );
        if(dadosHeader){
            for(var i = 0; i < dadosHeader.length; i++){
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send( null );
    } catch (error) {
        alert("Falha tente novamente mais tarde");
        console.log("Erro :"+error);
        return ""
    }
    return xmlHttp.responseText;
};

function deleteRequest(urlPath, dadosHeader){
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open( "DELETE", urlPath, true );
        if(dadosHeader){
            for(var i = 0; i < dadosHeader.length; i++){
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send( null );
    } catch (error) {
        alert("Falha tente novamente mais tarde");
        console.log("Erro :"+error);
        return ""
    }
    return xmlHttp.responseText;
};

function postRequest(urlPath, dadosHeader, body){
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open( "POST", urlPath, false );
        if(dadosHeader){
            for(var i = 0; i < dadosHeader.length; i++){
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send(body);
    } catch (error) {
        alert("Falha tente novamente mais tarde");
        console.log("Erro :"+error);
        return ""
    }
    if(xmlHttp.status < 300){
        return xmlHttp.response;
    }
    console.log('{"Erro":"'+xmlHttp.response+'", "Status":"'+xmlHttp.status+'"}');
    return '{"Erro":"'+xmlHttp.response+'", "Status":"'+xmlHttp.status+'"}';
};

function putRequest(urlPath, dadosHeader, body){
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open( "PUT", urlPath, false );
        if(dadosHeader){
            for(var i = 0; i < dadosHeader.length; i++){
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send(body);
    } catch (error) {
        alert("Falha tente novamente mais tarde");
        console.log("Erro :"+error);
        return ""
    }
    if(xmlHttp.status < 300){
        return xmlHttp.response;
    }
    console.log('{"Erro":"'+xmlHttp.response+'", "Status":"'+xmlHttp.status+'"}');
    return '{"Erro":"'+xmlHttp.response+'", "Status":"'+xmlHttp.status+'"}';
};

function postCliente(){
	try{
		var cli = {nome: "", email: "", endereco: {cep:"", address:"",state:"",district:"",city:""} };
		cli.nome = document.getElementById("nome-cliente").value;
		cli.email = document.getElementById("email-cliente").value;
		cli.endereco.cep = document.getElementById("cep-cliente").value;
		cli.endereco.address = document.getElementById("address-cliente").value;
		cli.endereco.state = document.getElementById("state-cliente").value;
		cli.endereco.district = document.getElementById("district-cliente").value;
		cli.endereco.city = document.getElementById("city-cliente").value;
		var url = host+"/api/cliente";
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(postRequest(url, header, JSON.stringify(cli)));
		if(response.error != null){
            alert("Cliente não pode ser salvo");
        }else{
            window.location.replace(window.location.search);      	
        }
	} catch (error) {
        console.log("Falha na chamada do post " + error);
        alert(error)
    }
}

function novaComanda(cliente){
	try{
		var loc = window.location.search;
		var comanda = {idCliente: "", status: "aberta"};
		comanda.idCliente = parseInt(cliente);
		var url = host+"/api/comanda";
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(postRequest(url, header, JSON.stringify(comanda)));
		if(response.error != null){
            alert("Comanda não pode ser aberta");
        }else{
           window.location.replace(loc);    	
        }
	} catch (error) {
        console.log("Falha na chamada do post " + error);
        alert(error)
    }
}

function postProduto(){
	try{
		var produto = {nome: "", preco: ""};
		produto.nome = document.getElementById("nome-produto").value;
		produto.preco = parseFloat(document.getElementById("preco-produto").value);
		var url = host+"/api/produto";
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(postRequest(url, header, JSON.stringify(produto)));
		if(response.error != null){
            alert("Falha ao salvar produto");
        }else{
            alert("Produto salvo com sucesso");  
            window.location.replace(window.location.search);     	
        }
	} catch (error) {
        console.log("Falha na chamada do post " + error);
        alert(error)
    }
}

function buscarProduto(){
	try{
		var nome = document.getElementById("nome-produto").value;
		var id = parseInt(document.getElementById("id-produto").value);
		var url = host+"/api/produto?"
		if(!isNaN(id)){
			url = url+"id="+id+"&nome="+nome;
		}else{
			url = url+"id=&nome="+nome;;
		}
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(getRequest(url, header));
		if(response.error != null){
            alert("Falha ao buscar produtos");
        }else{
            popularTabelaProdutos(response);      	
        }
	} catch (error) {
        console.log("Falha na chamada do get " + error);
        alert(error)
    }
}

function popularTabelaProdutos(produtos){
	limparTabela();
	var tbodyRef = document.getElementById('tabela-produto').getElementsByTagName('tbody')[0];
	
	for(i=0; i < produtos.length; i++){
	
		var button = document.createElement("button");
		button.innerHTML = "Inserir";
		button.id=produtos[i].id;
		button.onclick = function () {
		  insereProdutoNaComanda(button.id, document.getElementById("idComanda").value, document.getElementById("qtd-produto").value);
		};
		var newRow = tbodyRef.insertRow();
		var cellId = newRow.insertCell();
		var cellNome = newRow.insertCell();
		var cellPreco = newRow.insertCell();
		var cellButon = newRow.insertCell();

		cellId.appendChild(document.createTextNode(produtos[i].id));
		cellNome.appendChild(document.createTextNode(produtos[i].nome));
		cellPreco.appendChild(document.createTextNode(produtos[i].preco));
		cellButon.appendChild(button);
	}
}

function limparTabela(){
	var tbodyRef = document.getElementById('tabela-produto').getElementsByTagName('tbody')[0];
	
	for(i=0; i < tbodyRef.rows.length; i++){
		tbodyRef.deleteRow(0);
	}
}

function insereProdutoNaComanda(idProd, idComan, qtd){
	try{
		var produtoComan = {quantidade: "", produto: { id: "" }};
		produtoComan.quantidade = qtd;
		produtoComan.produto.id = idProd;
		
		var url = host+"/api/comanda/produto/"+idComan;
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(putRequest(url, header, JSON.stringify(produtoComan)));
		if(response.error != null){
            alert("Falha ao inserir produto na comanda");
        }else{
      		window.location.replace(window.location.search); 	
        }
	} catch (error) {
        console.log("Falha na chamada do get " + error);
        alert(error)
    }
}

function deleteProdutoComanda(id){
	try{
		var url = host+"/api/comanda/produto/"+id;
		var header = [["Content-Type","application/json"]];
		deleteRequest(url, header);
      	window.location.replace(window.location.search); 	
	} catch (error) {
        console.log("Falha na chamada do get " + error);
        alert(error)
    }
}


function popularEndereco(endereco){  	
	document.getElementById("address-cliente").value = endereco.address;
	document.getElementById("state-cliente").value = endereco.state;
	document.getElementById("district-cliente").value = endereco.district;
	document.getElementById("city-cliente").value = endereco.city;
}

	
function getCep(){
	try{
		var url = host+"/api/cliente/cep/"+document.getElementById("cep-cliente").value;
		var header = [["Content-Type","application/json"]];
		var response = JSON.parse(getRequest(url, header));
		if(response.error != null){
            alert("Falha ao inserir produto na comanda");
        }else{
      		popularEndereco(response);
        }
		
	} catch (error) {
        console.log("Falha na chamada do get " + error);
        alert(error)
    }
}