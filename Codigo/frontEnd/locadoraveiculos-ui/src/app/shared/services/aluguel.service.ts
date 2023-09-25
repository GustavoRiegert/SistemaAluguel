import { Injectable } from '@angular/core';
import { AluguelModel } from '../models/aluguel.model';
import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AluguelService extends BaseService {

  constructor(protected httpClient: HttpClient) {
    super(httpClient);
  }

  create(aluguel: AluguelModel) {
    return this.post('/aluguel', aluguel);
  }

  getAll() {
    return this.get('/aluguel');
  }
}
