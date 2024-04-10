import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RequisicaoTest {

    private Requisicao requisicao;
    private Cliente cliente;
    private Mesa mesa;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João", "123456789");
        Date data = new Date();
        Date horaEntrada = new Date();
        requisicao = new Requisicao(1, data, horaEntrada, cliente);

        mesa = new Mesa(1, 4); // Exemplo de criação de uma Mesa. A classe Mesa deve ser definida para este teste.
    }

    @Test
    public void testConstrutor() {
        assertNotNull(requisicao);
        assertEquals(1, requisicao.getId());
        assertNotNull(requisicao.getData());
        assertNotNull(requisicao.getHoraEntrada());
        assertEquals(cliente, requisicao.getCliente());
        assertFalse(requisicao.isAtendida());
        assertNull(requisicao.getMesa());
    }

    @Test
    public void testFinalizar() {
        LocalDateTime horaSaida = LocalDateTime.now();
        requisicao.finalizar(horaSaida);

        assertTrue(requisicao.isAtendida());
        assertEquals(horaSaida, requisicao.getHoraSaida());
        assertTrue(Restaurante.requisicoesFinalizadas.contains(requisicao));
    }

    @Test
    public void testAssociarMesa() {
        requisicao.associarMesa(mesa);

        assertEquals(mesa, requisicao.getMesa());
        assertTrue(Restaurante.requisicoesAtendidas.contains(requisicao));
        assertFalse(Restaurante.requisicoesPendentes.contains(requisicao));
    }
}