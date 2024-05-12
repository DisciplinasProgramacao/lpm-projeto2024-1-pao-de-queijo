public class CardapioBebidas extends Cardapio {
    //#region Construtor
    public CardapioBebidas() {
        super("Cardápio de Bebidas", inicializarBebidas());
    }
    //#endregion

    private static Item[] inicializarBebidas() {
        return new Item[] {
            new Agua(),
            new CopoDeSuco(),
            new RefrigeranteOrganico(),
            new CervejaVegana(),
            new TacaDeVinhoVegano()
        };
    };
}
