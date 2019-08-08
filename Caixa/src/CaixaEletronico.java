import java.awt.EventQueue;

public class CaixaEletronico implements IcaixaEletronico{
	
	private RecuperarDados recuperarDados = new RecuperarDados();
	
	public String pegaRelatorioCedulas() {
	//logica de fazer o relatorio de cedulas
	String resposta = "";
	
	int mat [] [] = recuperarDados.getMat();
		for(int y = 0;y < 6;y++) {
			String tam = ""+mat[y][0];
			
			if(tam.length() == 3) {
				resposta = "Valor da cédula: "+mat[y][0]+"| Quantidade de cédula: "+mat[y][1]+"  <br>";
			}
			if(tam.length() == 2) {
				resposta += " Valor da cédula:  "+mat[y][0]+"| Quantidade de cédula: "+mat[y][1]+"  <br>";
			}
			if(tam.length() == 1) {
				resposta += " Valor da cédula:   "+mat[y][0]+"| Quantidade de cédula: "+mat[y][1]+" <br>";
			}
		}
		resposta += "</html>";
		return resposta;
	}
	public String pegaValorTotalDisponivel() {
		//logica de pega o valor total disponivel no caixa eletronio
		String resposta = "";
		int mat [] [] = recuperarDados.getMat();
		int valorMatriz[]= new int[6];
		
		valorMatriz[0]=mat[0][0]*mat[0][1];
		valorMatriz[1]=mat[1][0]*mat[1][1];
		valorMatriz[2]=mat[2][0]*mat[2][1];
		valorMatriz[3]=mat[3][0]*mat[3][1];
		valorMatriz[4]=mat[4][0]*mat[4][1];
		valorMatriz[5]=mat[5][0]*mat[5][1];
		
		resposta =("R$"+(valorMatriz[0]+valorMatriz[1]+valorMatriz[2]+valorMatriz[3]+
				valorMatriz[4]+valorMatriz[5]));
		return resposta;
	}
	public String reposicaoCedulas(Integer cedula, Integer quantidade) {
	//logica de fazer a reposicao de cedulas e criar uma mensagem (resposta) ao usuario
		String resposta = "";
		int mat [] [] = recuperarDados.getMat();
		switch (cedula)	{
			case 100: {
				mat [0][1] += quantidade;
				resposta = "Reposicão de notas de 100 efetuada com sucesso!";
				break;
			}
			case 50: {
				mat [1][1] += quantidade;
				resposta = "Reposicão de notas de 50 efetuada com sucesso!";
				break;
			}
			case 20: {
				mat [2][1] += quantidade;
				resposta = "Reposicão de notas de 20 efetuada com sucesso!";
				break;
			}
			case 10: {
				mat [3][1] += quantidade;
				resposta = "Reposicão de notas de 10 efetuada com sucesso!";
				break;
			}
			case 5: {
				mat [4][1] += quantidade;
				resposta = "Reposicão de notas de 5 efetuada com sucesso!";
				break;
			}
			case 2: {
				mat [5][1] += quantidade;
				resposta = "Reposicão de notas de 2 efetuada com sucesso!";
				break;
			}
			default: 
				resposta = "Erro ao repor cédula, valor inválido!";
		}
		return resposta;	
	}
	public String sacar(Integer valor) { 
	//logica de sacar do caixa eletronico e criar um mensagem(resposta) ao usuario
	String resposta = "";
	int cotaMinima = recuperarDados.getCotaMinima();
	int sub,valorDisponivel=0,extrato=0;
	int mat [] [] = recuperarDados.getMat();
	int quantidade[] = new int[6];
	int valorMatriz[] = new int [6];
	valorMatriz[0]=mat[0][0]*mat[0][1];
	valorMatriz[1]=mat[1][0]*mat[1][1];
	valorMatriz[2]=mat[2][0]*mat[2][1];
	valorMatriz[3]=mat[3][0]*mat[3][1];
	valorMatriz[4]=mat[4][0]*mat[4][1];
	valorMatriz[5]=mat[5][0]*mat[5][1];
	
	valorDisponivel=valorMatriz[0]+valorMatriz[1]+valorMatriz[2]+
			valorMatriz[3]+valorMatriz[4]+valorMatriz[5];
		if(valor<=valorDisponivel) {
			if(cotaMinima<=valorDisponivel) {
				String valorExtrato; 
				String escritaExtrato;
				String extratoValor = recuperarDados.getValorTotalSaldo();
				extrato = (valor);
				valorExtrato = ("<html><br>Foi sacado: R$"+extrato + extratoValor+"</html>");
				recuperarDados.setValorTotalSaldo(valorExtrato);
				
			if(valorMatriz[0]>=valor) {
					if(mat[0][1]>0) {
						quantidade[0]=valor/mat[0][0];
						mat[0][1]=mat[0][1]-quantidade[0];
						sub=quantidade[0]*mat[0][0];
						valor=valor-sub;	
					}
				}
				if(valorMatriz[0]<valor) {
					if(mat[0][1]>0) {
						quantidade[0]=mat[0][1];
						mat[0][1]=0;
						sub=quantidade[0]*mat[0][0];
						valor=valor-sub;
						}
					}
					if(valorMatriz[1]>=valor) {
						if(mat[1][1]>0) {
							quantidade[1]=valor/mat[1][0];
							mat[1][1]=mat[1][1]-quantidade[1];
							sub=quantidade[1]*mat[1][0];
							valor=valor-sub;	
						}
					}
					if(valorMatriz[1]<valor) {
						if(mat[1][1]>0) {
							quantidade[1]=mat[1][1];
							mat[1][1]=0;
							sub=quantidade[1]*mat[1][0];
							valor=valor-sub;
						}
					}
					if(valorMatriz[2]>=valor) {
						if(mat[2][1]>0) {
							quantidade[2]=valor/mat[2][0];
							mat[2][1]=mat[2][1]-quantidade[2];
							sub=quantidade[2]*mat[2][0];
							valor=valor-sub;	
						}
					}
					if(valorMatriz[2]<valor) {
						if(mat[2][1]>0) {
							quantidade[2]=mat[2][1];
							mat[2][1]=0;
							sub=quantidade[2]*mat[2][0];
							valor=valor-sub;
						}
					}
					if(valorMatriz[3]>=valor) {
						if(mat[3][1]>0) {
							quantidade[3]=valor/mat[3][0];
							mat[3][1]=mat[3][1]-quantidade[3];
							sub=quantidade[3]*mat[3][0];
							valor=valor-sub;	
						}
					}
				if(valorMatriz[3]<valor) {
					if(mat[3][1]>0) {
					quantidade[3]=mat[3][1];
					mat[3][1]=0;
					sub=quantidade[3]*mat[3][0];
					valor=valor-sub;
					}
				}
			if(valorMatriz[4]>=valor) {
				if(mat[4][1]>0) {
					quantidade[4]=valor/mat[4][0];
					mat[4][1]=mat[4][1]-quantidade[4];
					sub=quantidade[4]*mat[4][0];
					valor=valor-sub;	
				}
			}
			if(valorMatriz[4]<valor) {
				if(mat[4][1]>0) {
					quantidade[4]=mat[4][1];
					mat[4][1]=0;
					sub=quantidade[4]*mat[4][0];
					valor=valor-sub;
				}
			}
			if(valorMatriz[5]>=valor) {
				if(mat[5][1]>0) {
					if(valor%2==0){
						quantidade[5]=valor/mat[5][0];
						mat[5][1]=mat[5][1]-quantidade[5];
						sub=quantidade[5]*mat[5][0]; 
						valor=valor-sub;	
					}
					else {
						quantidade[5]=valor/mat[5][0];
						sub=quantidade[5]*mat[5][0];
						quantidade[5]=quantidade[5]+1;
						mat[5][1]=mat[5][1]-quantidade[5];
						valor=valor-sub;
					}
				}
			}
			if(valorMatriz[5]<valor) {
				if(mat[5][1]>0) {
					quantidade[5]=mat[5][1];
					mat[5][1]=0;
					sub=quantidade[5]*mat[5][1];
					valor=valor-sub;
				}
			}	
			resposta = "<html>Saque efetuado com sucesso!<br> O valor foi dividido em:<br>R$100:"+quantidade[0]+
					"<br>R$50:"+quantidade[1]+"<br>R$20:"+quantidade[2]+"<br>R$10:"+quantidade[3]+"<br>R$5:"+quantidade[4]+
					"<br>R$2:"+quantidade[5]+"</html>";
			quantidade[0]=0;
			quantidade[1]=0;
			quantidade[2]=0;
			quantidade[3]=0;
			quantidade[4]=0;
			quantidade[4]=0;
		}	
		else 
			resposta = "Caixa Vazio, chame o Operador!";
		}
		else {
			resposta = "Saque não realizado por falta de cédulas!";
		}
		return resposta;
	}
	public String armazenaCotaMinima(Integer minimo) {
	String resposta = "";
	//logica de armazenar a cota minima para saque e criar um mensagem(resposta) ao usuario
		recuperarDados.setCotaMinima(minimo);
		resposta = "Cota Mínima armazenada com sucesso!";
	return resposta;
	}
	public String pegarSaldo() {
		String retornoSaldo = recuperarDados.getValorTotalSaldo();
		return retornoSaldo;
	}
	public static void main(String arg[]){
		GUI janela = new GUI();
		janela.show();
	}
} 