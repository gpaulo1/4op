package org.dev_module.enumerator;

public enum MensagensEnum {

	NOT_FOUND_DATA("Nenhum registro foi encontrado!"),
	
	MSG_SUCCESS("Registro inserido com sucesso!"),
	
	MSG_REMOVE_SUCEES("Registro removido com sucesso!"),	
	
	MSG_ERROR("Erro ao completar a operação. Verifique sua conexão ou entre em contato com nosso suporte!");
	
	private String messagesRepository;
	
	private MensagensEnum(String msg) {
		messagesRepository = msg;
	}
	
	public String getMessage(){
		return messagesRepository;
	}
	
}
