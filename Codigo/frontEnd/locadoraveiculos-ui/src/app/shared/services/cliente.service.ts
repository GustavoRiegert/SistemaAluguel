import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClienteModel } from '../models/cliente.model';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ClienteService extends BaseService {

  constructor(protected httpClient: HttpClient) {
    super(httpClient);
   }

  saveCliente(cliente: ClienteModel) {
    return this.post("/cliente", cliente);
  }

  getAllCliente() {
    return this.get("/cliente");
  }

  getOneCliente(id: string) {
    return this.get("/cliente/" + id);
  }

  deleteCliente(id: string) {
    return this.delete("/cliente/" + id);
  }

  updateCliente(cliente: ClienteModel, id: string) {
    return this.put("/cliente/" + id, cliente);
  }
}
