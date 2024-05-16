package main.java.com.paodequeijo.restaurante.Models;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class RestauranteTest {

    @Test
    public void testBuscarClienteExistente() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");
        Cliente cliente = new Cliente("João", "12345678900");
        restaurante.adicionarCliente(cliente);

        Cliente clienteEncontrado = restaurante.buscarCliente("12345678900");

        assertNotNull(clienteEncontrado);
        assertEquals(cliente, clienteEncontrado);
    }

    @Test
    public void testBuscarClienteNaoExistente() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");

        Cliente clienteEncontrado = restaurante.buscarCliente("99999999999");

        assertNull(clienteEncontrado);
    }

    @Test
    public void testCriarRequisicaoComMesaDisponivel() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");
        Cliente cliente = new Cliente("Maria", "98765432100");

        restaurante.criarRequisicao(cliente, 4);

        assertFalse(restaurante.getRequisicoesPendentes().isEmpty());
    }

    @Test
    public void testCriarRequisicaoSemMesaDisponivel() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");
        Cliente cliente = new Cliente("Pedro", "12312312300");

        restaurante.criarRequisicao(cliente, 10);

        assertFalse(restaurante.getRequisicoesPendentes().isEmpty());
    }

    @Test
    public void testProcurarMesaExistente() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");
        Mesa mesa = new Mesa(4);
        restaurante.getMesas().add(mesa);

        Mesa mesaEncontrada = restaurante.procurarMesa(4);

        assertNotNull(mesaEncontrada);
        assertEquals(mesa, mesaEncontrada);
    }

    @Test
    public void testProcurarMesaInexistente() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");

        Mesa mesaEncontrada = restaurante.procurarMesa(6);

        assertNull(mesaEncontrada);
    }

    @Test
    public void testFinalizarRequisicaoExistente() {
        Restaurante restaurante = new Restaurante("Meu Restaurante");
        Cliente cliente = new Cliente("Ana", "11122233300");
        Mesa mesa = new Mesa(4);
        Requisicao requisicao = new Requisicao(cliente, mesa);
        restaurante.adicionarRequisicaoAtendida(requisicao);

        restaurante.finalizarRequisicao(mesa.getNumero());

        assertTrue(restaurante.getRequisicoesAtendidas().isEmpty());
        assertFalse(restaurante.getRequisicoesFinalizadas().isEmpty());
    }
}
