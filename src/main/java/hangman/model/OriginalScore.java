package hangman.model;


import hangman.exception.*;

public class OriginalScore implements GameScore{
	
	final int penal=10;
	final int puntajeInicial=100;
	
	/**
	 * Pre: Se recibe la cantidad de letras correctas e incorrectas.
	 * Pos: Retorna el puntaje total dependiendo de las penalizaciones.
	 * @param correctCount: Cantidad de letras correctas.
	 * @param incorrectCount: Cantidad de letras incorrectas.
	 */
	public int calculateScore(int correctCount, int incorrectCount) throws ScoreException{
		if(correctCount<0 || incorrectCount<0 || (correctCount==0 && incorrectCount==0)) {
			throw new ScoreException(ScoreException.INVALID_VALUE); 
		}
		
		int puntaje=puntajeInicial;
		puntaje-=penal*incorrectCount;
		if(puntaje<0) puntaje=0;
		return puntaje;
	}
	
}