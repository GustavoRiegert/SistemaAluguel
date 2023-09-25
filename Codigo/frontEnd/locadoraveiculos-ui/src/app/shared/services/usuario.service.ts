import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioModel } from '../models/usuario.model';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService extends BaseService {

  constructor(protected httpClient: HttpClient) {
    super(httpClient);
  }

  login(usuario: UsuarioModel) {
    return this.post('/usuario/login', usuario);
  }
}
