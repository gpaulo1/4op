package org.dev_module.BO;

import org.dev_module.model.Cliente;

public class FormatarClienteFornecedorBO {

	public static Cliente formatInputs(Cliente cliente){
		
			if(cliente.getEmail().equals("")){
				cliente.setEmail(null);
			}
			if(cliente.getFantasia().equals("")){
				cliente.setFantasia(null);
			}
			if(cliente.getInscricaoMunicipal().equals("")){
				cliente.setInscricaoMunicipal(null);
			}
			if(cliente.getNome().equals("")){
				cliente.setNome(null);
			}
			if(cliente.getRazaoSocial().equals("")){
				cliente.setRazaoSocial(null);
			}
			if(cliente.getRg().equals("")){
				cliente.setRg(null);
			}
			if(cliente.getTelefone().equals("")){
				cliente.setTelefone(null);
			}
			
			if(cliente.getLocalizacao().getBairro().equals("")){
				cliente.getLocalizacao().setBairro("");
			}
			if(cliente.getLocalizacao().getCep().equals("")){
				cliente.getLocalizacao().setCep("");
			}
			if(cliente.getLocalizacao().getCidade().equals("")){
				cliente.getLocalizacao().setCidade("");
			}
			if(cliente.getLocalizacao().getEstado().equals("")){
				cliente.getLocalizacao().setEstado("");
			}
			if(cliente.getLocalizacao().getLogradouro().equals("")){
				cliente.getLocalizacao().setLogradouro("");
			}
			if(cliente.getLocalizacao().getNumero().equals("")){
				cliente.getLocalizacao().setNumero("");
			}
			
			
			return cliente;
			
	}
	
}
