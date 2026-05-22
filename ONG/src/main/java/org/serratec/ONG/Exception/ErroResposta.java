package org.serratec.ONG.Exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta extends RuntimeException {

  private int status;
  private String mensagem;
  private LocalDateTime horaErro;
  private List<String> erros;

  public ErroResposta(int status, String mensagem) {
    this.status    = status;
    this.mensagem  = mensagem;
    this.horaErro = LocalDateTime.now();
  }

  public ErroResposta(int status, String mensagem, List<String> erros) {
    this(status, mensagem);
    this.erros = erros;
  }

  public int getStatus() {
    return status;
  }

  public String getMensagem() {
    return mensagem;
  }

  public LocalDateTime getHoraErro() {
    return horaErro;
  }

  public List<String> getErros() {
    return erros;
  }
}
