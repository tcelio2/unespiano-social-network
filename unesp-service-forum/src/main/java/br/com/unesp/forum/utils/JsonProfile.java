package br.com.unesp.forum.utils;

public class JsonProfile {
	  /*
	   * Mais restritivo
	   *       ||
	   *       ||
	   *      \||/
	   *       \/
	   * Menos restritivo
	   */
	  public interface PublicView {} 
	  public interface ReducedView extends PublicView {}
	  public interface ExpandedView extends ReducedView {} // Inclui atributos do BaseModel
	}
