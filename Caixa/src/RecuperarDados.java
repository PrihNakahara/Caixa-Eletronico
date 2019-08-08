public class RecuperarDados {
	
	private int mat [] [] = new int [6] [2];
	private int cotaMinima;
	private String valorTotalSaldo = "";
	
	public RecuperarDados() {
		mat[0][0] = 100; 
		mat[1][0] = 50; 
		mat[2][0] = 20; 
		mat[3][0] = 10; 
		mat[4][0] = 5; 
		mat[5][0] = 2; 

		mat[0][1] = 100; 
		mat[1][1] = 200; 
		mat[2][1] = 300; 
		mat[3][1] = 350; 
		mat[4][1] = 450; 
		mat[5][1] = 500; 

	}

	public int[][] getMat() {
		return mat;
	}

	public void setMat(int[][] mat) {
		this.mat = mat;
	}

	public int getCotaMinima() {
		return cotaMinima;
	}

	public void setCotaMinima(int cotaMinima) {
		this.cotaMinima = cotaMinima;
	}

	public String getValorTotalSaldo() {
		return valorTotalSaldo;
	}

	public void setValorTotalSaldo(String valorTotalSaldo) {
		this.valorTotalSaldo = valorTotalSaldo;
	}
	
}
