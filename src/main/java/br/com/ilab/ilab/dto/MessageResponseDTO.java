package br.com.ilab.ilab.dto;

public class MessageResponseDTO {


		private String message;


		public MessageResponseDTO(String message, String token) {
			super();
			this.message = message;

		}


		public MessageResponseDTO(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}




