import { ClienteModel } from "./cliente.model";

export interface EmpregoModel {
    descricao: string,
    renda: number,
    ativo: boolean,
    cliente: ClienteModel
}