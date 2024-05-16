package main.java.com.paodequeijo.restaurante.Models;
public abstract class Cardapio {
    //#region Atributos de classe
    private static String descricao;
    private static Item[] itens;
    //#endregion

    //#region Contrutor
    protected Cardapio(String descricao, Item[] itens) {
        init(descricao, itens);
    }
    //#endregion

    //#region Inicializador
    private void init(String descricao, Item[] itens) {
        this.descricao = descricao;
        this.itens = itens;
    }
    //#endregion

    //#region Métodos de negócio
 
    
    public static String mostrarMenu(){
        StringBuilder sb = new StringBuilder();

        sb.append("////// " + descricao + " //////");
        sb.append("\n");
        for (int i = 0; i < itens.length; i++) {
            sb.append((i+1) + ": " + itens[i].descricao);
            sb.append("\n");
        }
        
        return sb.toString();
    }

    /**
     * Retorna o Item correspondente ao numero escolhido.
     * @param opcao
     * @return
     */
    public Item itemEscolhido(int opcao){
        int pos = opcao - 1;
        return itens[pos];
    }
    //#endregion
}
