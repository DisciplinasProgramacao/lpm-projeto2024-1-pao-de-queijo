public class Cardapio {
    private final Prato[] pratos = {
            new MoquecaDePalmito(),
            new FalafelAssado(),
            new SaladaPrimaveraComMacarraoKonjac(),
            new EscondidinhoDeInhame(),
            new StrogonoffDeCogumelos()
    };

    private final Bebida[] bebidas = {
            new Agua(),
            new CopoDeSuco(),
            new RefrigeranteOrganico(),
            new CervejaVegana(),
            new TacaDeVinhoVegano()
    };

    /**
     * Obtém a lista de pratos disponíveis.
     * @return Lista de pratos.
     */
    public Prato[] getPratos() {
        return pratos;
    }

    /**
     * Obtém a lista de bebidas disponíveis.
     * @return Lista de bebidas.
     */
    public Bebida[] getBebidas() {
        return bebidas;
    }
}
