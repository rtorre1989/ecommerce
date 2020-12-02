export class ProdutoModel {
    id: number;
    descricao: string;
    estoque: number;
    valor: number;

    public getEstoqueDescricao(){
        return this.estoque <= 0 ? "SEM ESTOQUE" : "COM ESTOQUE";
    }
}