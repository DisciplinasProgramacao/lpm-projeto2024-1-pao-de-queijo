package main.java.com.paodequeijo.restaurante.Models;
public class CardapioPratos extends Cardapio {

    //#region Construtor
    public CardapioPratos() {
        super("Cardápio de Pratos", inicializarPratos());
    }
    //#endregion

    private static Item[] inicializarPratos() {
        return new Item[] {
            new MoquecaDePalmito(),
            new FalafelAssado(),
            new SaladaPrimaveraComMacarraoKonjac(),
            new EscondidinhoDeInhame(),
            new StrogonoffDeCogumelos()
        };
    }
}