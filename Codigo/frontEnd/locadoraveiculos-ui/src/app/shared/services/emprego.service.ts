import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { EmpregoModel } from '../models/emprego.model';

@Injectable({
  providedIn: 'root'
})
export class EmpregoService extends BaseService {

  constructor(httpClient: HttpClient) { 
    super(httpClient);
  }

  create(emprego: EmpregoModel) {
    return this.post('/emprego', emprego);
  }
}
