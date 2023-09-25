import { ClienteModel } from "./cliente.model";

export interface AluguelModel {
    automovel: string,
    cliente: ClienteModel,
    statusContrato: string,
    dataInicio: string,
    dataFim: string,
    valorAluguel: number,
    valorCaucao: number
}