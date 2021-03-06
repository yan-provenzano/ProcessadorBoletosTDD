import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProcessadorBoletosTest {

	@Test
	public void verificaPagamento1() {
		ProcessadorBoleto p = new ProcessadorBoleto();
		
		Fatura f = new Fatura();
		f.setCliente("Yan");
		f.setData("10/02/2021");
		f.setValorTotal(750.00);
		
		Boleto b1 = new Boleto();
		b1.setData("01/03/2021");
		b1.setCodigo("2222");
		b1.setValorPago(450.00);
		
		Boleto b2 = new Boleto();
		b2.setData("06/03/2021");
		b2.setCodigo("3333");
		b2.setValorPago(500.00);
		
		List<Boleto> listaBoleto = new ArrayList<>();
		listaBoleto.add(b1);
		listaBoleto.add(b2);
		
		boolean atual = p.processa(f, listaBoleto);
		
		assertTrue(atual);
	}
	
	
	
	@Test
	public void verificaPagamento2() {
		ProcessadorBoleto p = new ProcessadorBoleto();
		
		Fatura f = new Fatura();
		f.setCliente("Beatriz");
		f.setData("10/02/2021");
		f.setValorTotal(700.00);
		
		Boleto b1 = new Boleto();
		b1.setData("02/03/2021");
		b1.setCodigo("1111");
		b1.setValorPago(400.00);
		
		Boleto b2 = new Boleto();
		b2.setData("05/03/2021");
		b2.setCodigo("4444");
		b2.setValorPago(100.00);
		
		List<Boleto> listaBoleto = new ArrayList<>();
		listaBoleto.add(b1);
		listaBoleto.add(b2);
		
		boolean atual = p.processa(f, listaBoleto);
		
		assertFalse(atual);
	}

}